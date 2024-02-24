package com.org.project.BookMyShow.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.org.project.BookMyShow.Util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("theatre")
public class TheatreController {
	@Autowired
	TheatreService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@Valid @RequestBody Theatre theatre,BindingResult res) {
		return service.saveTheatre(theatre);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Theatre>> findTheatre(@RequestParam int theatreId) {
		return service.findTheatre(theatreId);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(@RequestParam int theatreId) {
		return service.deleteTheatre(theatreId);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(@RequestParam int theatreId, @RequestBody Theatre theatre) {
		return service.updateTheatre(theatreId, theatre);
	}

	@GetMapping("findAllTheatre")
	public ResponseEntity<ResponseStructure<List<Theatre>>> findAllTheatre() {
		return service.findAllTheatre();
	}
	
	@PutMapping("assignAllScreen")
	public ResponseEntity<ResponseStructure<Theatre>> addAllScreenToTheatre(@RequestParam int theatreId)
	{
		return service.addAllScreenToTheatre(theatreId);
	}
	
	@PutMapping("assignScreenToTheatre")
	public ResponseEntity<ResponseStructure<Theatre>> addScreenToTheatre(@RequestParam int theatreId,@RequestParam int screenId)
	{
		return service.addScreenToTheatre(theatreId,screenId);
	}

}
