package com.org.project.BookMyShow.Entity;


import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
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
	
	
	@Positive(message = "Enter the correct ticket value")
	@Min(value = 1)
	private int totalTicket;
	
	@Positive(message = "Enter the correct Amount")
	@Min(value = 1)
	private double bookingAmount;
	
	private LocalDate bookingDate;
	
	private String bookingTime;
	
	private ClassType classtype;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Shows shows;	
}
