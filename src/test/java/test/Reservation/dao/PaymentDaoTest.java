package test.Reservation.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.Reservation.Dao_aas_80.paymentDao_aas_80;
import com.Reservation.model_aas_80.Payment_aas_80;


class PaymentDaoTest {
	DriverManagerDataSource dataSource;
	Connection conn = null;
	String url = "jdbc:h2:tcp://localhost/~/test";
	List<Payment_aas_80> listToTest = new ArrayList<Payment_aas_80>();
	paymentDao_aas_80 daoToTest;
	int preSize;
	Payment_aas_80 PaymentToTest;

	@BeforeEach
	void setUp() throws Exception {

		dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		daoToTest = new paymentDao_aas_80(dataSource);
		listToTest = daoToTest.getAllPayment();

		preSize = listToTest.size();

		PaymentToTest = new Payment_aas_80();
		
		PaymentToTest.setCustEmail("TestName@gamil.com");
		PaymentToTest.setDate(Date.valueOf("2020-09-10"));

		PaymentToTest.setAmount(100.00);
		PaymentToTest.setTaxrate(12.00);
		PaymentToTest.setTotal(112.00);
		PaymentToTest.setType("paid");

		daoToTest.createPayment(PaymentToTest);
	}

	@Test
	void testGetAll() {
		List<Payment_aas_80> currList = daoToTest.getAllPayment();
		assertEquals(preSize + 1, currList.size());
		//delete last record because we do not want to change the database
	   daoToTest.deletePayment(currList.get(currList.size()-1).getId());
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void testPaymentByID() {
		List<Payment_aas_80> currList = daoToTest.getAllPayment();
		
		Payment_aas_80 curr = new Payment_aas_80();
		curr = listToTest.get(0);

		int currId = (int) curr.getId();
		Double Total = curr.getTotal();

		assertEquals(Total, daoToTest.getOnePayment(currId).getTotal());
		//delete last customer because we do not want to change the database anymore
		assertTrue(daoToTest.deletePayment(currList.get(currList.size()-1).getId()));

	};

	@Test
	void testUpdatePayment() {
			
		List<Payment_aas_80> currList = new ArrayList<Payment_aas_80>();
		currList = daoToTest.getAllPayment();
		
		//set attribute for update test
		Payment_aas_80 testUpdateCusomter= daoToTest.getOnePayment(currList.get(currList.size()-1).getId());
				
		testUpdateCusomter.setCustEmail("Testingname@gmail.com");
		
		//test update function if it works
		assertTrue(daoToTest.updatePayment(testUpdateCusomter));
		
		//delete curr customer because we do not want to change the database anymore
		assertTrue(daoToTest.deletePayment(currList.get(currList.size()-1).getId()));

	};

	@Test
	void testDeletePayment() {
		
		//add one record to database to make the list one more longer
		Payment_aas_80 paymentToDelete = new Payment_aas_80();
		paymentToDelete.setType("Changed to paid");
		daoToTest.createPayment(paymentToDelete);
		
		List<Payment_aas_80> originalList = new ArrayList<Payment_aas_80>();
		originalList = daoToTest.getAllPayment();
		
		//get last element of list to delete
		int id= originalList.get(originalList.size()-1).getId();

		Payment_aas_80 curr = daoToTest.getOnePayment(id);
		curr.setType("Changed to paid");

		assertTrue(daoToTest.deletePayment(curr.getId()));

		List<Payment_aas_80> currList = new ArrayList<Payment_aas_80>();
		currList = daoToTest.getAllPayment();
		// After processing delete method so current list should be less 1 than before
		assertEquals(originalList.size() - 1, currList.size());
		//because of BeforeEach function executes before everyTest runs, we need to delete last one record to
		//keep database record originally
		assertTrue(daoToTest.deletePayment(currList.get(currList.size()-1).getId()));


	}
}
