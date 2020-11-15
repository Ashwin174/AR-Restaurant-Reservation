package com.Reservation.model_aas_80;

import java.sql.Date;

public class Reservation_aas_80 {
   private int id;
   private String name;
   private String email;
   private String phone_number;
   private String time;
   private Date resDate;
   private String peopleNumber;
   private String status;
   
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}

public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public Date getResDate() {
	return resDate;
}
public void setResDate(Date resDate) {
	this.resDate = resDate;
}
public String getPeopleNumber() {
	return peopleNumber;
}
public void setPeopleNumber(String peopleNumber) {
	this.peopleNumber = peopleNumber;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Reservation_aas_80(int id, String name, String email, String phone_number, String time, Date resDate,
		String peopleNumber, String status) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone_number = phone_number;
	this.time = time;
	this.resDate = resDate;
	this.peopleNumber = peopleNumber;
	this.status = status;
}
public Reservation_aas_80() {
	super();
}




}
