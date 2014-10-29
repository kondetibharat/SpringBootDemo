package com.demo.boot;

import com.demo.boot.context.SpringContext;
import com.demo.boot.service.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringContext.class);

        CustomerService service = ctx.getBean(CustomerService.class);

        service.getCustomerInformation();

        ctx.close();
    }
}
