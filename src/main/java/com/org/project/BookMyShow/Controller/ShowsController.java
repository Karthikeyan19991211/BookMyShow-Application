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

import com.org.project.BookMyShow.Entity.Shows;
import com.org.project.BookMyShow.Service.ShowsService;

@RestController
@RequestMapping("shows")
public class ShowsController {
	@Autowired
	ShowsService service;

	@PostMapping
	public Shows saveShows(@RequestBody Shows shows) {
		return service.saveShows(shows);
	}

	@GetMapping
	public Shows findShows(@RequestParam int showsId) {
		return service.findShows(showsId);
	}

	@DeleteMapping
	public Shows deleteShows(@RequestParam int showsId) {
		return service.deleteShows(showsId);
	}

	@PutMapping
	public Shows updateShows(@RequestParam int showsId, @RequestBody Shows shows) {
		return service.updateShows(showsId, shows);
	}

	@GetMapping("findAllShows")
	public List<Shows> findAllShows() {
		return service.findAllShows();
	}

}
