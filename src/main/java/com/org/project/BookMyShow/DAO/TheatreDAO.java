package com.org.project.BookMyShow.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.project.BookMyShow.Entity.Theatre;
import com.org.project.BookMyShow.Repo.TheatreRepo;

@Repository
public class TheatreDAO {
	@Autowired
	TheatreRepo repo;

	public Theatre saveTheatre(Theatre theatre) {
		return repo.save(theatre);
	}

	public Theatre findTheatre(int theatreId) {
		Optional<Theatre> theatre = repo.findById(theatreId);
		if (theatre.isPresent()) {
			return theatre.get();
		}
		return null;
	}

	public Theatre deleteTheatre(int theatreId) {
		Theatre theatre = findTheatre(theatreId);
		if (theatre != null) {
			repo.delete(theatre);
			return theatre;
		}
		return null;
	}

	public Theatre updateTheatre(int theatreId, Theatre theatre) {
		Theatre extheatre = findTheatre(theatreId);

		if (extheatre != null) {
			theatre.setTheatreId(theatreId);

			if (theatre.getTheatreName() == null) {
				theatre.setTheatreName(extheatre.getTheatreName());
			}
			if (theatre.getTheatreContact() == 0) {
				theatre.setTheatreContact(extheatre.getTheatreContact());
			}
			if (theatre.getTheatreLocation() == null) {
				theatre.setTheatreLocation(extheatre.getTheatreLocation());
			}
			if (theatre.getNoOfScreen() == 0) {
				theatre.setNoOfScreen(extheatre.getNoOfScreen());
			}

			return repo.save(theatre);

		}
		return null;
	}
	
	public List<Theatre> findAllTheatre()
	{
		return repo.findAll();
	}

}
