package com.bankapp.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.persistance.Account;
import com.bankapp.model.persistance.AccountDao;
import com.bankapp.model.service.aspects.Loggable;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

	private AccountDao accountDao;

	@Autowired
	public AccountServiceImp(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Loggable
	@Override
	public void transfer(int from, int to, int amount) {
			Account fromAccount=accountDao.find(from);
			Account toAccount=accountDao.find(to);
			fromAccount.setBalance(fromAccount.getBalance()-amount);
			toAccount.setBalance(toAccount.getBalance()+amount);
			accountDao.update(fromAccount);
			accountDao.update(toAccount);
			
	}

	@Override
	public void deposit(int id, double amount) {

	}

	@Override
	public Account getAccount(int id) {
		return null;
	}

}
