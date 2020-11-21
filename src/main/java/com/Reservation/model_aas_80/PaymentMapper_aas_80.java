package com.Reservation.model_aas_80;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PaymentMapper_aas_80 implements RowMapper<Payment_aas_80>{

	
	
	public Payment_aas_80 mapRow(ResultSet resultSet, int i) throws SQLException	{
		
		Payment_aas_80 payment = new Payment_aas_80();
		payment.setId(resultSet.getInt("id"));
		payment.setCustEmail(resultSet.getString("email"));
		payment.setDate(resultSet.getDate("date"));
		payment.setAmount(resultSet.getDouble("amount"));
		payment.setTaxrate(resultSet.getDouble("taxrate"));
		payment.setTotal(resultSet.getDouble("total"));;
		payment.setType(resultSet.getString("type"));
		
		return payment;
		
	}
		
		
		
		
	
	
	
	
}
