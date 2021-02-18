package com.vishnu.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vishnu.database.databasedemo.entity.Person;
import com.vishnu.database.databasedemo.jdbc.PersonJbdcDao;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJbdcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("All users -> {}", dao.findAll());

		logger.info("User id 10001 -> {}", dao.findById(10001));

		try {
			logger.info("Deleting 10002 ");
			dao.deleteById(10002);
		} catch (RuntimeException e) {
			logger.info("Delate rollback due to exception");
		}

		logger.info("Inserting 10004 -> {}", dao.insert(new Person(10004, "Tara", "Berlin", new Date())));

		logger.info("Update 10003 -> {}", dao.update(new Person(10003, "Pieter", "Utrecht", new Date())));

	}
}
