package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Booking;



@Repository
@Transactional
public class bookingDao implements IbookingDao{

	
	@Autowired
	private SessionFactory sf;
	@Override
	public List<Booking> getAllBookingDetails() {
		
		String jpql = "select b from Booking b";
		return sf.getCurrentSession().createQuery(jpql, Booking.class).getResultList();
	}
	@Override
	public Integer addBooking(Booking b) {
		
		return (Integer) sf.getCurrentSession().save(b);
	}
	@Override
	public Booking getBookingById(int b) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteBookingById(Integer bid) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateBookingr(Booking b) {
		// TODO Auto-generated method stub
		
	}

}
