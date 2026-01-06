import com.max.base.exception.PolicyNotFoundException;
import com.max.base.model.HealthPolicy;
import com.max.base.model.Policy;
import com.max.base.service.PolicyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PolicyServiceTest {

    private PolicyService policyService;

    @BeforeEach
    void setup(){
        policyService = new PolicyService();
    }

    void createPolicy_shouldStorePolicySuccessfully(){
        Policy policy = new HealthPolicy("P1001", 1000);

        policyService.createPolicy(policy);

        Policy foundPolicy = policyService.getPolicyByNumber("P1001");

        assertNotNull(foundPolicy);
        assertEquals("P1001", foundPolicy.getPolicyNumber());
    }

    @Test
    void getPolicyByNumber_shouldThrowException_whenPolicyNotFound() {

        Exception exception = assertThrows(
                PolicyNotFoundException.class,
                () -> policyService.getPolicyByNumber("INVALID")
        );

        assertEquals(
                "Policy not found with number: INVALID",
                exception.getMessage()
        );
    }

    @Test
    void getHighPremiumPolicies_shouldReturnOnlyHighPremiumPolicies() {

        policyService.createPolicy(new HealthPolicy("P1", 1000));
        policyService.createPolicy(new HealthPolicy("P2", 5000));

        var result = policyService.getHighPremiumPolicies(3000);

        assertEquals(1, result.size());
        assertEquals("P2", result.get(0).getPolicyNumber());
    }


}
