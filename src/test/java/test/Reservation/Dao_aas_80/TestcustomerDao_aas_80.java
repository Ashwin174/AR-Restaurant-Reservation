package test.Reservation.Dao_aas_80;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.Reservation.Dao_aas_80.CustomerDao_aas_80;
import com.Reservation.model_aas_80.Customer_aas_80;

class TestcustomerDao_aas_80 {

	DriverManagerDataSource dataSource;

	String url = "jdbc:h2:tcp://localhost/~/test";
	List<Customer_aas_80> listToTest = new ArrayList<Customer_aas_80>();
	CustomerDao_aas_80 daoToTest;
	int preSize;
	Customer_aas_80 customerToTest;

	@BeforeEach
	void setUp() throws Exception {

		dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		daoToTest = new CustomerDao_aas_80(dataSource);
		listToTest = daoToTest.getAllCustomer();

		preSize = listToTest.size();

		customerToTest = new Customer_aas_80();
		customerToTest.setName("TestName");
		customerToTest.setEmail("TestName@gamil.com");
		customerToTest.setGender("Male");

		customerToTest.setPassword("testPassword");
		customerToTest.setPhone_number("11110000");
		customerToTest.setAddress("Test Rd New Westminster");

		daoToTest.createCustomer(customerToTest);
	}

	@Test
	void testGetAll() {
		List<Customer_aas_80> currList = daoToTest.getAllCustomer();
		assertEquals(preSize + 1, currList.size());
		//delete last record because we do not want to change the database
	   daoToTest.deleteCustomer(currList.get(currList.size()-1).getId());
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetCustomerByID() {
		List<Customer_aas_80> currList = daoToTest.getAllCustomer();
		
		Customer_aas_80 curr = new Customer_aas_80();
		curr = listToTest.get(0);

		int currId = (int) curr.getId();
		String username = curr.getName();

		assertEquals(username, daoToTest.getOneCustomer(currId).getName());
		//delete last customer because we do not want to change the database anymore
		assertTrue(daoToTest.deleteCustomer(currList.get(currList.size()-1).getId()));

	};

	@Test
	void testUpdateCustomer() {
			
		List<Customer_aas_80> currList = new ArrayList<Customer_aas_80>();
		currList = daoToTest.getAllCustomer();
		
		//set attribute for update test
		Customer_aas_80 testUpdateCusomter= daoToTest.getOneCustomer(currList.get(currList.size()-1).getId());
				
		testUpdateCusomter.setAddress("after updated address");
		
		//test update function if it works
		assertTrue(daoToTest.updateCustomer(testUpdateCusomter));
		
		//delete curr customer because we do not want to change the database anymore
		assertTrue(daoToTest.deleteCustomer(currList.get(currList.size()-1).getId()));

	};

	@Test
	void testDeleteCustomer() {
		
		//add one record to database to make the list one more longer
		Customer_aas_80 customerToDelete = new Customer_aas_80();
		customerToDelete.setAddress("Test record should be deleted");
		daoToTest.createCustomer(customerToDelete);
		
		List<Customer_aas_80> originalList = new ArrayList<Customer_aas_80>();
		originalList = daoToTest.getAllCustomer();
		
		//get last element of list to delete
		int id= originalList.get(originalList.size()-1).getId();

		Customer_aas_80 curr = daoToTest.getOneCustomer(id);
		curr.setAddress("Test record should be deleted");

		assertTrue(daoToTest.deleteCustomer(curr.getId()));

		List<Customer_aas_80> currList = new ArrayList<Customer_aas_80>();
		currList = daoToTest.getAllCustomer();
		// After processing delete method so current list should be less 1 than before
		assertEquals(originalList.size() - 1, currList.size());
		//because of BeforeEach function executes before everyTest runs, we need to delete last one record to
		//keep database record originally
		assertTrue(daoToTest.deleteCustomer(currList.get(currList.size()-1).getId()));

	}

}
