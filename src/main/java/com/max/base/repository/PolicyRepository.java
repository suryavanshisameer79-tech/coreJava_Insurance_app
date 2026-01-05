package com.max.base.repository;

import com.max.base.exception.PolicyNotFoundException;
import com.max.base.model.Policy;

import java.util.ArrayList;
import java.util.List;

public class PolicyRepository {

    private final List<Policy> policies = new ArrayList<>();

    public void addPolicy(Policy policy){
        policies.add(policy);
    }

    public List<Policy> getAllPolicie(){
        return policies;
    }

    public Policy getPolicyByNumber(String policyNumber) {

        return policies.stream()
                .filter(p -> p.getPolicyNumber().equals(policyNumber))
                .findFirst()
                .orElseThrow(() ->
                        new PolicyNotFoundException(
                                "Policy not found with number: " + policyNumber
                        )
                );
    }
}
