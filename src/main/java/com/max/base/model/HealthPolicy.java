package com.max.base.model;

import com.max.base.enums.PolicyType;

// Create Concrete Policy (Inheritance + Polymorphism)

public class HealthPolicy extends Policy{

    public HealthPolicy(String policyNumber, double premiumAmount){
        this.policyNumber = policyNumber;
        this.policyType = PolicyType.HEALTH;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public double calculatePremium() {
        return premiumAmount * 1.18;             //tax + risk factor
    }
}
