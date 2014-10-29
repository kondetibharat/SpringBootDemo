package com.demo.boot.service;

import com.demo.boot.dao.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @Autowired
    AddressDAO addressDAO;

    @Autowired
    ProfileService profileService;

    public void getCustomerInformation() {
        System.out.println("In CustomerService returning customer information...");
        profileService.getCustomerProfile();
        addressDAO.getAddressById("12345");
    }
}
