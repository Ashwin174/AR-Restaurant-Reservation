package test.Reservation.model;

import static org.junit.Assert.assertEquals;


import java.sql.Date;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Reservation.model_aas_80.Payment_aas_80;

class PaymentTest {

	
	Payment_aas_80 paymentTest ;
	
	
	Date dateOfTest;
	

	
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		  String str="2015-03-31";  
		  dateOfTest=Date.valueOf(str);
		
		paymentTest = new Payment_aas_80(5,"jamestest@gmail.com", dateOfTest, 15.07, 10.00, 16.07, "paid");
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testgetId() {
		assertEquals(5,paymentTest.getId() );
	}
	@Test
	public void testsetId() {
		paymentTest.setId(10);
		assertEquals(10,paymentTest.getId() );
	}
	@Test
	public void testgetCustEmail() {
		assertEquals("jamestest@gmail.com",paymentTest.getCustEmail());
	}
	@Test
	public void testsetCustEmail() {
		paymentTest.setCustEmail("john@gmail.com");
		assertEquals("john@gmail.com",paymentTest.getCustEmail());
	}
	
	@Test
	public void testgetDate() {
		assertEquals(dateOfTest,paymentTest.getDate() );
	}
	@Test
	public void testsetDate() {
		paymentTest.setDate(Date.valueOf("2020-05-11"));
		assertEquals(Date.valueOf("2020-05-11"),paymentTest.getDate() );
	}
	
	@Test
	public void testgetAmount() {
		assertEquals(15.07,paymentTest.getAmount(),0.01);
	}
	
	@Test
	public void testsetAmount() {
		paymentTest.setAmount(100);
		assertEquals(100.00,paymentTest.getAmount(),0.01);
	}
	
	@Test
	public void testgetTaxrate() {
		assertEquals(10,paymentTest.getTaxrate(),0.01 );
		
	}
	
	@Test
	public void testsetTaxrate() {
		paymentTest.setTaxrate(12);
		assertEquals(12.00,paymentTest.getTaxrate(),0.01);
	}

	@Test
	public void testgetTotal() {
		assertEquals(16.07,paymentTest.getTotal(),0.01);
	}
	
	@Test
	public void testsetTotal() {
		paymentTest.setTotal(150);
		assertEquals(150.00,paymentTest.getTotal(),.01);
	}
	@Test
	public void testgetType() {
		assertEquals("paid",paymentTest.getType());
	}
	@Test
	public void testsetType() {
		paymentTest.setType("waiting");
		assertEquals("waiting",paymentTest.getType());
	}
	

}
