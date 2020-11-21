package com.Reservation.Dao_aas_80;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.Reservation.model_aas_80.EmployeeMapper_aas_80;
import com.Reservation.model_aas_80.Employee_aas_80;
import com.Reservation.model_aas_80.PaymentMapper_aas_80;
import com.Reservation.model_aas_80.Payment_aas_80;


@Component
public class paymentDao_aas_80 {

	JdbcTemplate jdbcTemplete;
	
	private final String SQL_GET_ALL = "SELECT * FROM payment";
	private final String SQL_CREATE_PAYMENT = "INSERT INTO payment(email,date,amount,taxrate,total,type) VALUES(?,?,?,?,?,?)";
	private final String SQL_DELETE_PAYMENT = "DELETE FROM payment WHERE id = ?";
	// private final String SQL_VERIFY_EMPLOYEE ="SELECT * FROM employee WHERE email=?";
    private final String SQL_GETONE_PAYMENT ="Select * from payment where id =?";
    private final String SQL_UPDATE_PAYMENT ="UPDATE payment SET email = ?, date = ?, amount= ?, taxrate= ?, total = ?, type = ? WHERE id=?";
	
    
    
    @Autowired
	public paymentDao_aas_80 (DataSource dataSource) {
		jdbcTemplete = new JdbcTemplate(dataSource);
	}

	public List<Payment_aas_80> getAllPayment() {
		return jdbcTemplete.query(SQL_GET_ALL, new PaymentMapper_aas_80());
	}

	public boolean createPayment(Payment_aas_80 newPayment) {
				return jdbcTemplete.update(SQL_CREATE_PAYMENT, newPayment.getCustEmail(), newPayment.getDate(),newPayment.getAmount(),newPayment.getTaxrate(),newPayment.getTotal(),newPayment.getType()) > 0;
			}
	
	public boolean deletePayment(int idToDelete) {
		return jdbcTemplete.update(SQL_DELETE_PAYMENT, idToDelete) > 0;
	}
	public Payment_aas_80 getOnePayment(int id)	{
		return jdbcTemplete.queryForObject(SQL_GETONE_PAYMENT,new Object[] {id}, new PaymentMapper_aas_80());
	}
	
	
	/**public Employee_aas_80 verifyEmployee(Employee_aas_80 employee)
	{
		String npassword = employee.getPassword();
		employee= jdbcTemplete.queryForObject(SQL_VERIFY_EMPLOYEE, new EmployeeMapper_aas_80(),employee.getEmail() );
		return  null;
	}**/
	
public boolean updateEmployee(Payment_aas_80 Updatedetail) {
		
		return jdbcTemplete.update(SQL_UPDATE_PAYMENT,Updatedetail.getCustEmail(),Updatedetail.getDate(),Updatedetail.getAmount(),Updatedetail.getTaxrate(),Updatedetail.getTotal(),Updatedetail.getType(),Updatedetail.getId()) > 0;
	}
    
    
    
}
