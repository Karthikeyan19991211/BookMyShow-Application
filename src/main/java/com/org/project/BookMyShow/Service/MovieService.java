package com.org.project.BookMyShow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.MovieDAO;
import com.org.project.BookMyShow.Entity.Movie;

@Service
public class MovieService 
{
	@Autowired
	MovieDAO dao;
	
	public Movie saveMovie(Movie movie)
	{
		return dao.saveMovie(movie);
	}
	
	public Movie findMovie(int movieId)
	{
		return dao.findMovie(movieId);
	}
	
	public Movie deleteMovie(int movieId)
	{
		return dao.deleteMovie(movieId);
	}
	
	public Movie updateMovie(int movieId,Movie movie)
	{
		return dao.updateMovie(movieId, movie);
	}
	
	public List<Movie> findAllMovies()
	{
		return dao.findAllMovies();
	}

}
