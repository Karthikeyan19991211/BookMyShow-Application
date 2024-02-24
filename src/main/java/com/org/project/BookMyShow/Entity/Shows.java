package com.org.project.BookMyShow.Entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Component
public class Shows 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showId;
	private ShowType showType;
	private String showTiming;
		
	@JsonIgnore
	@ManyToOne
	private Screen screen;
	
	private int movieId;	
}
