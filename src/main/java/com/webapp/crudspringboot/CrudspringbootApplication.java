package com.webapp.crudspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudspringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudspringbootApplication.class, args);
	}
            
    @Override
    public void run(String... args) throws Exception {
    
    }
}
