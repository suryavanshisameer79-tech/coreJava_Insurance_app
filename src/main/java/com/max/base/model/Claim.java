package com.max.base.model;

import com.max.base.enums.ClaimStatus;

public class Claim {
    private String claimId;
    private ClaimStatus status;
    private double claimAmount;

    public Claim(String claimId, ClaimStatus status, double claimAmount) {
        this.claimId = claimId;
        this.status = status;
        this.claimAmount = claimAmount;
    }

    public void approve() {
        this.status = ClaimStatus.APPROVED;
    }
}
