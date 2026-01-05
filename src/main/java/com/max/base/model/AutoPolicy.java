package com.max.base.model;

import com.max.base.enums.PolicyType;

public class AutoPolicy extends Policy{

    private int vehicleAge;

    public AutoPolicy(String policyNumber, double premiumAmount, int vehicleAge){
        this.policyNumber = policyNumber;
        this.policyType = PolicyType.AUTO;
        this.premiumAmount = premiumAmount;
        this.vehicleAge = vehicleAge;
    }

    @Override
    public double calculatePremium() {
        if (vehicleAge > 5 ){
            return premiumAmount * 1.25;     // higher risk
        }
        return premiumAmount * 1.10;
    }
}
