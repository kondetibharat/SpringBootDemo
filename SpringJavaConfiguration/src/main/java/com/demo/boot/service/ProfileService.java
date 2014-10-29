package com.demo.boot.service;

public class ProfileService {

    public void init() {
        System.out.println("In ProfileService init method...");
    }

    public void getCustomerProfile() {
        System.out.println("In ProfileService returning customer information...");
    }

    public void cleanup() {
        System.out.println("In ProfileService cleanup method...");
    }
}
