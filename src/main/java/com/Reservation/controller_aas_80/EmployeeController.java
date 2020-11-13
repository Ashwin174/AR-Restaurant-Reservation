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





@Controller
@Scope("session")
public class EmployeeController {

	@Autowired
	CustomerDao_aas_80 customerDao;
	
	 @Autowired
	EmployeeDao_aas_80 employeeDao;
 
	@ModelAttribute("employee")
	public Employee_aas_80 setupAddForm() {
		return new Employee_aas_80();

	}
   @GetMapping("/empLogin")
	public String index(@ModelAttribute("login") Employee_aas_80 employee, Model model) {
	   
		return "index";
	}
	
   
   
   @PostMapping("/empLogin")
	public String loginVerification(HttpSession session, @ModelAttribute("login") Employee_aas_80 employee, Model model) {
	  
	  
	        
	   Employee_aas_80 verifiedEmployee ;
	   System.out.println(employee.getEmail());
	   System.out.println(employee.getPassword());
	   verifiedEmployee= employeeDao.EmpVerification(employee);
		
			
			if (verifiedEmployee != null) {
				model.addAttribute("currEmployee",verifiedEmployee);
				session.setAttribute("sessionempid", verifiedEmployee.getId());
				return "EmployeeMain";
			} else {
				model.addAttribute("error", "Please Enter Your Correct Email and Password");
				return "index";
			}
		
   }
   
   @GetMapping("/showEmployee")
	public String showEmployee(HttpSession session, Model model)	{
		//Get a list of students from the database
	   
	   int id = (int) session.getAttribute("id");
	   Employee_aas_80 employee = employeeDao.getOneEmployee(id);
		List<Employee_aas_80> employees = employeeDao.getAllEmployee();
			
		
		//Add the list of students to the model to be returned to the view
		String name = employee.getName();
		model.addAttribute("employeeList", employees);
		model.addAttribute("message", "Welcome,  " + name );
		return "EmployeeDetail";
	}
   
	
	@PostMapping("/createEmployee")
	public String createEmployee(@ModelAttribute("login") Employee_aas_80 createEmployee, Model model) {

		 //Create the student pass the object in.
		//employeeDao.createEmployee(createEmployee);

	//Get a list of students from the controller
//	List<Employee_aas_80> employees = employeeDao.getAllEmployee();
//	model.addAttribute("employeeList", employees);

	return "EmployeeRegister";
	}
	
	@PostMapping("/RegisteredEmployee")
	public String RegisteredEmployee(@ModelAttribute("login") Employee_aas_80 createEmployee, Model model) {

		 //Create the student pass the object in.
		employeeDao.createEmployee(createEmployee);

	//Get a list of students from the controller
//	List<Employee_aas_80> employees = employeeDao.getAllEmployee();
//	model.addAttribute("employeeList", employees);

	return "index";
	}
	
	
	
	@GetMapping("/deleteCustomer")
	public String deleteEmployee(@RequestParam(required = true) int id, Model model)	{
				
		//Get the student
		customerDao.deleteCustomer(id);
		
		//Get a list of students from the controller
		List<Customer_aas_80> customers = customerDao.getAllCustomer();
		model.addAttribute("customerList", customers);
	
		model.addAttribute("message", "Deleted Customer: " + id);
			
		return "CustomerDetail";
	}
	
	
	@GetMapping("/editCustomeremp")
	public String editCustomeremp(@RequestParam(required = true) int id, Model model) {
		
		
		Customer_aas_80 custDetails =customerDao.getOneCustomer(id);
			model.addAttribute("currCustomer",custDetails );
		
		
		
			//employeeDao.updateEmployee(updatedemployee);
	  		//model.addAttribute("currEmployee",updatedemployee );
	  		
	  		//Get a list of customer from the controller
	  		 List<Customer_aas_80> customers = customerDao.getAllCustomer();
	  		model.addAttribute("customerList", customers);
	  	
	  		model.addAttribute("message", "Edited Customer: " + custDetails.getEmail());
	  			
	  		return "editCustomer";
	  	}
	
	@PostMapping("/confirmcustedit")
	public String confirmcustemp(HttpSession session,@ModelAttribute("currCustomer")Customer_aas_80 updatedcustomer, Model model) {
	customerDao.updateCustomer(updatedcustomer);
		
		//Get a list of students from the controller
		List<Customer_aas_80> customers = customerDao.getAllCustomer();
		model.addAttribute("customerList", customers);
		
		int id = (int) session.getAttribute("sessionempid");
		
		Employee_aas_80 oneDetails =employeeDao.getOneEmployee(id);
			model.addAttribute("currEmployee",oneDetails );
	
		model.addAttribute("message", "Edited Customer: " + updatedcustomer.getEmail());		
		return "CustomerDetail";
	}
	
	
	
	
	@PostMapping("/editEmployee")
	public String directtoEdit(HttpSession session, Model model) {	
  		//Get the employee
  		
	int id = (int) session.getAttribute("sessionempid");
	
	Employee_aas_80 oneDetails =employeeDao.getOneEmployee(id);
		model.addAttribute("currEmployee",oneDetails );
	
	
	
		//employeeDao.updateEmployee(updatedemployee);
  		//model.addAttribute("currEmployee",updatedemployee );
  		
  		//Get a list of students from the controller
  		// List<Customer_aas_80> students = customerDao.getAllCustomer();
  		//model.addAttribute("employeeList", students);
  	
  		model.addAttribute("message", "Edited Employee: " + oneDetails.getEmail());
  			
  		return "editEmployee";
  	}
   	@PostMapping("/confirmempEdit")
   	public String editEmployee(HttpSession session,@ModelAttribute("currEmployee") Employee_aas_80 updatedemployee, Model model)	{
  		  		
  		//Get the student
   		
   		employeeDao.updateEmployee(updatedemployee);
   		int id = (int) session.getAttribute("sessionempid");
   	   Employee_aas_80 editEmployee =employeeDao.getOneEmployee(id);
   	   
  		
  		model.addAttribute("currEmployee",editEmployee );
  		

  	
  		model.addAttribute("message", "Edited Employee: " + editEmployee.getEmail());
  			
  		return "EmployeeMain";
  	}
  	
   	
  	@PostMapping("/showCustomers")
     public String showCustomer(HttpSession session,@ModelAttribute("showCustomer")Employee_aas_80 viewcustomer,Model model) {
  		  int id = (int) session.getAttribute("sessionempid");
    	   Employee_aas_80 employee =employeeDao.getOneEmployee(id);
    	   
   		
   		List<Customer_aas_80> customers = customerDao.getAllCustomer();
  		model.addAttribute("customerList", customers);
  		model.addAttribute("currEmployee", employee);
   		return("CustomerDetail");
   		
   	}
  	
  	@PostMapping("/ToEmployeeMain")
  	
  		public String goToMainPage(HttpSession session,  Model model) {
  		
  		   		int id = (int) session.getAttribute("sessionempid");
   	   Employee_aas_80 employee =employeeDao.getOneEmployee(id);
   	   
   	
  		List<Customer_aas_80> customers = customerDao.getAllCustomer();
 		model.addAttribute("customerList", customers);
 			
  		model.addAttribute("currEmployee",employee );
  	
  			return("EmployeeMain");
  		}
  	

  
}