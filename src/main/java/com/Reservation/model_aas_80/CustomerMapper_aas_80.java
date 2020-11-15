package com.Reservation.model_aas_80;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper_aas_80 implements RowMapper<Customer_aas_80> {
	
	public Customer_aas_80 mapRow(ResultSet resultSet, int i) throws SQLException	{
	
		Customer_aas_80 customer = new Customer_aas_80();
		customer.setId(resultSet.getInt("id"));
		customer.setName(resultSet.getString("name"));
		customer.setEmail(resultSet.getString("email"));
		customer.setGender(resultSet.getString("gender"));
		customer.setPhone_number(resultSet.getString("phone_number"));
		customer.setAddress(resultSet.getString("address"));
		customer.setPassword(resultSet.getString("password"));
		
		return customer;
		
	}

}
