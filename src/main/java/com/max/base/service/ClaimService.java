package com.max.base.service;

import com.max.base.model.Claim;

public interface ClaimService {

    void submitClaim(Claim claim);
    void approveClaim(Claim claim);
}
