package com.org.project.BookMyShow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.MovieDAO;
import com.org.project.BookMyShow.DAO.ShowsDAO;
import com.org.project.BookMyShow.Entity.Movie;
import com.org.project.BookMyShow.Exception.ListNotFoundException;
import com.org.project.BookMyShow.Exception.NotFoundException;
import com.org.project.BookMyShow.Util.ResponseStructure;

@Service
public class MovieService {
	@Autowired
	MovieDAO dao;

	@Autowired
	ShowsDAO sDao;

	public ResponseEntity<ResponseStructure<Movie>> saveMovie(Movie movie) {
		ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
		structure.setMessage("Movie Details Saved Successfully...!!!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMovie(movie));
		return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Movie>> findMovie(int movieId) {
		Movie movie = dao.findMovie(movieId);

		if (movie != null) {

			ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
			structure.setMessage("Movie details finded successfully...!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(movie);
			return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.FOUND);
		}

		throw new NotFoundException("Movie details doesn't exist...!!!!!");
	}

	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(int movieId) {

		Movie movie = dao.deleteMovie(movieId);
		if (movie != null) {
			ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
			structure.setMessage("Movie Details deleted Successfully..!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(movie);
			return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.OK);
		}
		throw new NotFoundException("Movie details doesn't exist...!!!!");
	}

	public ResponseEntity<ResponseStructure<Movie>> updateMovie(int movieId, Movie movie) {
		Movie newMovie = dao.updateMovie(movieId, movie);
		if (newMovie != null) {

			ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
			structure.setMessage("Movie Details Updated Successfully...!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(newMovie);
			return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.OK);
		}
		throw new NotFoundException("Movie details doesn't exist...!!!!");
	}

	public ResponseEntity<ResponseStructure<List<Movie>>> findAllMovies() {

		List<Movie> listMovie = dao.findAllMovies();
		if (listMovie != null) {
			ResponseStructure<List<Movie>> structure = new ResponseStructure<List<Movie>>();
			structure.setMessage("All Movie Details finded successfully..!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(listMovie);
			return new ResponseEntity<ResponseStructure<List<Movie>>>(structure, HttpStatus.FOUND);
		}
		throw new ListNotFoundException("List of Movie details doesn't exist...!!!!");
	}

}
