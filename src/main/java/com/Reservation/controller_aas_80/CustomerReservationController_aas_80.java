package com.Reservation.controller_aas_80;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Reservation.Dao_aas_80.CustomerDao_aas_80;
import com.Reservation.Dao_aas_80.ReservationDao_aas_80;
import com.Reservation.model_aas_80.Reservation_aas_80;
import com.Reservation.model_aas_80.Customer_aas_80;

/**
 * 
 * @author ashwi
 * customer Reservation will do the action for reservation of customers 
 */
@Controller
@Scope("session")
public class CustomerReservationController_aas_80 {

	
	@Autowired
	ReservationDao_aas_80 reservationDao;
	@Autowired
	CustomerDao_aas_80 customerDao;
	@ModelAttribute("reservation")
	public Reservation_aas_80 setupAddForm() {
		return new Reservation_aas_80();

	}
	
	@PostMapping("/customerReservation")
	public String createReservation(HttpSession session,@ModelAttribute("currCustomer") Customer_aas_80 currentCustomer, Model model) {
		   int id = (int) session.getAttribute("sessionid");
		  	 Customer_aas_80 customer = customerDao.getOneCustomer(id);
		  	 // list all the customer those who have already reserved
		
	ArrayList<Reservation_aas_80> curList= new ArrayList<Reservation_aas_80>();
List<Reservation_aas_80> reservationAll = reservationDao.getAllReservation();
		for (Reservation_aas_80 r : reservationAll) {
			
			if(r.getEmail().equals(customer.getEmail())) {
				curList.add(r);
			}
			
		}

		            Reservation_aas_80 currReservation = new Reservation_aas_80();
		            currReservation.setName(customer.getName());
		            currReservation.setEmail(customer.getEmail());
		            currReservation.setPhone_number(customer.getPhone_number());
		            currReservation.setStatus("Waiting");
		 model.addAttribute("reservationList",curList);
		 model.addAttribute("customer", customer);
		 model.addAttribute("reservation",currReservation);
		 model.addAttribute("message","Hello " + customer.getName());
	return "ReservationResult";
	}
	
	
	
	
	
	@PostMapping("/createReservation")
	public String RegisteredReservation(HttpSession session,@ModelAttribute("reservation") Reservation_aas_80 createReservation, Model model) {

		 //Create the customer pass the object in.
		// create the reservation for the customer
		reservationDao.createReservation(createReservation);
		 int id = (int) session.getAttribute("sessionid");
	  	 Customer_aas_80 customer = customerDao.getOneCustomer(id);
	  	 model.addAttribute("customer",customer);
	  	 model.addAttribute("message","Hey"+ customer.getName()+",you have already reserved");
	  	ArrayList<Reservation_aas_80> curList= new ArrayList<Reservation_aas_80>();
	  	List<Reservation_aas_80> reservationAll = reservationDao.getAllReservation();
	  			for (Reservation_aas_80 r : reservationAll) {
	  				
	  				if(r.getEmail().equals(customer.getEmail())) {
	  					curList.add(r);
	  				}
	  				
	  			}
	  			 model.addAttribute("reservationList",curList);
	return "ReservationResult";
	}
	
}
