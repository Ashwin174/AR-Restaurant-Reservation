package com.Reservation.controller_aas_80;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Reservation.Dao_aas_80.CustomerDao_aas_80;
import com.Reservation.Dao_aas_80.EmployeeDao_aas_80;
import com.Reservation.model_aas_80.Customer_aas_80;
import com.Reservation.model_aas_80.Employee_aas_80;


/**
 * 
 * @author ashwi
 *
 */



@Controller
@Scope("session")
public class CustomerController {


	@Autowired
	CustomerDao_aas_80 customerDao;

	@ModelAttribute("customer")
	public Customer_aas_80 setupAddForm() {
		return new Customer_aas_80();

	}
   @GetMapping("/")
	public String index(@ModelAttribute("login") Customer_aas_80 employee, Model model) {
	   
		return "Customerlogin";
	}
   
   @PostMapping("/login")
	public String loginVerification(HttpSession session, @ModelAttribute("login") Customer_aas_80 customer, Model model) {
	  
	  
	        
			Customer_aas_80 verifiedCustomer ;
		    verifiedCustomer= customerDao.CustVerification(customer);
			
			
			if (verifiedCustomer != null) {
				model.addAttribute("currCustomer",verifiedCustomer);
				session.setAttribute("sessionid", verifiedCustomer.getId());
				return "CustomerMain";
			} else {
				
				model.addAttribute("error", "Please Enter Your Correct Email and Password");
				return "Customerlogin";
			}
		

	}
   
   
   
   @GetMapping("/showcustomer")
  	public String showcustomer(HttpSession session, Model model)	{
  		//Get a list of students from the database
  	   
  	   int id = (int) session.getAttribute("id");
  	 Customer_aas_80 employee = customerDao.getOneCustomer(id);
  		List<Customer_aas_80> employees = customerDao.getAllCustomer();
  			
  		
  		//Add the list of students to the model to be returned to the view
  		String name = employee.getName();
  		model.addAttribute("employeeList", employees);
  		model.addAttribute("message", "Welcome,  " + name );
  		return "CustomerDetail";
  	}
     
  	
	@PostMapping("/createCustomer")
	public String createCustomer(@ModelAttribute("login") Customer_aas_80 createCustomer, Model model) {

		 //Create the student pass the object in.
		//employeeDao.createEmployee(createEmployee);

	//Get a list of students from the controller
//	List<Employee_aas_80> employees = employeeDao.getAllEmployee();
//	model.addAttribute("employeeList", employees);

	return "CustomerRegister";
	}
	
	
	
	
	@PostMapping("/RegisteredCustomer")
	public String RegisteredCustomer(@ModelAttribute("login") Customer_aas_80 createCustomer, Model model) {

		 //Create the student pass the object in.
		customerDao.createCustomer(createCustomer);

	//Get a list of students from the controller
//	List<Employee_aas_80> employees = employeeDao.getAllEmployee();
//	model.addAttribute("employeeList", employees);

	return "Customerlogin";
	}
	
	
  /**	@GetMapping("/deleteC")
  	public String deleteEmployee(@RequestParam(required = true) int id, Model model)	{
  				
  		//Get the student
  		customerDao.deleteEmployee(id);
  		
  		//Get a list of students from the controller
  		List<Employee_aas_80> employees = customerDao.getAllEmployee();
  		model.addAttribute("employeeList", employees);
  	
  		model.addAttribute("message", "Deleted employee: " + id);
  			
  		return "EmployeeDetail";
  	}**/
/**  	@GetMapping("/editCustomer")
  	public String editCustomer(@RequestParam(required = true)int id, Model model)	{
  		
  		Customer_aas_80 currEmployee = customerDao.getOneCustomer(id);
  		model.addAttribute("employeeList",currEmployee);
  		return ("editCustomer");
  		//Get the student
  		
  		//Get a list of students from the controller
  		
  	} **/
  	
	
	
	
	@PostMapping("/editCustomer")
  	public String directtoEdit(HttpSession session, Model model)	{
  		
  		//Get the customer
  		
     		int id = (int) session.getAttribute("sessionid");
     		System.out.println(id);
		Customer_aas_80 oneDetails =customerDao.getOneCustomer(id);
  		model.addAttribute("currCustomer",oneDetails );
  		//System.out.println(oneDetails.getAddre);
  		
  		
  		//Get a list of students from the controller
  		// List<Customer_aas_80> students = customerDao.getAllCustomer();
  		//model.addAttribute("employeeList", students);
  	
  		model.addAttribute("message", "Edited Customer: " + oneDetails.getEmail());
  			
  		return "editCustomer";
  	}
  		
	
  	@PostMapping("/confirmEdit")
  	public String editCustomer(HttpSession session,@ModelAttribute("currCustomer") Customer_aas_80 updatedcustomer, Model model)	{
  		
  		//Get the UpdatedCustomer
  		System.out.println(updatedcustomer.getPhone_number());
  		System.out.println(updatedcustomer.getId());
  		System.out.println(customerDao.updateCustomer(updatedcustomer));
  		int id = (int) session.getAttribute("sessionid");
 		
	    Customer_aas_80 editCustomer =customerDao.getOneCustomer(id);
  		System.out.println(editCustomer.getPhone_number());
  		
  		
  		model.addAttribute("currCustomer",editCustomer );
  		
  		//Get a list of students from the controller
  		// List<Customer_aas_80> students = customerDao.getAllCustomer();
  		//model.addAttribute("employeeList", students);
  	
  		model.addAttribute("message", "Edited Customer: " + editCustomer.getEmail());
  			
  		return "CustomerMain";
  	}
  	
  	
  	
 /** 	@PostMapping("/gottoCustMainPage")
  	
		public String goToMainCustPage(HttpSession session,  Model model) {
		
		   		int id = (int) session.getAttribute("sessionid");
	  Customer_aas_80 customer =customerDao.getOneCustomer(id);
	   
		
		model.addAttribute("currCustomer",customer );
	
			return("CustomerMain");
		}
  	**/
  	@PostMapping("/logout")
  	public String logout(HttpSession session,@ModelAttribute("login")Customer_aas_80 currCustomer, Model model)	{
  		
  		//Get the student
  		
  		//customerDao.updateCustomer(updatedcustomer);
  		//model.addAttribute("currCustomer",updatedcustomer );
  		
  		//Get a list of students from the controller
  		// List<Customer_aas_80> students = customerDao.getAllCustomer();
  		//model.addAttribute("employeeList", students);
  		session.removeAttribute("sessionid");
  		session.removeAttribute("id");
  		model.addAttribute("message", "THANK YOU");
  		
  		
  		return "Logout";
  	}
  	
  	
  	
  	}
     

