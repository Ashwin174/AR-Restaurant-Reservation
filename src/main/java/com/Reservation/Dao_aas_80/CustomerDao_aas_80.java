package com.Reservation.Dao_aas_80;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.Reservation.model_aas_80.CustomerMapper_aas_80;
import com.Reservation.model_aas_80.Customer_aas_80;
import com.Reservation.model_aas_80.EmployeeMapper_aas_80;
import com.Reservation.model_aas_80.Employee_aas_80;



@Component
public class CustomerDao_aas_80 {

	JdbcTemplate jdbcTemplete;

	private final String SQL_GET_ALL = "SELECT * FROM customer";
	private final String SQL_CREATE_CUSTOMER = "INSERT INTO customer(name,email,gender,phone_number,address,password) VALUES(?,?,?,?,?,?)";
	private final String SQL_DELETE_CUSTOMER = "DELETE FROM customer WHERE id = ?";
	// private final String SQL_VERIFY_EMPLOYEE ="SELECT * FROM employee WHERE email=?";
    private final String SQL_GETONE_CUSTOMER ="Select * from customer where id =?";
    private final String SQL_UPDATE_CUSTOMER ="UPDATE customer SET name = ?, email = ?, gender= ?, phone_number= ?,  address = ?, Password = ? WHERE id=?";
    private final String SQL_VERIFICATION_CUSTOMER ="SELECT * FROM customer WHERE email=?";
	
	@Autowired
	public CustomerDao_aas_80(DataSource dataSource) {
		jdbcTemplete = new JdbcTemplate(dataSource);
	}

	public List<Customer_aas_80> getAllCustomer() {
		return jdbcTemplete.query(SQL_GET_ALL, new CustomerMapper_aas_80());
	}

	public boolean createCustomer(Customer_aas_80 newCustomer) {
				return jdbcTemplete.update(SQL_CREATE_CUSTOMER, newCustomer.getName(), newCustomer.getEmail(),newCustomer.getGender(),newCustomer.getPhone_number(),newCustomer.getAddress(),newCustomer.getPassword()) > 0;
			}
	
	public boolean deleteCustomer(int idToDelete) {
		return jdbcTemplete.update(SQL_DELETE_CUSTOMER, idToDelete) > 0;
	}
	
	public Customer_aas_80 getOneCustomer(int id)	{
		return jdbcTemplete.queryForObject(SQL_GETONE_CUSTOMER,new Object[] {id}, new CustomerMapper_aas_80());
	}
	
    public boolean updateCustomer(Customer_aas_80 Updatedetail) {		
		return jdbcTemplete.update(SQL_UPDATE_CUSTOMER,Updatedetail.getName(),Updatedetail.getEmail(),Updatedetail.getGender(),Updatedetail.getPhone_number(),Updatedetail.getAddress(),Updatedetail.getPassword(),Updatedetail.getId()) > 0;
	}
    
    
    public Customer_aas_80 CustVerification(Customer_aas_80 compare) {
    	
    	
    	Customer_aas_80 customer;
		try {
		
			customer= jdbcTemplete.queryForObject(SQL_VERIFICATION_CUSTOMER, new CustomerMapper_aas_80(),compare.getEmail());
			
		
			if(compare.getPassword().equals(customer.getPassword())) {
				
				return customer;
			}else {
				return null;
			}
			
		}catch(Exception e) {
			return null;
		}
	}
    
	
}