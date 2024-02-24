package com.org.project.BookMyShow.DTO;

import java.util.List;

import com.org.project.BookMyShow.Entity.Movie;
import com.org.project.BookMyShow.Entity.ScreenTpye;
import com.org.project.BookMyShow.Entity.Shows;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ScreenDTO 
{
	private int screenId;
	private String screenName;
	private String screenSize;
	private ScreenTpye screenType;
	private int totalSeats;
	
	private List<Shows> show;
	private Movie movie;
	
}
