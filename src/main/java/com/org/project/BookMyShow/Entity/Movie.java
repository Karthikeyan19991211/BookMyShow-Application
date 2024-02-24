package com.org.project.BookMyShow.Entity;


import org.springframework.stereotype.Component;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Component
public class Movie 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	
	@NotNull(message = "Movie name should not null..")
	@NotBlank(message = "Movie name should not blank..")
	private String movieName;
	
	@NotNull(message = "Actor name should not null..")
	@NotBlank(message = "Actor name should not blank..")
	private String movieActor;
	
	@NotNull(message = "Genre name should not null..")
	@NotBlank(message = "Genre name should not blank..")
	private String movieGenre;
	
	@DecimalMin(value = "0.01")
	private double movieAmount;

}
