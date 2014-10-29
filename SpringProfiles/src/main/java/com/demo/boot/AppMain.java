package com.demo.boot;

import com.demo.boot.context.SpringContext;
import com.demo.boot.dao.AddressDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        //System.setProperty("spring.profiles.active", "prod");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(SpringContext.class);
        ctx.refresh();

        AddressDAO service = ctx.getBean(AddressDAO.class);

        service.getAddressById("12345");

        ctx.close();
    }
}
