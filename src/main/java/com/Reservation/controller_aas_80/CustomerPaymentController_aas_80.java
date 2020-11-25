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

import com.Reservation.Dao_aas_80.CustomerDao_aas_80;

import com.Reservation.Dao_aas_80.ReservationDao_aas_80;
import com.Reservation.Dao_aas_80.paymentDao_aas_80;
import com.Reservation.model_aas_80.Customer_aas_80;

import com.Reservation.model_aas_80.Payment_aas_80;


@Controller
@Scope("session")
public class CustomerPaymentController_aas_80 {

	@Autowired
	paymentDao_aas_80 paymentDao;

	@Autowired
	ReservationDao_aas_80 reservationDao;

	@Autowired
	CustomerDao_aas_80 customerDao;

	@ModelAttribute("reservation")
	public Payment_aas_80 setupAddForm() {
		return new Payment_aas_80();

	}

	@GetMapping("/updatePaymentbyCustomer")
	public String UpdatePaymentbyCustomer(HttpSession session,
			@ModelAttribute("currCustomer") Customer_aas_80 currCustomer, @RequestParam(required = true) int id,
			Model model) {

		int customerId = (int) session.getAttribute("sessionid");
		Customer_aas_80 customer = customerDao.getOneCustomer(customerId);

		Payment_aas_80 currPayment = paymentDao.getOnePayment(id);
		currPayment.setType("paid");

		paymentDao.updatePayment(currPayment);

		model.addAttribute("currCustomer", customer);

		model.addAttribute("message",
				"Hey " + customer.getName() + ", you have confirmed the payment for the record which the id is" + currPayment.getId());

		// get list of PAYMENT
		ArrayList<Payment_aas_80> currPaymentList = (ArrayList<Payment_aas_80>) paymentDao.getAllPayment();

		ArrayList<Payment_aas_80> receivedPaymentList = new ArrayList<Payment_aas_80>();

		ArrayList<Payment_aas_80> waitingForPaymentList = new ArrayList<Payment_aas_80>();
		for (Payment_aas_80 p : currPaymentList) {

			if (customer.getEmail().equals(p.getCustEmail())) {

				if (p.getType().equals("waiting")) {
					waitingForPaymentList.add(p);

				} else {
					receivedPaymentList.add(p);
				}
			}

		}

		model.addAttribute("waitingPaymentList", waitingForPaymentList);
		model.addAttribute("receivedList", receivedPaymentList);

		return "CustomerPayment";

	}

	@PostMapping("/showPayments")
	public String confirmPaymentCustomer(HttpSession session,
			@ModelAttribute("currCustomer") Customer_aas_80 currCustomer, Model model) {

		// grab the curr employee information
		int customerId = (int) session.getAttribute("sessionid");
		Customer_aas_80 customer = customerDao.getOneCustomer(customerId);

		// get list of PAYMENT
		ArrayList<Payment_aas_80> currPaymentList = (ArrayList<Payment_aas_80>) paymentDao.getAllPayment();

		ArrayList<Payment_aas_80> receivedPaymentList = new ArrayList<Payment_aas_80>();

		ArrayList<Payment_aas_80> waitingForPaymentList = new ArrayList<Payment_aas_80>();
		for (Payment_aas_80 p : currPaymentList) {
			if (customer.getEmail().equals(p.getCustEmail())) {

				if (p.getType().equals("waiting")) {
					waitingForPaymentList.add(p);

				} else {
					receivedPaymentList.add(p);
				}
			}

		}
		// set attributes to pass for jsp
		model.addAttribute("currCustomer", customer);

		model.addAttribute("waitingPaymentList", waitingForPaymentList);
		model.addAttribute("receivedList", receivedPaymentList);

		return "CustomerPayment";
	}

}
