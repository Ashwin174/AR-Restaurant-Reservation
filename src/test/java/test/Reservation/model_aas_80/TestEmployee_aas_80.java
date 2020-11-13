package test.Reservation.model_aas_80;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Reservation.model_aas_80.Employee_aas_80;

class TestEmployee_aas_80 {

	Employee_aas_80 currEmployee =new Employee_aas_80();
	@BeforeEach
	public void setUp() throws Exception {
		currEmployee = new Employee_aas_80(1,"vishnu","vishnu@gmail.com","male","9085674321","manager","Richmond","vishnu");
	}

	
	@Test
	public void testGetId()
	{
		System.out.println(currEmployee.getId());
		assertEquals(1, currEmployee.getId());
	}
	
	
	@Test
	public void testGetName()
	{
		System.out.println(currEmployee.getName());
		assertEquals("vishnu", currEmployee.getName());
	}
	
	
//	public void testGetName()
//	{
//		assertEquals("vishnu", currEmployee.getName());
//	}
	
	
	@Test
    public void testGetEmail() {
		System.out.println(currEmployee.getEmail());
    	assertEquals("vishnu@gmail.com", currEmployee.getEmail());
		
	}
      
    @Test
    public void testGetGender() {
    	assertEquals("male", currEmployee.getGender());
    }
    
    public void testGetPhone_number() {
		assertEquals("9085674321", currEmployee.getPhone_number());
	}
    	
    @Test
    public void testGetDepartment() {
    	currEmployee.setDepartment("doorMan");
		assertEquals("doorMan", currEmployee.getDepartment());
	}	 
    
    public void testGetAddress() {
		assertEquals("Richmond", currEmployee.getAddress());
	}
    
    public void testGetPassword() {
		assertEquals("vishnu", currEmployee.getPassword());
	}
    
    
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
    
    @Test
    public void testSetName() {
    	currEmployee.setName("vishnu");
    	assertEquals("vishnu",currEmployee.getName());
		
	}
    
    @Test
    public void testSetEmail() {
    	currEmployee.setEmail("vishnu@gmail.com");
    	assertEquals("vishnu@gmail.com",currEmployee.getEmail());
	}
    
    @Test
    public void testSetGender() {
    	currEmployee.setGender("male");
    	assertEquals("male",currEmployee.getGender());
	}
    
    @Test
    public void testSetPhone_number() {
    	currEmployee.setPhone_number("9085674321");
    	assertEquals("9085674321",currEmployee.getPhone_number());
	}
    
    @Test
    public void testSetDepartment() {
    	currEmployee.setDepartment("manager");
    	assertEquals("manager",currEmployee.getDepartment());
	}
    
    @Test
    public void testSetAddress() {
    	currEmployee.setAddress("Richmond");
    	assertEquals("Richmond",currEmployee.getAddress());
	}
    
    @Test
    public void testSetPassword() {
    	currEmployee.setPassword("vishnu");
    	assertEquals("vishnu",currEmployee.getPassword());
	}
}

