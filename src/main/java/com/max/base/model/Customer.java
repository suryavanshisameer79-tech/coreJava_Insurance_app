package com.max.base.model;


// Create Customer (Encapsulation)
public class Customer {

    private final Long customerId;
    private String name;
    private String email;
    private Address address;

    public Customer(Long customerId, String name, String email, Address address) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
