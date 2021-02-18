package com.vishnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({ @ComponentScan("com.vishnu.controller"), @ComponentScan("com.vishnu.config") })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
