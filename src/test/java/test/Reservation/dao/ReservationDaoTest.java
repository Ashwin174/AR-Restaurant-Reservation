package test.Reservation.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import com.Reservation.Dao_aas_80.ReservationDao_aas_80;

import com.Reservation.model_aas_80.Reservation_aas_80;

class ReservationDaoTest {

	DriverManagerDataSource dataSource;
	Connection conn = null;
	String url = "jdbc:h2:tcp://localhost/~/test";
	List<Reservation_aas_80> listToTest = new ArrayList<Reservation_aas_80>();
	ReservationDao_aas_80 daoToTest;
	int preSize;
	Reservation_aas_80 ReservationToTest;

	@BeforeEach
	void setUp() throws Exception {

		dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		daoToTest = new ReservationDao_aas_80(dataSource);
		listToTest = daoToTest.getAllReservation();

		preSize = listToTest.size();

		ReservationToTest = new Reservation_aas_80();
		ReservationToTest.setName("TestName");
		ReservationToTest.setEmail("TestName@gamil.com");
		ReservationToTest.setPhone_number("11110000");
		ReservationToTest.setTime("6:00");
		ReservationToTest.setResDate(Date.valueOf("2020-09-10"));
        ReservationToTest.setPeopleNumber("7");
        ReservationToTest.setStatus("Confirmed");;
		
		
		

		daoToTest.createReservation(ReservationToTest);
	}

	@Test
	void testGetAll() {
		List<Reservation_aas_80> currList = daoToTest.getAllReservation();
		assertEquals(preSize + 1, currList.size());
		//delete last record because we do not want to change the database
	   daoToTest.deleteReservation(currList.get(currList.size()-1).getId());
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetReservationrByID() {
		List<Reservation_aas_80> currList = daoToTest.getAllReservation();
		
		Reservation_aas_80 curr = new Reservation_aas_80();
		curr = listToTest.get(0);

		int currId = (int) curr.getId();
		String username = curr.getName();

		assertEquals(username, daoToTest.getOnReservation(currId).getName());
		//delete last customer because we do not want to change the database anymore
		assertTrue(daoToTest.deleteReservation(currList.get(currList.size()-1).getId()));

	};

	@Test
	void testUpdateReservation() {
			
		List<Reservation_aas_80> currList = new ArrayList<Reservation_aas_80>();
		currList = daoToTest.getAllReservation();
		
		//set attribute for update test
		Reservation_aas_80 testUpdateReservation= daoToTest.getOnReservation(currList.get(currList.size()-1).getId());
				
		testUpdateReservation.setStatus("Pending");
		
		//test update function if it works
		assertTrue(daoToTest.updateReservation(testUpdateReservation));
		
		//delete curr customer because we do not want to change the database anymore
		assertTrue(daoToTest.deleteReservation(currList.get(currList.size()-1).getId()));

	};

	@Test
	void testDeleteReservation() {
		
		//add one record to database to make the list one more longer
		Reservation_aas_80 ReservationToDelete = new Reservation_aas_80();
		ReservationToDelete.setName("Name is changed");
		daoToTest.createReservation(ReservationToDelete);
		
		List<Reservation_aas_80> originalList = new ArrayList<Reservation_aas_80>();
		originalList = daoToTest.getAllReservation();
		
		//get last element of list to delete
		int id= originalList.get(originalList.size()-1).getId();

		Reservation_aas_80 curr = daoToTest.getOnReservation(id);
		curr.setName("Name is changed");

		assertTrue(daoToTest.deleteReservation(curr.getId()));

		List<Reservation_aas_80> currList = new ArrayList<Reservation_aas_80>();
		currList = daoToTest.getAllReservation();
		// After processing delete method so current list should be less 1 than before
		assertEquals(originalList.size() - 1, currList.size());
		//because of BeforeEach function executes before everyTest runs, we need to delete last one record to
		//keep database record originally
		assertTrue(daoToTest.deleteReservation(currList.get(currList.size()-1).getId()));

	}


}
