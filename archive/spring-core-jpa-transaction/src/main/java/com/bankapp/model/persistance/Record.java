package com.bankapp.model.persistance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Record {

	@Id @GeneratedValue
	private int id;
	private String bankEmployee;
	private String ipAddress;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	
	public Record(String bankEmployee, String ipAddress, Date date) {
		super();
		this.bankEmployee = bankEmployee;
		this.ipAddress = ipAddress;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankEmployee() {
		return bankEmployee;
	}
	public void setBankEmployee(String bankEmployee) {
		this.bankEmployee = bankEmployee;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
