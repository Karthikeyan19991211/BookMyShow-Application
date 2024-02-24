package com.org.project.BookMyShow.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.project.BookMyShow.Entity.Booking;
import com.org.project.BookMyShow.Service.BookingService;
import com.org.project.BookMyShow.Util.ResponseStructure;

@RestController
@RequestMapping("booking")
public class BookingController 
{
	
	@Autowired
	BookingService service;
	
/*	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking)
	{
		return service.saveBooking(booking);
	} */
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Booking>> findBooking(@RequestParam int bookingId)
	{
		return service.findBooking(bookingId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam int bookingId)
	{
		return service.deleteBooking(bookingId);
	}
	
/*	@PutMapping
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestParam int bookingId,@RequestBody Booking booking)
	{
		return service.updateBooking(bookingId, booking);
	} */
	
	@GetMapping("findAllBookings")
	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBookings()
	{
		return service.findAllBookings();
	}
	
	@PutMapping("assignShow")
	public ResponseEntity<ResponseStructure<Booking>> assignShows(@RequestBody Booking booking,@RequestParam int showId,@RequestParam int userId)
	{
		return service.assignShows(booking, showId,userId);
	}
}