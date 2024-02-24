package com.org.project.BookMyShow.Entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Component
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotNull(message = "User name should not blak..!!")
	@NotBlank(message = "User name should not null..!!")
	private String userName;
	
	@Positive(message = "Enter the valid mobile number...!!")
	@Min(value = 6000000000l,message = "Enter the valid mobile number...!!")
	@Max(value = 9999999999l,message = "Enter the valid mobile number...!!")
	private long userContact;
	
	@Email(message = "Enter the valid Email...!!")
	private String userEmail;
	
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*=+])(?=.*[0-9]).{8,}$",message ="Enter the Valid & Strong Password..!!")
	private String userPassword;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> booking;

}
