package com.demo.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @Autowired
    EmailService emailService;

    public void emailCustomer() {
        emailService.sendEmail();
    }
}
