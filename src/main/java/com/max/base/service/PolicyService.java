package com.max.base.service;

import com.max.base.exception.PolicyNotFoundException;
import com.max.base.model.Policy;
import com.max.base.repository.PolicyRepository;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PolicyService {

    private static final Logger logger = Logger.getLogger(PolicyService.class.getName());

    private final PolicyRepository repository = new PolicyRepository();

    public void createPolicy(Policy policy){
        repository.addPolicy(policy);
        logger.info("Policy created with number: " + policy.getPolicyNumber());
    }

    public List<Policy> getHighPremiumPolicies(double amount){
        logger.info("Fetching policies with premium greater than: " + amount);
        return repository.getAllPolicie()
                .stream()
                .filter(p -> p.calculatePremium() > amount)
                .collect(Collectors.toList());
    }

    public Policy getPolicyByNumber(String policyNumber){
        logger.info("Searching policy with number: " + policyNumber);
        return repository.getPolicyByNumber(policyNumber);
    }
}
