package com.org.project.BookMyShow.DTO;

import com.org.project.BookMyShow.Entity.Movie;
import com.org.project.BookMyShow.Entity.ShowType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShowsDTO 
{
	private int showId;
	private ShowType showType;
	private String showTiming;
	private ScreenDTO screen;
	
	private Movie movie;

}
