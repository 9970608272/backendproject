package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.daos.IbookingDao;
import com.app.pojos.Booking;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController 
{

	@Autowired
	private IbookingDao dao;


	@GetMapping("/getallbooking")
	ResponseEntity<?> getAllBookingDetails()
	{
		System.out.println("in booking ");
		return new ResponseEntity<List<Booking>>(dao.getAllBookingDetails() , HttpStatus.OK);
	}
	
	@PostMapping(value = "/addbooking", consumes = "application/json", produces = "application/json")
	public Integer addAppointment(@RequestBody Booking b) 
	{
		System.out.println(b);
	
		
		
		return dao.addBooking(b);
	}
	
}
