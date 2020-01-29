package com.app.daos;

import java.util.List;

import com.app.pojos.Booking;




public interface IbookingDao 
{
	List<Booking> getAllBookingDetails();
	Integer addBooking(Booking b);
	Booking getBookingById(int b);
	void deleteBookingById(Integer bid);
	void updateBookingr(Booking b);


}
