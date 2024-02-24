package com.org.project.BookMyShow.Entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Component
public class Theatre 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
	
	@NotBlank(message = "Theatre name should not Blank...!!")
	@NotNull(message = "Theatre name should not Null...!!")
	private String theatreName;
	
	@Positive(message = "Enter the correct Mobile number..!!!")
	@Min(value = 6000000000l,message = "Enter the correct Mobile number..!!!")
	@Max(value = 9999999999l,message = "Enter the correct Mobile number..!!!")
	private long theatreContact;
	
	@NotBlank(message = "Theatre Location should not Blank...!!")
	@NotNull(message = "Theatre Location should not Null...!!")
	private String theatreLocation;
	
	
	private int noOfScreen;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Screen> screen;
}
