package com.Reservation.model_aas_80;

import java.sql.Date;

public class Payment_aas_80 {
    private int id;
	private String custEmail;
	private Date date;
	private double amount;
	private double taxrate;
	private double total;
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getTaxrate() {
		return taxrate;
	}
	public void setTaxrate(double taxrate) {
		this.taxrate = taxrate;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public double calculationTotalamount() {
		

		
		return this.amount+this.amount * this.taxrate;
		
	}
	public Payment_aas_80(int id, String custEmail, Date date, double amount, double taxrate, double total,
			String type) {
		
		this.id = id;
		this.custEmail = custEmail;
		this.date = date;
		this.amount = amount;
		this.taxrate = taxrate;
		this.total = total;
		this.type = type;
	}
	
	
	
	public Payment_aas_80() {
		
	}
	
	
	
	
}
