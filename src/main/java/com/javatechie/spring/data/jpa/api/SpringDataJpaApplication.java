package com.javatechie.spring.data.jpa.api;

import com.javatechie.spring.data.jpa.api.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.javatechie.spring.data.jpa.api.controller", "com.javatechie.spring.data.jpa.api.dao", "com.javatechie.spring.data.jpa.api.service", "com.javatechie.spring.data.jpa.api.model"})
@EnableJpaRepositories("com.javatechie.spring.data.jpa.api.dao")
@EntityScan(basePackages = {"com.javatechie.spring.data.jpa.api.model"})
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

}

/*

@SpringBootApplication
@ComponentScan({"com.javatechie.spring.data.jpa.api.controller.*"})
@EntityScan("com.delivery.domain")
@EnableJpaRepositories("com.delivery.repository")*/
