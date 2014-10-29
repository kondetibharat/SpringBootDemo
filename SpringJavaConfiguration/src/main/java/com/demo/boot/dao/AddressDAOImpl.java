package com.demo.boot.dao;


import javax.sql.DataSource;

public class AddressDAOImpl implements AddressDAO {

    private DataSource dataSource;

    public AddressDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void getAddressById(String id) {
        System.out.println("In AddressDaoImpl returning address for customer id " + id);
    }

}
