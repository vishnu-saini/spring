package com.vishnu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import com.vishnu.springboot.service.MyService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // singleton is default
@ComponentScan("com.vishnu.springboot") // it is not mandatory to apply for sub packages of current package
@Slf4j
public class SpringBootConsoleApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("service1")
	MyService serviceQ1;

	@Autowired
	@Qualifier("service2")
	MyService serviceQ2;

	@Autowired
	MyService service2;

	// @Autowired
	// MyService primaryService;

	public static void main(String[] args) {
		log.info("STARTING THE APPLICATION");
		SpringApplication.run(SpringBootConsoleApplication.class, args);
		log.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {
		serviceQ1.doWork();
		serviceQ2.doWork();
		service2.doWork();
		log.info(serviceQ1.toString());
		log.info(serviceQ2.toString());
		log.info(service2.toString());
		// primaryService.doWork();
	}

}
