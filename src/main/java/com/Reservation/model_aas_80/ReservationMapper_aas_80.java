package com.Reservation.model_aas_80;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReservationMapper_aas_80 implements RowMapper<Reservation_aas_80> {
	
	public Reservation_aas_80 mapRow(ResultSet resultSet, int i) throws SQLException	{
	
		Reservation_aas_80 reservation = new Reservation_aas_80();
		reservation.setId(resultSet.getInt("id"));
		reservation.setName(resultSet.getString("name"));
		reservation.setEmail(resultSet.getString("email"));
		reservation.setPhone_number(resultSet.getString("phone_number"));
		reservation.setTime(resultSet.getString("time"));
		reservation.setResDate(resultSet.getDate("resDate"));
		reservation.setPeopleNumber(resultSet.getString("peopleNumber"));
		reservation.setStatus(resultSet.getString("status"));
		
		return reservation;
		
	}
}