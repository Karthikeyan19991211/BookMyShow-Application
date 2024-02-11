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

import com.org.project.BookMyShow.Entity.Movie;
import com.org.project.BookMyShow.Service.MovieService;

@RestController
@RequestMapping("movie")
public class MovieController 
{
	@Autowired
	MovieService service;
	
	@PostMapping
	public Movie saveMovie(@RequestBody Movie movie)
	{
		return service.saveMovie(movie);
	}
	
	@GetMapping
	public Movie findMovie(@RequestParam int movieId)
	{
		return service.findMovie(movieId);
	}
	
	@DeleteMapping
	public Movie deleteMovie(@RequestParam int movieId)
	{
		return service.deleteMovie(movieId);
	}
	
	@PutMapping
	public Movie updateMovie(@RequestParam int movieId,@RequestBody Movie movie)
	{
		return service.updateMovie(movieId, movie);
	}
	
	@GetMapping("findAllMovies")
	public List<Movie> findAllMovies()
	{
		return service.findAllMovies();
	}


}
