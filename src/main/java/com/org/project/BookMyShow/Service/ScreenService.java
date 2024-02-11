package com.org.project.BookMyShow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.ScreenDAO;
import com.org.project.BookMyShow.Entity.Screen;

@Service
public class ScreenService 
{
	@Autowired
	ScreenDAO dao;
	
	public Screen saveScreen(Screen screen)
	{
		return dao.saveScreen(screen);
	}
	
	public Screen findScreen(int screenId)
	{
		return dao.findScreen(screenId);
	}
	
	public Screen deleteScreen(int screenId)
	{
		return dao.deleteScreen(screenId);
	}
	
	public Screen updateScreen(int screenId,Screen screen)
	{
		return dao.updateScreen(screenId, screen);
	}
	
	public List<Screen> findAllScreens()
	{
		return dao.findAllScreens();
	}

}
