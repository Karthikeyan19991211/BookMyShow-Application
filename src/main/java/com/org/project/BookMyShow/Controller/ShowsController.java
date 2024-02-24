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

import com.org.project.BookMyShow.DTO.ShowsDTO;
import com.org.project.BookMyShow.Entity.Shows;
import com.org.project.BookMyShow.Service.ShowsService;
import com.org.project.BookMyShow.Util.ResponseStructure;

@RestController
@RequestMapping("shows")
public class ShowsController {
	@Autowired
	ShowsService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Shows>> saveShows(@RequestBody Shows shows) {
		return service.saveShows(shows);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<ShowsDTO>> findShows(@RequestParam int showsId) {
		return service.findShows(showsId);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Shows>> deleteShows(@RequestParam int showsId) {
		return service.deleteShows(showsId);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Shows>> updateShows(@RequestParam int showsId, @RequestBody Shows shows) {
		return service.updateShows(showsId, shows);
	}

	@GetMapping("findAllShows")
	public ResponseEntity<ResponseStructure<List<Shows>>> findAllShows() {
		return service.findAllShows();
	}
	
/*	@PutMapping("assignScreen")
	public ResponseEntity<ResponseStructure<Shows>> assignScreen(@RequestParam int showId,@RequestParam int screenId)
	{
		return service.assignScreen(showId, screenId);
	} */
	
	@PutMapping("assignMovie")
	public ResponseEntity<ResponseStructure<ShowsDTO>> assignMovie(@RequestParam int showId,@RequestParam int movieId)
	{
		return service.assignMovie(showId, movieId);
	}
}
