package com.org.project.BookMyShow.DAO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.project.BookMyShow.Entity.Booking;
import com.org.project.BookMyShow.Repo.BookingRepo;

@Repository
public class BookingDAO {
	@Autowired
	BookingRepo repo;

	public Booking saveBooking(Booking booking) {
		
		LocalDate cur = LocalDate.now();
		booking.setBookingDate(cur);
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
		booking.setBookingTime(sdf.format(new Date()));
		
		return repo.save(booking);
	}

	public Booking findBooking(int bookingId) {
		Optional<Booking> booking = repo.findById(bookingId);

		if (booking.isPresent()) {
			return booking.get();
		}

		return null;
	}

	public Booking deleteBooking(int bookingId) {
		Booking booking = findBooking(bookingId);

		if (booking != null) {
			repo.delete(booking);
			return booking;
		}
		return null;
	}

	public Booking updateBooking(int bookingId, Booking booking) {
		Booking exBooking = findBooking(bookingId);

		if (exBooking != null) {
			booking.setBookingId(bookingId);

			if (booking.getTotalTicket() == 0) {
				booking.setTotalTicket(exBooking.getTotalTicket());
			}

			if (booking.getBookingAmount() == 0.0) {
				booking.setBookingAmount(exBooking.getBookingAmount());
			}
			
			if(booking.getBookingDate() == null)
			{
				booking.setBookingDate(exBooking.getBookingDate());
			}
			
			if(booking.getBookingTime() == null)
			{
				booking.setBookingTime(exBooking.getBookingTime());
			}
			
			return repo.save(booking);
		}
		return null;
	}
	
	public List<Booking> findAllBookings()
	{
		return repo.findAll();
	}

}
