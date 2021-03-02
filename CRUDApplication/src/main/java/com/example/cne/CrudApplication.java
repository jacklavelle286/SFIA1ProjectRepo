package com.example.cne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication	
//@ComponentScan(basePackages = {"com.example.cne"})
//@ComponentScan(basePackages = {"com.example.cne.r//est.controller"})
//@ComponentScan(basePackages = {"com.example.cne.rest.repository"})
//@ComponentScan(basePackages = {"com.example.cne.rest.service"})
//@ComponentScan(basePackages = {"com.example.cne.rest.domain"})
//@ComponentScan(basePackages = {"com.example.cne.rest.persistence"})

public class CrudApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(CrudApplication.class, args);
			
	}
}