package test.Reservation.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Reservation.model_aas_80.Customer_aas_80;


/**
 * 
 * @author ashwi
 *  Testing the Customer model
 */
public class CustomerTest {
	

		Customer_aas_80 currCustomer =new Customer_aas_80();
			
		@BeforeEach
		public void setUp() throws Exception {
			currCustomer.setName("JAMES");
			currCustomer.setEmail("james@gmail.com");
			currCustomer.setGender("male");
			currCustomer.setPhone_number("6067894321");
			currCustomer.setAddress("Richmond");
			currCustomer.setPassword("james");
		}
		//	
			@Test    // check the GetName function
			public void testGetName()
			{
				assertEquals("JAMES", currCustomer.getName());
			}
			
			@Test   // check the Getemail function
		    public void testGetEmail() {
		    	assertEquals("james@gmail.com", currCustomer.getEmail());
				
			}
			@Test   // check the GetGender function
		    public void testGetGender() {
		    	assertEquals("male", currCustomer.getGender());
		    }
			@Test   // check the GetPhonenumber function
		    public void testGetPhone_number() {
				assertEquals("6067894321", currCustomer.getPhone_number());
			}
		    	
			@Test   // check the get address function
		    public void testGetAddress() {
				assertEquals("Richmond", currCustomer.getAddress());
			}
			@Test   // check the GetPassword function
		    public void testGetPassword() {
				assertEquals("james", currCustomer.getPassword());
			}
		    
		    
//			@Test
//			public void test() {
//				fail("Not yet implemented");
//			}
			@Test  //check the SetName function
		    public void testSetName() {
		    	currCustomer.setName("JAMES");
		    	assertEquals("JAMES",currCustomer.getName());
				
			}
			@Test  //check the SetEmail function
		    public void testSetEmail() {
		    	currCustomer.setEmail("james@gmail.com");
		    	assertEquals("james@gmail.com",currCustomer.getEmail());
			}
			@Test   //check the setgender function
		    public void testSetGender() {
		    	currCustomer.setGender("male");
		    	assertEquals("male",currCustomer.getGender());
			}
			@Test  //check the setPhonenumber function
		    public void testSetPhone_number() {
		    	currCustomer.setPhone_number("6067894321");
		    	assertEquals("6067894321",currCustomer.getPhone_number());
			}
		    
		  
			@Test   //check the setaddress function
		    public void testSetAddress() {
		    	currCustomer.setAddress("Richmond");
		    	assertEquals("Richmond",currCustomer.getAddress());
			}
			@Test   //check the setpassword function
		    public void testSetPassword() {
		    	currCustomer.setPassword("james");
		    	assertEquals("james",currCustomer.getPassword());
			}
		}
