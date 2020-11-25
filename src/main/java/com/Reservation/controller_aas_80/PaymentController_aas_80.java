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
	public String createPayment(HttpSession session, @ModelAttribute("payment") Payment_aas_80 currentPayment,
			@RequestParam(required = true) int id, Model model) {
		int employeeId = (int) session.getAttribute("sessionempid");
		Employee_aas_80 employee = employeeDao.getOneEmployee(employeeId);
		Reservation_aas_80 currReservation = reservationDao.getOnReservation(id);
		
		//put reservation id in session to store for edit this particular reservation
		session.setAttribute("usedReservationId", id);

		Payment_aas_80 currPayment = currentPayment;
		currPayment.setCustEmail(currReservation.getEmail());
		currPayment.setDate(currReservation.getResDate());

		model.addAttribute("employee", employee);
		model.addAttribute("reservation", currReservation);

		model.addAttribute("payment", currPayment);

		model.addAttribute("message",
				"Hey " + employee.getName() + ", you are making a payment for " + currReservation.getName());

		return "createPayment";

	}

	@PostMapping("/confirmcreatePayment")
	public String confirmCreatePayment(HttpSession session, @ModelAttribute("payment") Payment_aas_80 currPayment,
			Model model) {

		// create a new payment by offered information
		Payment_aas_80 newPayment = currPayment;
		
		newPayment.setTotal(newPayment.calculationTotalamount());
		
		paymentDao.createPayment(newPayment);
		
		//after creating a payment , set the referred reservation status is finished
		Reservation_aas_80 currReservation = reservationDao.getOnReservation((int)session.getAttribute("usedReservationId"));
		currReservation.setStatus("finished");
		reservationDao.updateReservation(currReservation);
		
		
		// grab the curr employee information
		int employeeId = (int) session.getAttribute("sessionempid");
		Employee_aas_80 employee = employeeDao.getOneEmployee(employeeId);

		// catch the list of reservation which only display confirmed reservations from
		// database
		ArrayList<Reservation_aas_80> confirmedReservationList = new ArrayList<Reservation_aas_80>();
		// get list of reservation
		ArrayList<Reservation_aas_80> currReservationList = (ArrayList<Reservation_aas_80>) reservationDao
				.getAllReservation();
		for (Reservation_aas_80 r : currReservationList) {
			if (r.getStatus().equals("confirm")) {
				confirmedReservationList.add(r);
			}

		}

		// get list of PAYMENT
		ArrayList<Payment_aas_80> currPaymentList = (ArrayList<Payment_aas_80>) paymentDao.getAllPayment();

		ArrayList<Payment_aas_80> receivedPaymentList = new ArrayList<Payment_aas_80>();

		ArrayList<Payment_aas_80> waitingForPaymentList = new ArrayList<Payment_aas_80>();
		for (Payment_aas_80 p : currPaymentList) {

			if (p.getType().equals("waiting")) {
				waitingForPaymentList.add(p);

			} else {
				receivedPaymentList.add(p);
			}

		}
         // set attributes to pass for jsp
		model.addAttribute("currEmployee", employee);
		model.addAttribute("reservationList", confirmedReservationList);
		model.addAttribute("waitingPaymentList", waitingForPaymentList);
		model.addAttribute("receivedList", receivedPaymentList);

		return "paymentEmployee";
	}

	@PostMapping("headingPaymentEmployee")
	public String createheadingPayment(HttpSession session,
			@ModelAttribute("currEmployee") Employee_aas_80 createEmployee, Model model) {
		int employeeId = (int) session.getAttribute("sessionempid");
		Employee_aas_80 employee = employeeDao.getOneEmployee(employeeId);

		ArrayList<Reservation_aas_80> confirmedReservationList = new ArrayList<Reservation_aas_80>();
		// get list of reservation
		ArrayList<Reservation_aas_80> currReservationList = (ArrayList<Reservation_aas_80>) reservationDao
				.getAllReservation();
		for (Reservation_aas_80 r : currReservationList) {
			if (r.getStatus().equals("confirm")) {
				confirmedReservationList.add(r);
			}

		}

		// get list of PAYMENT
		ArrayList<Payment_aas_80> currPaymentList = (ArrayList<Payment_aas_80>) paymentDao.getAllPayment();

		ArrayList<Payment_aas_80> receivedPaymentList = new ArrayList<Payment_aas_80>();

		ArrayList<Payment_aas_80> waitingForPaymentList = new ArrayList<Payment_aas_80>();
		for (Payment_aas_80 p : currPaymentList) {

			if (p.getType().equals("waiting")) {
				waitingForPaymentList.add(p);

			} else {
				receivedPaymentList.add(p);
			}

		}

		model.addAttribute("currEmployee", employee);
		model.addAttribute("reservationList", confirmedReservationList);
		model.addAttribute("waitingPaymentList", waitingForPaymentList);
		model.addAttribute("receivedList", receivedPaymentList);
		return "paymentEmployee";
	}

}
