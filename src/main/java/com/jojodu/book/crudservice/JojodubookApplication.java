package com.jojodu.book.crudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityListeners;

@EnableJpaAuditing
@SpringBootApplication
public class JojodubookApplication {

    public static void main(String[] args) {
        SpringApplication.run(JojodubookApplication.class, args);
    }

}
