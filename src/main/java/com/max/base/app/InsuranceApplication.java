package com.max.base.app;

import com.max.base.model.AutoPolicy;
import com.max.base.model.HealthPolicy;
import com.max.base.model.LifePolicy;
import com.max.base.model.Policy;
import com.max.base.service.PolicyService;

import java.util.List;

public class InsuranceApplication {

   /* private static void printPremium(Policy policy){
        System.out.println(policy.getPolicyNumber()+ " Final Premium: " + policy.calculatePremium());
    }

    public static void main(String[] args) {

        Policy healthPolicy = new HealthPolicy("HP-101", 5000);
        Policy autoPolicy = new AutoPolicy("AP-201", 3000, 7);
        Policy lifePolicy = new LifePolicy("LP-301", 8000, 55);

        printPremium(healthPolicy);
        printPremium(autoPolicy);
        printPremium(lifePolicy);
    }*/

    public static void main(String[] args) {

        // 1️⃣ Create policies
        PolicyService service = new PolicyService();
        service.createPolicy(new HealthPolicy("H101", 1000));
        service.createPolicy(new AutoPolicy("A201", 5500, 7));
        service.createPolicy(new LifePolicy("L301", 2000, 24));

        List<Policy> highPremiumPolicies = service.getHighPremiumPolicies(2000);

        highPremiumPolicies.forEach(p -> System.out.println(p.getPolicyNumber() + " --> " + p.calculatePremium())
        );

        // 2️⃣ Fetch existing policy (SUCCESS case)
        System.out.println("---- Fetch Existing Policy ----");
        Policy foundPolicy = service.getPolicyByNumber("H101");
        System.out.println("Policy Found: " + foundPolicy.getPolicyNumber());

        // 3️⃣ Fetch non-existing policy (EXCEPTION case)
        System.out.println("---- Fetch Non Existing Policy ----");
        service.getPolicyByNumber("HP-999"); // should throw exception
    }
}
