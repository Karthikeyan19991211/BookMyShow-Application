package com.org.project.BookMyShow.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.BookingDAO;
import com.org.project.BookMyShow.DAO.MovieDAO;
import com.org.project.BookMyShow.DAO.ShowsDAO;
import com.org.project.BookMyShow.DAO.UserDAO;
import com.org.project.BookMyShow.Entity.Booking;
import com.org.project.BookMyShow.Entity.Movie;
import com.org.project.BookMyShow.Entity.Shows;
import com.org.project.BookMyShow.Entity.User;
import com.org.project.BookMyShow.Exception.ListNotFoundException;
import com.org.project.BookMyShow.Exception.NotFoundException;
import com.org.project.BookMyShow.Util.ResponseStructure;

@Service
public class BookingService {
	@Autowired
	BookingDAO dao;

	@Autowired
	ShowsDAO sDao;

	@Autowired
	UserDAO uDao;

	@Autowired
	MovieDAO mDao;

	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking) {
		ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
		structure.setMessage("Booking Details saved Successfully...!!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveBooking(booking));
		return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Booking>> findBooking(int bookingId) {
		Booking booking = dao.findBooking(bookingId);

		if (booking != null) {
			ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
			structure.setMessage("Booking Details finded Successfully...!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(booking);
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.FOUND);
		}
		throw new NotFoundException("Booking details doesn't exist....!!!!");
	}

	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(int bookingId) {
		Booking booking = dao.deleteBooking(bookingId);

		if (booking != null) {
			ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
			structure.setMessage("Booking Details Deleted Successfully...!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(booking);
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		}
		throw new NotFoundException("Booking details doesn't exist");
	}

	public ResponseEntity<ResponseStructure<Booking>> updateBooking(int bookingId, Booking booking) {
		Booking newBooking = dao.updateBooking(bookingId, booking);
		if (newBooking != null) {

			ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
			structure.setMessage("Booking Details updated Successfully...!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(newBooking);
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		}
		throw new NotFoundException("Booking details doesn't exist...!!!!");
	}

	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBookings() {
		List<Booking> listBooking = dao.findAllBookings();
		if (listBooking != null) {
			ResponseStructure<List<Booking>> structure = new ResponseStructure<List<Booking>>();
			structure.setMessage("All Booking Details finded Successfully...!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(listBooking);
			return new ResponseEntity<ResponseStructure<List<Booking>>>(structure, HttpStatus.OK);
		}
		throw new ListNotFoundException("List of Boking details doesn'y exist...!!!!!");
	}

	public ResponseEntity<ResponseStructure<Booking>> assignShows(Booking booking, int showId, int userId) {

		Shows show = sDao.findShow(showId);
		if (show != null) {
			int movieId = show.getMovieId();
			Movie movie = mDao.findMovie(movieId);
			booking.setBookingAmount(movie.getMovieAmount()*booking.getTotalTicket());

			LocalDate cur = LocalDate.now();
			booking.setBookingDate(cur);

			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
			booking.setBookingTime(sdf.format(new Date()));
			
			Booking exBooking = dao.saveBooking(booking);
			if (exBooking != null) {
				exBooking.setShows(show);
				Booking newBooking = dao.saveBooking(exBooking);

				if (exBooking.getShows() != null) {
					User user = uDao.findUser(userId);
					List<Booking> listBooking = user.getBooking();

					listBooking.add(newBooking);
					uDao.saveUser(user);

//					UserDTO dto = new UserDTO();
//					ModelMapper mapper = new ModelMapper();
//					mapper.map(newUser, dto);
				}

				ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
				structure.setMessage("Successfully Your Movie Shows Booked...!!!");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(newBooking);

				return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
			}
			throw new NotFoundException("Booking details doesn't exist...!!!!");// booking not found
		}
		throw new NotFoundException("Show details doesn't exist...!!!!");// show not found

	}
}
