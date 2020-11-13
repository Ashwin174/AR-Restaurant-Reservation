package test.Reservation.model_aas_80;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Reservation.model_aas_80.Customer_aas_80;

class TestCustomer_aas_80 {

Customer_aas_80 currCustomer =new Customer_aas_80();
	
	@BeforeEach
	public void setUP() throws Exception
	{
		 currCustomer = new Customer_aas_80(1,"JAMES","james@gmail.com","male","6067894321","Richmond","james");
	}
//	
	@Test
	public void testGetName()
	{
		assertEquals("JAMES", currCustomer.getName());
	}
	
	@Test
    public void testGetEmail() {
    	assertEquals("james@gmail.com", currCustomer.getEmail());
		
	}
	@Test
    public void testGetGender() {
    	assertEquals("male", currCustomer.getGender());
    }
	@Test
    public void testGetPhone_number() {
		assertEquals("6067894321", currCustomer.getPhone_number());
	}
    	
	@Test
    public void testGetAddress() {
		assertEquals("Richmond", currCustomer.getAddress());
	}
	@Test
    public void testGetPassword() {
		assertEquals("james", currCustomer.getPassword());
	}
    
    
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	@Test
    public void testSetName() {
    	currCustomer.setName("JAMES");
    	assertEquals("JAMES",currCustomer.getName());
		
	}
	@Test
    public void testSetEmail() {
    	currCustomer.setEmail("james@gmail.com");
    	assertEquals("james@gmail.com",currCustomer.getEmail());
	}
	@Test
    public void testSetGender() {
    	currCustomer.setGender("male");
    	assertEquals("male",currCustomer.getGender());
	}
	@Test
    public void testSetPhone_number() {
    	currCustomer.setPhone_number("6067894321");
    	assertEquals("6067894321",currCustomer.getPhone_number());
	}
    
  
	@Test
    public void testSetAddress() {
    	currCustomer.setAddress("Richmond");
    	assertEquals("Richmond",currCustomer.getAddress());
	}
	@Test
    public void testSetPassword() {
    	currCustomer.setPassword("james");
    	assertEquals("james",currCustomer.getPassword());
	}
}
