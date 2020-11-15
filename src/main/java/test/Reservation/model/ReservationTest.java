package test.Reservation.model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Reservation.model_aas_80.Reservation_aas_80;
/**
 * 
 * @author ashwi
 *test the reservationclass
 */
class ReservationTest {

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

	@Test  // test the getName function
	public void testGetName()
	{
		assertEquals("JAMES", currReservation.getName());
	}
	@Test // test the getEmail function
   public void testGetEmail() {
   	assertEquals("james@gmail.com", currReservation.getEmail());
		
	}
       
	@Test // test the getphonenumber function
   public void testGetPhone_number() {
		assertEquals("6067894321", currReservation.getPhone_number());
	}
   	
	@Test  // test the gettime function
   public void testGetTime() {
		assertEquals("9pm", currReservation.getTime());
	}
	@Test  // test the getdate function
   public void testGetDate() {
		assertEquals(today, currReservation.getResDate());
	}
	@Test  // test the getnumber of people function
   public void testGetPeopleNumber() {
 		assertEquals("4", currReservation.getPeopleNumber());
 	}
	@Test  // test the getstatus function
   public void testGetStatus() {
 		assertEquals("waiting", currReservation.getStatus());
 	}
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
   
	@Test  // test the setname function
   public void testSetName() {
   	currReservation.setName("JAMES");
   	assertEquals("JAMES",currReservation.getName());
		
	}
	@Test  // test the setemail function
   public void testSetEmail() {
   	currReservation.setEmail("james@gmail.com");
   	assertEquals("james@gmail.com",currReservation.getEmail());
	}
   

	@Test  // test the setphonnumber function
   public void testSetPhone_number() {
   	currReservation.setPhone_number("6067894321");
   	assertEquals("6067894321",currReservation.getPhone_number());
	}
   
 
	@Test  // test the setaddress function
   public void testSetAddress() {
   	currReservation.setTime("Richmond");
   	assertEquals("Richmond",currReservation.getTime());
	}
	@Test  // test the setdate function
   public void testSetDate() {
   	Date testDay = new Date(1584377718);
   	currReservation.setResDate(testDay);
   	assertEquals(testDay,currReservation.getResDate());
	}

	@Test  // test the setnumber of people function
public void testSetPeopleNumber() {
	currReservation.setPeopleNumber("4");
	assertEquals("4",currReservation.getPeopleNumber());
}
	@Test  // test the setstatus function
public void testSetStatus() {
	currReservation.setStatus("waiting");
	assertEquals("waiting",currReservation.getStatus());
}
	
}
