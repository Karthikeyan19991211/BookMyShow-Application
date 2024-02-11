package com.org.project.BookMyShow.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.project.BookMyShow.Entity.Screen;
import com.org.project.BookMyShow.Service.ScreenService;

@RestController
@RequestMapping("screen")
public class ScreenController 
{
	@Autowired
	ScreenService service;
	
	@PostMapping
	public Screen saveScreen(@RequestBody Screen screen)
	{
		return service.saveScreen(screen);
	}
	
	@GetMapping
	public Screen findScreen(@RequestParam int screenId)
	{
		return service.findScreen(screenId);
	}
	
	@DeleteMapping
	public Screen deleteScreen(@RequestParam int screenId)
	{
		return service.deleteScreen(screenId);
	}
	
	@PutMapping
	public Screen updateScreen(@RequestParam int screenId,@RequestBody Screen screen)
	{
		return service.updateScreen(screenId, screen);
	}
	
	@GetMapping("findAllScreens")
	public List<Screen> findAllScreens()
	{
		return service.findAllScreens();
	}


}
