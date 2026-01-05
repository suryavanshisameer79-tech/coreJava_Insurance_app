package com.max.base.model;

import com.max.base.enums.PolicyType;

public class LifePolicy extends Policy{

    private int age;

    public LifePolicy(String policyNumber, double premiumAmount, int age){
            this.policyNumber = policyNumber;
            this.policyType = PolicyType.LIFE;
            this.premiumAmount = premiumAmount;
            this.age = age;
    }

    @Override
    public double calculatePremium() {
        if (age > 50){
            return premiumAmount * 1.40;
        }
        return premiumAmount * 1.20;
    }
}
