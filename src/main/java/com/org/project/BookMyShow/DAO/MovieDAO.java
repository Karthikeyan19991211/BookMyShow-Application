package com.org.project.BookMyShow.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.project.BookMyShow.Entity.Movie;
import com.org.project.BookMyShow.Repo.MovieRepo;

@Repository
public class MovieDAO {
	@Autowired
	MovieRepo repo;

	public Movie saveMovie(Movie movie) {
		return repo.save(movie);
	}

	public Movie findMovie(int movieId) {
		Optional<Movie> movie = repo.findById(movieId);

		if (movie.isPresent()) {
			return movie.get();
		}
		return null;
	}

	public Movie deleteMovie(int movieId) {
		Movie movie = findMovie(movieId);

		if (movie != null) {
			repo.delete(movie);
			return movie;
		}
		return null;
	}

	public Movie updateMovie(int movieId, Movie movie) {
		Movie exMovie = findMovie(movieId);

		if (exMovie != null) {
			movie.setMovieId(movieId);

			if (movie.getMovieName() == null) {
				movie.setMovieName(exMovie.getMovieName());
			}
			if (movie.getMovieActor() == null) {
				movie.setMovieActor(exMovie.getMovieActor());
			}
			if (movie.getMovieGenre() == null) {
				movie.setMovieGenre(exMovie.getMovieGenre());
			}
			if (movie.getMovieAmount() == 0.0) {
				movie.setMovieAmount(exMovie.getMovieAmount());
			}

			return repo.save(movie);

		}
		return null;
	}

}
