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

import com.org.project.BookMyShow.Entity.Theatre;
import com.org.project.BookMyShow.Service.TheatreService;

@RestController
@RequestMapping("theatre")
public class TheatreController {
	@Autowired
	TheatreService service;

	@PostMapping
	public Theatre saveTheatre(@RequestBody Theatre theatre) {
		return service.saveTheatre(theatre);
	}

	@GetMapping
	public Theatre findTheatre(@RequestParam int theatreId) {
		return service.findTheatre(theatreId);
	}

	@DeleteMapping
	public Theatre deleteTheatre(@RequestParam int theatreId) {
		return service.deleteTheatre(theatreId);
	}

	@PutMapping
	public Theatre updateTheatre(@RequestParam int theatreId, @RequestBody Theatre theatre) {
		return service.updateTheatre(theatreId, theatre);
	}

	@GetMapping("findAllTheatre")
	public List<Theatre> findAllTheatre() {
		return service.findAllTheatre();
	}

}
