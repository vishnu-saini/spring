package com.bankapp.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.BankFacade;

public class Tester {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		/*
		AccountService as=ctx.getBean("accountServiceImp", AccountService.class);
		as.transfer(1, 2, 10);*/
	
		BankFacade bankFacade=ctx.getBean("bankFacadeImp" ,BankFacade.class);
		bankFacade.transfer(1, 2, 10);
		System.out.println("done");
		
	}

}
