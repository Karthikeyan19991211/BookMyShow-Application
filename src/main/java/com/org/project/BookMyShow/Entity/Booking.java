package com.org.project.BookMyShow.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Component
public class Booking 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private int totalTicket;
	private double bookingAmount;
	private String bookingDate;
	private String bookingTime;
	
	private ClassType classtype;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Shows shows;

}
