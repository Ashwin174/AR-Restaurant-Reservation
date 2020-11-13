package com.Reservation.controller_aas_80;

import java.util.ArrayList;
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
import com.Reservation.Dao_aas_80.ReservationDao_aas_80;
import com.Reservation.Dao_aas_80.EmployeeDao_aas_80;
import com.Reservation.model_aas_80.Reservation_aas_80;
import com.Reservation.model_aas_80.Customer_aas_80;
import com.Reservation.model_aas_80.Employee_aas_80;

@Controller
@Scope("session")
public class EmployeeReservationController_aas_80 {

	@Autowired
	ReservationDao_aas_80 reservationDao;
	@Autowired
	EmployeeDao_aas_80 employeeDao;

	@ModelAttribute("reservation")
	public Reservation_aas_80 setupAddForm() {
		return new Reservation_aas_80();

	}

	@PostMapping("/employeeReservation")
	public String createReservation(HttpSession session,
			@ModelAttribute("currEmployee") Employee_aas_80 currentEmployee, Model model) {
		int id = (int) session.getAttribute("sessionempid");
		Employee_aas_80 employee = employeeDao.getOneEmployee(id);

		ArrayList<Reservation_aas_80> unproceedList = new ArrayList<Reservation_aas_80>();
		ArrayList<Reservation_aas_80> proceedList = new ArrayList<Reservation_aas_80>();

		List<Reservation_aas_80> reservationAll = reservationDao.getAllReservation();
		for (Reservation_aas_80 r : reservationAll) {

			if (r.getStatus().equals("Waiting")) {
				unproceedList.add(r);
			} else {
				proceedList.add(r);
			}

		}

		model.addAttribute("unproceedList", unproceedList);
		model.addAttribute("proceedList", proceedList);

		model.addAttribute("employee", employee);

		model.addAttribute("message",
				"Hey " + employee.getName() + ", You have " + unproceedList.size() + " reservations to proceed");
		return "EmployeeReservation";
	}

	@GetMapping("/editCustomerReservationemp")
	public String editCustomerResemp(HttpSession session, @RequestParam(required = true) int id, Model model) {

		Reservation_aas_80 resDetails = reservationDao.getOnReservation(id);

		model.addAttribute("reservation", resDetails);

		int epId = (int) session.getAttribute("sessionempid");
		Employee_aas_80 employee = employeeDao.getOneEmployee(epId);
		model.addAttribute("employee", employee);

		model.addAttribute("message",
				"Hi " + employee.getName() + ",do you want to edit the Reservetion for : " + resDetails.getName());

		return "editReservationByEmp";
	}

	@PostMapping("/confirmCustomerReservationemp")
	public String confirmCustomerResemp(HttpSession session,
			@ModelAttribute("reservation") Reservation_aas_80 currentReservation, Model model) {

		reservationDao.updateReservation(currentReservation);

		int epId = (int) session.getAttribute("sessionempid");
		Employee_aas_80 employee = employeeDao.getOneEmployee(epId);
		model.addAttribute("employee", employee);

		ArrayList<Reservation_aas_80> unproceedList = new ArrayList<Reservation_aas_80>();
		ArrayList<Reservation_aas_80> proceedList = new ArrayList<Reservation_aas_80>();

		List<Reservation_aas_80> reservationAll = reservationDao.getAllReservation();
		for (Reservation_aas_80 r : reservationAll) {

			if (r.getStatus().equals("Waiting")) {
				unproceedList.add(r);
			} else {
				proceedList.add(r);
			}

		}

		model.addAttribute("unproceedList", unproceedList);
		model.addAttribute("proceedList", proceedList);

		model.addAttribute("message",
				"Hi " + employee.getName() + ",you edited the Reservetion for : " + currentReservation.getName());

		return "EmployeeReservation";
	}

	@GetMapping("/deleteCustomerReservationemp")
	public String deleteReservation(HttpSession session,@RequestParam(required = true) int id, Model model)	{
				
	
		Reservation_aas_80 currentReservation = reservationDao.getOnReservation(id);
		reservationDao.deleteReservation(id);
		int epId = (int) session.getAttribute("sessionempid");
		Employee_aas_80 employee = employeeDao.getOneEmployee(epId);
		model.addAttribute("employee", employee);
		ArrayList<Reservation_aas_80> unproceedList = new ArrayList<Reservation_aas_80>();
		ArrayList<Reservation_aas_80> proceedList = new ArrayList<Reservation_aas_80>();

		List<Reservation_aas_80> reservationAll = reservationDao.getAllReservation();
		for (Reservation_aas_80 r : reservationAll) {

			if (r.getStatus().equals("Waiting")) {
				unproceedList.add(r);
			} else {
				proceedList.add(r);
			}

		}

		model.addAttribute("unproceedList", unproceedList);
		model.addAttribute("proceedList", proceedList);

		model.addAttribute("message",
				"Hi " + employee.getName() + ",you have deleted the record of Reservetion for : " + currentReservation.getName());
			
		return "EmployeeReservation";
	}
	

}
