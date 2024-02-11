package com.org.project.BookMyShow.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.project.BookMyShow.Entity.Booking;
import com.org.project.BookMyShow.Service.BookingService;

@RestController
@RequestMapping("booking")
public class BookingController 
{
	
	@Autowired
	BookingService service;
	
	@PostMapping
	public Booking saveBooking(@RequestBody Booking booking)
	{
		return service.saveBooking(booking);
	}
	
	@GetMapping
	public Booking findBooking(@RequestParam int bookingId)
	{
		return service.findBooking(bookingId);
	}
	
	@DeleteMapping
	public Booking deleteBooking(@RequestParam int bookingId)
	{
		return service.deleteBooking(bookingId);
	}
	
	@PutMapping
	public Booking updateBooking(@RequestParam int bookingId,@RequestBody Booking booking)
	{
		return service.updateBooking(bookingId, booking);
	}
	
	@GetMapping("findAllBookings")
	public List<Booking> findAllBookings()
	{
		return service.findAllBookings();
	}


}
