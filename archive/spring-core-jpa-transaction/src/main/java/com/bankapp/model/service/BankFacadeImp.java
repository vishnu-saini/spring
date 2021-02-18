package com.bankapp.model.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.persistance.Record;

@Service
@Transactional
public class BankFacadeImp implements BankFacade {

	@Autowired
	private AccountService accountService;

	@Autowired
	private RecordService recordService;

	@Autowired
	private EmailService emailService;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	@Override
	public void transfer(int from, int to, int amount) {

		accountService.transfer(from, to, amount);

		recordService.addRecord(new Record("amit", "127.0.0.1", new Date()));
		// emailService.sendEmail("a", "b");

		if (1 == 1)
			throw new NullPointerException();

	}
}
