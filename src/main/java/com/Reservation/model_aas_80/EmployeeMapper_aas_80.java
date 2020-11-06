package com.Reservation.model_aas_80;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper_aas_80 implements RowMapper<Employee_aas_80> {
	
	public Employee_aas_80 mapRow(ResultSet resultSet, int i) throws SQLException	{
	
		Employee_aas_80 employee = new Employee_aas_80();
		employee.setId(resultSet.getInt("id"));
		employee.setName(resultSet.getString("name"));
		employee.setEmail(resultSet.getString("email"));
		employee.setGender(resultSet.getString("gender"));
		employee.setPhone_number(resultSet.getString("phone_number"));
		employee.setDepartment(resultSet.getString("department"));
		employee.setAddress(resultSet.getString("address"));
		employee.setPassword(resultSet.getString("password"));
		
		return employee;
		
	}

}
