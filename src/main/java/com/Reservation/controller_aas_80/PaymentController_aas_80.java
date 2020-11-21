package com.Reservation.controller_aas_80;

import java.util.ArrayList;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.Reservation.Dao_aas_80.EmployeeDao_aas_80;
import com.Reservation.Dao_aas_80.ReservationDao_aas_80;
import com.Reservation.Dao_aas_80.paymentDao_aas_80;

import com.Reservation.model_aas_80.Employee_aas_80;
import com.Reservation.model_aas_80.Payment_aas_80;
import com.Reservation.model_aas_80.Reservation_aas_80;

@Controller
@Scope("session")
public class PaymentController_aas_80 {

	
	@Autowired
	paymentDao_aas_80 paymentDao;
	
	@Autowired
	ReservationDao_aas_80 reservationDao;
	
	@Autowired
	EmployeeDao_aas_80 employeeDao;
	
	@ModelAttribute("reservation")
	public Payment_aas_80 setupAddForm() {
		return new Payment_aas_80();

	}
	
	@GetMapping("/createPayment")
	public String createPayment(HttpSession session,@ModelAttribute("payment") Payment_aas_80 currentPayment,@RequestParam(required = true) int id, Model model) {
		   int employeeId = (int) session.getAttribute("sessionempid");
		  	 Employee_aas_80 employee = employeeDao.getOneEmployee(employeeId);
		  	Reservation_aas_80 currReservation = reservationDao.getOnReservation(id);
		  	 
		  	 Payment_aas_80 currPayment= currentPayment;
		  	currPayment.setCustEmail(currReservation.getEmail());
		  	currPayment.setDate(currReservation.getResDate());
		  	 
		  	 model.addAttribute("employee",employee);
		  	 model.addAttribute("reservation",currReservation);
		  	 
		  	 model.addAttribute("payment",currPayment);
		  	 
		  	  
		  	model.addAttribute("message","Hey "+ employee.getName()+ ", you are making a payment for " + currReservation.getName());
		  	
		  	return "createPayment";
		  	
		  
	}
	
	
	
	
	
	@PostMapping("/confirmcreatePayment")
	public String confirmCreatePayment(HttpSession session,@ModelAttribute("payment") Payment_aas_80 currPayment, Model model) {

	paymentDao.createPayment(currPayment);
                    
	
		  int employeeId = (int) session.getAttribute("sessionempid");
		   Employee_aas_80 employee = employeeDao.getOneEmployee(employeeId);
		   
		   //get list of reservation
		   ArrayList<Reservation_aas_80> currList= (ArrayList<Reservation_aas_80>) reservationDao.getAllReservation();
		   
		   model.addAttribute("currEmployee", employee);
		   model.addAttribute("reservationList", currList);
		   
		   
		   
	return "paymentEmployee";
	}	
	
	@PostMapping("headingPaymentEmployee")
	public String createheadingPayment(HttpSession session,@ModelAttribute("currEmployee") Employee_aas_80 createEmployee, Model model) {
		   int employeeId = (int) session.getAttribute("sessionempid");
		   Employee_aas_80 employee = employeeDao.getOneEmployee(employeeId);
		   
		   //get list of reservation
		   ArrayList<Reservation_aas_80> currList= (ArrayList<Reservation_aas_80>) reservationDao.getAllReservation();
		   
		   model.addAttribute("currEmployee", employee);
		   model.addAttribute("reservationList", currList);

	 return "paymentEmployee";
	}
	
	
	
	
}
