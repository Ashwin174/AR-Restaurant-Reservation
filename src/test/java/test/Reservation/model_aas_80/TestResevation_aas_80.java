package test.Reservation.model_aas_80;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Reservation.model_aas_80.Reservation_aas_80;

class TestResevation_aas_80 {
	
	Reservation_aas_80 currReservation = new Reservation_aas_80();
	java.util.Date d1 = new java.util.Date();
	java.sql.Date today= new java.sql.Date(d1.getDate());
	
	@BeforeEach
	 public void setUP() throws Exception 
	{
	
		
		currReservation = new Reservation_aas_80(1,"JAMES","james@gmail.com","6067894321","9pm",today,"4","waiting");
	//currReservation = new Reservation_aas_80(1,"JAMES","james@gmail.com","6067894321","9:00 pm",2020-09-10,"4","waiting");
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetName()
	{
		assertEquals("JAMES", currReservation.getName());
	}
	@Test
   public void testGetEmail() {
   	assertEquals("james@gmail.com", currReservation.getEmail());
		
	}
       
	@Test
   public void testGetPhone_number() {
		assertEquals("6067894321", currReservation.getPhone_number());
	}
   	
	@Test
   public void testGetTime() {
		assertEquals("9pm", currReservation.getTime());
	}
	@Test
   public void testGetDate() {
		assertEquals(today, currReservation.getResDate());
	}
	@Test
   public void testGetPeopleNumber() {
 		assertEquals("4", currReservation.getPeopleNumber());
 	}
	@Test
   public void testGetStatus() {
 		assertEquals("waiting", currReservation.getStatus());
 	}
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
   
	@Test
   public void testSetName() {
   	currReservation.setName("JAMES");
   	assertEquals("JAMES",currReservation.getName());
		
	}
	@Test
   public void testSetEmail() {
   	currReservation.setEmail("james@gmail.com");
   	assertEquals("james@gmail.com",currReservation.getEmail());
	}
   

	@Test
   public void testSetPhone_number() {
   	currReservation.setPhone_number("6067894321");
   	assertEquals("6067894321",currReservation.getPhone_number());
	}
   
 
	@Test
   public void testSetAddress() {
   	currReservation.setTime("Richmond");
   	assertEquals("Richmond",currReservation.getTime());
	}
	@Test
   public void testSetDate() {
   	Date testDay = new Date(1584377718);
   	currReservation.setResDate(testDay);
   	assertEquals(testDay,currReservation.getResDate());
	}

	@Test
public void testSetPeopleNumber() {
	currReservation.setPeopleNumber("4");
	assertEquals("4",currReservation.getPeopleNumber());
}
	@Test
public void testSetStatus() {
	currReservation.setStatus("waiting");
	assertEquals("waiting",currReservation.getStatus());
}
	
}

