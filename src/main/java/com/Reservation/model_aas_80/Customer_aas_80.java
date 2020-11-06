package com.Reservation.model_aas_80;


public class Customer_aas_80 {
  private int id;
	public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
	private String name;
	private String email; 
	private String gender;
	private String phone_number;
	private String address;;
	private String Password;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public String Displ()
	{
		StringBuffer sb= new StringBuffer();
		sb.append("Name:" +getName()+"<br>");
		sb.append("Email:" +getEmail()+"<br>");
		sb.append("Gender:" +getGender()+"<br>");
		sb.append("PhoneNumber:" +getPhone_number()+"<br>");
		sb.append("Address:" +getAddress()+"<br>");
	    return sb.toString();
}
}

