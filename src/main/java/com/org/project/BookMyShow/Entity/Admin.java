package com.org.project.BookMyShow.Entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
@Component
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	private long adminContact;
	private String adminEmail;
	private String adminPassword;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Theatre> theatre;	

}
