package com.bankapp.model.persistance;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecordDaoImp implements RecordDao {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addRecord(Record record) {
		factory.getCurrentSession().save(record);
	}

}
