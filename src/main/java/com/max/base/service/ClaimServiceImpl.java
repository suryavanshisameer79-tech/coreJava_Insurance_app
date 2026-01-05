package com.max.base.service;

import com.max.base.model.Claim;

public class ClaimServiceImpl implements ClaimService{
    @Override
    public void submitClaim(Claim claim) {
        System.out.println("Claim submitted: " + claim);
    }

    @Override
    public void approveClaim(Claim claim) {
        claim.approve();
        System.out.println("Claim approved");
    }
}
