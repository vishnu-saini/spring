package com.vishnu.springboot.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("service2")
@Slf4j
public class MyServiceImpl2 implements MyService {

	@Override
	public void doWork() {
		log.info("Doing work using service 2");
	}

	@PostConstruct
	void inti() {
		log.info("Initialized service 2");
	}

	@PreDestroy
	void destroy() {
		log.info("Destroying service 2");
	}

}
