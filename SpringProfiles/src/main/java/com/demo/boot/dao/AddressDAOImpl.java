package com.demo.boot.dao;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class AddressDAOImpl implements AddressDAO {

    private DataSource dataSource;

    public AddressDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void getAddressById(String id) {
        System.out.println("dataSource URL is... " + ((DriverManagerDataSource)dataSource).getUrl());
    }

}
