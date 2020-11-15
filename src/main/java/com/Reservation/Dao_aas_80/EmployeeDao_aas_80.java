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
public class EmployeeDao_aas_80 {

	JdbcTemplate jdbcTemplete;

	private final String SQL_GET_ALL = "SELECT * FROM employee";
	private final String SQL_CREATE_EMPLOYEE = "INSERT INTO employee(name,email,gender,phone_number,department,address,password) VALUES(?,?,?,?,?,?,?)";
	private final String SQL_DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
	// private final String SQL_VERIFY_EMPLOYEE ="SELECT * FROM employee WHERE email=?";
    private final String SQL_GETONE_EMPLOYEE ="Select * from employee where id =?";
    private final String SQL_UPDATE_EMPLOYEE ="UPDATE employee SET name = ?, email = ?, gender= ?, phone_number= ?, department = ?, address = ?, Password = ? WHERE id=?";
    private final String SQL_VERIFICATION_EMPLOYEE ="SELECT * FROM employee WHERE email=?";
    
    @Autowired
	public EmployeeDao_aas_80(DataSource dataSource) {
		jdbcTemplete = new JdbcTemplate(dataSource);
	}

	public List<Employee_aas_80> getAllEmployee() {
		return jdbcTemplete.query(SQL_GET_ALL, new EmployeeMapper_aas_80());
	}

	public boolean createEmployee(Employee_aas_80 newEmployee) {
				return jdbcTemplete.update(SQL_CREATE_EMPLOYEE, newEmployee.getName(), newEmployee.getEmail(),newEmployee.getGender(),newEmployee.getPhone_number(),newEmployee.getDepartment(),newEmployee.getAddress(),newEmployee.getPassword()) > 0;
			}
	
	public boolean deleteEmployee(int idToDelete) {
		return jdbcTemplete.update(SQL_DELETE_EMPLOYEE, idToDelete) > 0;
	}
	public Employee_aas_80 getOneEmployee(int id)	{
		return jdbcTemplete.queryForObject(SQL_GETONE_EMPLOYEE,new Object[] {id}, new EmployeeMapper_aas_80());
	}
	
	
	/**public Employee_aas_80 verifyEmployee(Employee_aas_80 employee)
	{
		String npassword = employee.getPassword();
		employee= jdbcTemplete.queryForObject(SQL_VERIFY_EMPLOYEE, new EmployeeMapper_aas_80(),employee.getEmail() );
		return  null;
	}**/
	
public boolean updateEmployee(Employee_aas_80 Updatedetail) {
		
		return jdbcTemplete.update(SQL_UPDATE_EMPLOYEE,Updatedetail.getName(),Updatedetail.getEmail(),Updatedetail.getGender(),Updatedetail.getPhone_number(),Updatedetail.getDepartment(),Updatedetail.getAddress(),Updatedetail.getPassword(),Updatedetail.getId()) > 0;
	}

public Employee_aas_80 EmpVerification(Employee_aas_80 compare) {
	
	
	Employee_aas_80 employee;
	try {
	
		employee= jdbcTemplete.queryForObject(SQL_VERIFICATION_EMPLOYEE, new EmployeeMapper_aas_80(),compare.getEmail());
		System.out.println(employee.getEmail());
		System.out.println(employee.getPassword());
		System.out.println(employee.getAddress());
	
		if(compare.getPassword().equals(employee.getPassword())) {
			System.out.println("true");
			return employee;
		}else {
			return null;
		}
		
	}catch(Exception e) {
		return null;
	}
}



}
