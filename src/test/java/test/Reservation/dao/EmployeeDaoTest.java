package test.Reservation.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.Reservation.Dao_aas_80.EmployeeDao_aas_80;
import com.Reservation.model_aas_80.Employee_aas_80;

class EmployeeDaoTest {
	DriverManagerDataSource dataSource;
	Connection conn = null;
	String url = "jdbc:h2:tcp://localhost/~/test";
	List<Employee_aas_80> listToTest = new ArrayList<Employee_aas_80>();
	EmployeeDao_aas_80 daoToTest;
	int preSize;
	Employee_aas_80 EmployeeToTest;

	@BeforeEach
	void setUp() throws Exception {

		dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		daoToTest = new EmployeeDao_aas_80(dataSource);
		listToTest = daoToTest.getAllEmployee();

		preSize = listToTest.size();

		EmployeeToTest = new Employee_aas_80();
		EmployeeToTest.setName("TestName");
		EmployeeToTest.setEmail("TestName@gamil.com");
		EmployeeToTest.setGender("Male");

		EmployeeToTest.setPassword("testPassword");
		EmployeeToTest.setPhone_number("11110000");
		EmployeeToTest.setDepartment("Test Rd Manager");
		EmployeeToTest.setAddress("Test Rd New Westminster");

		daoToTest.createEmployee(EmployeeToTest);
	}

	@Test
	void testGetAll() {
		List<Employee_aas_80> currList = daoToTest.getAllEmployee();
		assertEquals(preSize + 1, currList.size());
		//delete last record because we do not want to change the database
	   daoToTest.deleteEmployee(currList.get(currList.size()-1).getId());
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetEmployeeByID() {
		List<Employee_aas_80> currList = daoToTest.getAllEmployee();
		
		Employee_aas_80 curr = new Employee_aas_80();
		curr = listToTest.get(0);

		int currId = (int) curr.getId();
		String username = curr.getName();

		assertEquals(username, daoToTest.getOneEmployee(currId).getName());
		//delete last customer because we do not want to change the database anymore
		assertTrue(daoToTest.deleteEmployee(currList.get(currList.size()-1).getId()));

	};

	@Test
	void testUpdateEmploye() {
			
		List<Employee_aas_80> currList = new ArrayList<Employee_aas_80>();
		currList = daoToTest.getAllEmployee();
		
		//set attribute for update test
		Employee_aas_80 testUpdateCusomter= daoToTest.getOneEmployee(currList.get(currList.size()-1).getId());
				
		testUpdateCusomter.setAddress("after updated address");
		
		//test update function if it works
		assertTrue(daoToTest.updateEmployee(testUpdateCusomter));
		
		//delete curr customer because we do not want to change the database anymore
		assertTrue(daoToTest.deleteEmployee(currList.get(currList.size()-1).getId()));

	};

	@Test
	void testDeleteEmployee() {
		
		//add one record to database to make the list one more longer
		Employee_aas_80 EmployeeToDelete = new Employee_aas_80();
		EmployeeToDelete.setAddress("Test record should be deleted");
		daoToTest.createEmployee(EmployeeToDelete);
		
		List<Employee_aas_80> originalList = new ArrayList<Employee_aas_80>();
		originalList = daoToTest.getAllEmployee();
		
		//get last element of list to delete
		int id= originalList.get(originalList.size()-1).getId();

		Employee_aas_80 curr = daoToTest.getOneEmployee(id);
		curr.setAddress("Test record should be deleted");

		assertTrue(daoToTest.deleteEmployee(curr.getId()));

		List<Employee_aas_80> currList = new ArrayList<Employee_aas_80>();
		currList = daoToTest.getAllEmployee();
		// After processing delete method so current list should be less 1 than before
		assertEquals(originalList.size() - 1, currList.size());
		//because of BeforeEach function executes before everyTest runs, we need to delete last one record to
		//keep database record originally
		assertTrue(daoToTest.deleteEmployee(currList.get(currList.size()-1).getId()));

	}


}
