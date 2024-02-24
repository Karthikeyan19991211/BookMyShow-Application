package com.org.project.BookMyShow.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.project.BookMyShow.DTO.ScreenDTO;
import com.org.project.BookMyShow.Entity.Screen;
import com.org.project.BookMyShow.Service.ScreenService;
import com.org.project.BookMyShow.Util.ResponseStructure;

@RestController
@RequestMapping("screen")
public class ScreenController 
{
	@Autowired
	ScreenService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(@RequestBody Screen screen)
	{
		return service.saveScreen(screen);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Screen>> findScreen(@RequestParam int screenId)
	{
		return service.findScreen(screenId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Screen>> deleteScreen(@RequestParam int screenId)
	{
		return service.deleteScreen(screenId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Screen>> updateScreen(@RequestParam int screenId,@RequestBody Screen screen)
	{
		return service.updateScreen(screenId, screen);
	}
	
	@GetMapping("findAllScreens")
	public ResponseEntity<ResponseStructure<List<Screen>>> findAllScreens()
	{
		return service.findAllScreens();
	}
	
	@PutMapping("assignAllShow")
	public ResponseEntity<ResponseStructure<Screen>> assignAllShows(@RequestParam int screenId)
	{
		return service.assignAllShows(screenId);
	}
	
	@PutMapping("assignShow")
	public ResponseEntity<ResponseStructure<ScreenDTO>> assignShow(@RequestParam int screenId,@RequestParam int showId)
	{
		return service.assignShow(screenId, showId);
	}
}
