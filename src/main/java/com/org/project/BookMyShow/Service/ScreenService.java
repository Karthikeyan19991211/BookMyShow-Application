package com.org.project.BookMyShow.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.MovieDAO;
import com.org.project.BookMyShow.DAO.ScreenDAO;
import com.org.project.BookMyShow.DAO.ShowsDAO;
import com.org.project.BookMyShow.DTO.ScreenDTO;
import com.org.project.BookMyShow.Entity.Screen;
import com.org.project.BookMyShow.Entity.Shows;
import com.org.project.BookMyShow.Exception.ListNotFoundException;
import com.org.project.BookMyShow.Exception.NotFoundException;
import com.org.project.BookMyShow.Util.ResponseStructure;

@Service
public class ScreenService 
{
	@Autowired
	ScreenDAO dao;
	
	@Autowired
	ShowsDAO sDao;
	
	@Autowired
	MovieDAO mDao;
	
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(Screen screen)
	{
		ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
		structure.setMessage("Screen Details Saved Successfully...!!!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveScreen(screen));
		return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Screen>> findScreen(int screenId)
	{
		Screen screen = dao.findScreen(screenId);
		
		if(screen != null)
		{
			ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
			structure.setMessage("Screen Details finded Successfully...!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(screen);
			return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.FOUND);
		}
		throw new NotFoundException("Screen details doesn't exist...!!!");
		
	}
	
	public ResponseEntity<ResponseStructure<Screen>> deleteScreen(int screenId)
	{
		
		Screen screen = dao.deleteScreen(screenId);
		
		if(screen != null)
		{
			ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
			structure.setMessage("Screen Details Deleted Successfully...!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(screen);
		
			return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
		}
		
		throw new NotFoundException("Screen details doesn't exist...!!!");
	}
	
	public ResponseEntity<ResponseStructure<Screen>> updateScreen(int screenId,Screen screen1)
	{
		Screen screen=dao.updateScreen(screenId, screen1);
		
		if(screen != null)
		{
			ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
			structure.setMessage("Screen Details Updated Successfully...!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(screen);
			
			return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
		}
		
		throw new NotFoundException("Screen details doesn't exist...!!!");
	}
	
	public ResponseEntity<ResponseStructure<List<Screen>>> findAllScreens()
	{
		List<Screen> screen = dao.findAllScreens();
		
		if(screen != null)
		{
			ResponseStructure<List<Screen>> structure = new ResponseStructure<List<Screen>>();
			structure.setMessage("All Screen Details Finded Successfully...!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(screen);
			
			return new ResponseEntity<ResponseStructure<List<Screen>>>(structure,HttpStatus.FOUND);
		}
		
		throw new ListNotFoundException("List of Screen details doesn't exist...!!!");	
	}
	
	public ResponseEntity<ResponseStructure<Screen>> assignAllShows(int screenId)
	{
		Screen screen = dao.findScreen(screenId);
		
		List<Shows> listShow=sDao.findAllShows();
		
		if(screen != null)
		{
			if(listShow!= null)
			{
				screen.setShows(listShow);			
				Screen newScreen = dao.saveScreen(screen);
				
				ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
				structure.setMessage("All Shows assign into the Screen");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(newScreen);
				
				return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
			}
			throw new ListNotFoundException("List of Show details doesn't exist...!!!");
		}
		throw new NotFoundException("Screen details doesn't exist...");
	}
	
	public ResponseEntity<ResponseStructure<ScreenDTO>> assignShow(int screenId,int showId)
	{
		Screen screen = dao.findScreen(screenId);
		Shows show = sDao.findShow(showId);
		
		if(screen != null)
		{
			if(show != null)
			{
				List<Shows> listShows =screen.getShows();
				listShows.add(show);
				
				screen.setShows(listShows);
				
				Screen newScreen = dao.saveScreen(screen);
				
				show.setScreen(newScreen);				
				sDao.saveShows(show);
				
				ScreenDTO dto = new ScreenDTO();
				dto.setShow(newScreen.getShows());
				dto.setMovie(mDao.findMovie(show.getMovieId()));
				
				ModelMapper mapper=new ModelMapper();
				mapper.map(newScreen, dto);
				
				ResponseStructure<ScreenDTO> structure = new ResponseStructure<ScreenDTO>();
				structure.setMessage("Successfully show added into the Screen...!!!");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);
				
				return new ResponseEntity<ResponseStructure<ScreenDTO>>(structure,HttpStatus.OK);				
			}
			throw new NotFoundException("Show details doesn't exist...");
		}
		throw new NotFoundException("Screen details doesn't exist...");
	}

}
