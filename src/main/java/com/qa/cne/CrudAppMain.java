package com.qa.cne; 	

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CrudAppMain {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CrudAppMain.class, args);

	}
}
