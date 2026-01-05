package com.max.base.model;

//Create Abstract Policy (Abstraction)
//✔ Abstract class → cannot be instantiated
//✔ Forces child classes to implement logic

import com.max.base.enums.PolicyType;

public abstract class Policy {

    protected String policyNumber;
    protected PolicyType policyType;
    protected double premiumAmount;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public abstract double calculatePremium();

}
