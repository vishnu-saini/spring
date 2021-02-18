package com.bankapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.persistance.Record;
import com.bankapp.model.persistance.RecordDao;

@Service
@Transactional
public class RecordServiceImp implements RecordService {

	@Autowired
	private RecordDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void addRecord(Record record) {
		 dao.addRecord(record);
	}

}
