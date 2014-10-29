package com.demo.boot.context;


import com.demo.boot.service.EmailService;
import com.demo.boot.service.ProductionEmailService;
import com.demo.boot.service.TestEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.demo.boot.service"})
public class SpringContext {

    @Bean(name="emailService")
    @Conditional(TestConditional.class)
    public EmailService testEmailerService(){
        return new TestEmailService();
    }

    @Bean(name="emailService")
    @Conditional(ProductionConditional.class)
    public EmailService productionEmailService(){
        return new ProductionEmailService();
    }
}
