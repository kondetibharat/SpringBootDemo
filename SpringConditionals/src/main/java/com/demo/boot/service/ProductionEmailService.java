package com.demo.boot.service;

/**
 * Created by kondetib on 10/28/14.
 */
public class ProductionEmailService implements EmailService {

    @Override
    public void sendEmail() {
        System.out.println("Calling production email service...");
    }
}
