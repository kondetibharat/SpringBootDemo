package com.demo.boot.context;


import com.demo.boot.service.ProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
@ImportResource({"classpath*:/spring-config.xml"})
@Import(SpringDaoContext.class)
@ComponentScan({"com.demo.boot.service"})
public class SpringContext {

    @Bean(initMethod = "init", destroyMethod = "cleanup")
    @Scope("singleton")
    public ProfileService profileService() {
        return new ProfileService();
    }
}
