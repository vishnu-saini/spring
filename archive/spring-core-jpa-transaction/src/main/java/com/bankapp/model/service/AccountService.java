package com.bankapp.model.service;

import com.bankapp.model.persistance.Account;

public interface AccountService {
	public void transfer(int from, int to, int amout);
	public void deposit(int id, double amount);
	public Account getAccount(int id);
}
