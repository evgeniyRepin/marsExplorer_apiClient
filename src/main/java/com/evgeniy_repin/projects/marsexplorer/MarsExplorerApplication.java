package com.evgeniy_repin.projects.marsexplorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Properties;

@SpringBootApplication
@EnableCaching
public class MarsExplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsExplorerApplication.class, args);
        Properties properties = new Properties();
        properties.setProperty("spring.cache.type", "none");
        application.setDefaultProperties(properties);
        application.run(args);
    }

}
