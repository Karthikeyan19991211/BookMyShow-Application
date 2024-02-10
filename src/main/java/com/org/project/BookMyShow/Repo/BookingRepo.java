package com.org.project.BookMyShow.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.project.BookMyShow.Entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>
{

}
