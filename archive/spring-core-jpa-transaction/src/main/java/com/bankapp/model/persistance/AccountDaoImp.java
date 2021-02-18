package com.bankapp.model.persistance;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AccountDaoImp implements AccountDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public void update(Account account) {
		factory.getCurrentSession().save(account);
	}

	@Override
	public Account find(int id) {
		return (Account) factory.getCurrentSession().get(Account.class, id);
	}

}
