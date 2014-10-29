package com.demo.boot.context;


import com.demo.boot.dao.AddressDAO;
import com.demo.boot.dao.AddressDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({SpringDefaultContext.class, SpringProdContext.class})
@ComponentScan({"com.demo.boot.service"})
public class SpringContext {
    @Autowired
    DataSourceConfig dataSourceConfig;

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public AddressDAO addressDAO() {
        return new AddressDAOImpl(dataSourceConfig.dataSource());
    }
}
