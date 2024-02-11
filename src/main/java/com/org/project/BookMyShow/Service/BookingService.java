package com.org.project.BookMyShow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.BookingDAO;
import com.org.project.BookMyShow.Entity.Booking;

@Service
public class BookingService 
{
	@Autowired
	BookingDAO dao;
	
	public Booking saveBooking(Booking booking)
	{
		return dao.saveBooking(booking);
	}
	
	public Booking findBooking(int bookingId)
	{
		return dao.findBooking(bookingId);
	}
	
	public Booking deleteBooking(int bookingId)
	{
		return dao.deleteBooking(bookingId);
	}
	
	public Booking updateBooking(int bookingId,Booking booking)
	{
		return dao.updateBooking(bookingId, booking);
	}
	
	public List<Booking> findAllBookings()
	{
		return dao.findAllBookings();
	}

}
