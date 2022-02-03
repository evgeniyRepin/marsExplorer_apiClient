package com.evgeniy_repin.projects.marsexplorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.Properties;
import java.util.Random;

@SpringBootApplication
@EnableCaching
public class MarsExplorerApplication {

    @Bean
    public Random randomSol() {
        return new Random();
    }

    public static void main(String[] args) {
        SpringApplication.run(MarsExplorerApplication.class, args);
    }
}
