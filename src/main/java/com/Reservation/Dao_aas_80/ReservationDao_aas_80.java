package com.Reservation.Dao_aas_80;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.Reservation.model_aas_80.ReservationMapper_aas_80;
import com.Reservation.model_aas_80.Reservation_aas_80;

@Component
public class ReservationDao_aas_80 {

	JdbcTemplate jdbcTemplete;

	private final String SQL_GET_ALL = "SELECT * FROM reservation";
	private final String SQL_CREATE_RESERVATION = "INSERT INTO reservation(name,email,phone_number,time,resDate,peopleNumber,status) VALUES(?,?,?,?,?,?,?)";
	private final String SQL_DELETE_RESERVATION = "DELETE FROM reservation WHERE id = ?";
	// private final String SQL_VERIFY_EMPLOYEE ="SELECT * FROM employee WHERE email=?";
    private final String SQL_GETONE_RESERVATION ="Select * from reservation where id =?";
    private final String SQL_UPDATE_RESERVATION ="UPDATE reservation SET name = ?, email= ?, phone_number= ?,  time = ?, resDate = ?, peopleNumber =?, status =? WHERE id=?";
    
	
	
    @Autowired
	public ReservationDao_aas_80(DataSource dataSource) {
		jdbcTemplete = new JdbcTemplate(dataSource);
	}

	public List<Reservation_aas_80> getAllReservation() {
		return jdbcTemplete.query(SQL_GET_ALL, new ReservationMapper_aas_80());
	}

	public boolean createReservation(Reservation_aas_80 newCustomer) {
				return jdbcTemplete.update(SQL_CREATE_RESERVATION, newCustomer.getName(), newCustomer.getEmail(),newCustomer.getPhone_number(),newCustomer.getTime(),newCustomer.getResDate(),newCustomer.getPeopleNumber(),newCustomer.getStatus()) > 0;
			}
	
	public boolean deleteReservation(int idToDelete) {
		return jdbcTemplete.update(SQL_DELETE_RESERVATION, idToDelete) > 0;
	}
	
	public Reservation_aas_80 getOnReservation(int id)	{
		return jdbcTemplete.queryForObject(SQL_GETONE_RESERVATION,new Object[] {id}, new ReservationMapper_aas_80());
	}
	
    public boolean updateReservation(Reservation_aas_80 Updatedetail) {		
		return jdbcTemplete.update(SQL_UPDATE_RESERVATION,Updatedetail.getName(),Updatedetail.getEmail(),Updatedetail.getPhone_number(),Updatedetail.getTime(),Updatedetail.getResDate(),Updatedetail.getPeopleNumber(),Updatedetail.getStatus(),Updatedetail.getId()) > 0;
	}
    
   
	
}
