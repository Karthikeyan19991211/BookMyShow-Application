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

import com.org.project.BookMyShow.Entity.Movie;
import com.org.project.BookMyShow.Service.MovieService;
import com.org.project.BookMyShow.Util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("movie")
public class MovieController 
{
	@Autowired
	MovieService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(@Valid @RequestBody Movie movie,BindingResult res)
	{
		return service.saveMovie(movie);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Movie>> findMovie(@Valid @RequestParam int movieId,BindingResult res)
	{
		return service.findMovie(movieId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(@RequestParam int movieId)
	{
		return service.deleteMovie(movieId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Movie>> updateMovie(@RequestParam int movieId,@RequestBody Movie movie)
	{
		return service.updateMovie(movieId, movie);
	}
	
	@GetMapping("findAllMovies")
	public ResponseEntity<ResponseStructure<List<Movie>>> findAllMovies()
	{
		return service.findAllMovies();
	}
}
