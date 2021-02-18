package com.bankapp.model.service;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImp implements EmailService {

	@Override
	public void sendEmail(String fromAccontMail, String toAccountMail) {
		System.out.println("emil is send...");
	}

}
