package com.vishnu.springboot.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("service1")
@Slf4j
//@Primary
public class MyServiceImpl1 implements MyService {

	@Override
	public void doWork() {
		log.info("Doing work using service 1");
	}

	@PostConstruct
	void inti() {
		log.info("Initialized service 1");
	}

	@PreDestroy
	void destroy() {
		log.info("Destroying service 1");
	}

}
