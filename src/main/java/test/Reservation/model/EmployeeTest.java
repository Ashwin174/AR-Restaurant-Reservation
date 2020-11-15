package test.Reservation.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Reservation.model_aas_80.Customer_aas_80;
import com.Reservation.model_aas_80.Employee_aas_80;
/**
 * 
 * @author ashwi
 *  testing Employee model
 */
class EmployeeTest {
 Employee_aas_80 currEmployee = new Employee_aas_80();

		
	
	
	
	@BeforeEach
	public void setUp() throws Exception {
		currEmployee.setId(1);
		currEmployee.setName("vishnu");
		currEmployee.setEmail("vishnu@gmail.com");
		currEmployee.setGender("male");
		currEmployee.setPhone_number("9085674321");
		currEmployee.setDepartment("manager");
		currEmployee.setAddress("Richmond");
		currEmployee.setPassword("vishnu");
	}

	
	@Test
	public void testGetId()
	{
		System.out.println(currEmployee.getId());
		assertEquals(1, currEmployee.getId());
	}
	
	
	@Test   // test the getName function
	public void testGetName()
	{
		System.out.println(currEmployee.getName());
		assertEquals("vishnu", currEmployee.getName());
	}
	
	
//	public void testGetName()
//	{
//		assertEquals("vishnu", currEmployee.getName());
//	}
	
	
	@Test  // test the getEmail function
    public void testGetEmail() {
		System.out.println(currEmployee.getEmail());
    	assertEquals("vishnu@gmail.com", currEmployee.getEmail());
		
	}
      
    @Test  // test the getGender function
    public void testGetGender() {
    	assertEquals("male", currEmployee.getGender());
    }
    @Test
    public void testGetPhone_number() {
		assertEquals("9085674321", currEmployee.getPhone_number());
	}
    	
    @Test  // test the getDepartment function
    public void testGetDepartment() {
    	currEmployee.setDepartment("doorMan");
		assertEquals("doorMan", currEmployee.getDepartment());
	}	 
    @Test  // test the getAddress function
    public void testGetAddress() {
		assertEquals("Richmond", currEmployee.getAddress());
	}
    @Test  // test the password function
    public void testGetPassword() {
		assertEquals("vishnu", currEmployee.getPassword());
	}
    
    
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
    
    @Test  // test the setName function
    public void testSetName() {
    	currEmployee.setName("vishnu");
    	assertEquals("vishnu",currEmployee.getName());
		
	}
    
    @Test  // test the setEmail function
    public void testSetEmail() {
    	currEmployee.setEmail("vishnu@gmail.com");
    	assertEquals("vishnu@gmail.com",currEmployee.getEmail());
	}
    
    @Test  // test the setgender function
    public void testSetGender() {
    	currEmployee.setGender("male");
    	assertEquals("male",currEmployee.getGender());
	}
    
    @Test  // test the setphonenumber function
    public void testSetPhone_number() {
    	currEmployee.setPhone_number("9085674321");
    	assertEquals("9085674321",currEmployee.getPhone_number());
	}
     
    @Test  // test the setdepartmnet function
    public void testSetDepartment() {
    	currEmployee.setDepartment("manager");
    	assertEquals("manager",currEmployee.getDepartment());
	}
    
    @Test  // test the setadrress function
    public void testSetAddress() {
    	currEmployee.setAddress("Richmond");
    	assertEquals("Richmond",currEmployee.getAddress());
	}
    
    @Test // test the setPassword function
    public void testSetPassword() {
    	currEmployee.setPassword("vishnu");
    	assertEquals("vishnu",currEmployee.getPassword());
	}
}