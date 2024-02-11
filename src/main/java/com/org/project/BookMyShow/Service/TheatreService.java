package com.org.project.BookMyShow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.TheatreDAO;
import com.org.project.BookMyShow.Entity.Theatre;

@Service
public class TheatreService {
	@Autowired
	TheatreDAO dao;

	public Theatre saveTheatre(Theatre theatre) {
		return dao.saveTheatre(theatre);
	}

	public Theatre findTheatre(int theatreId) {
		return dao.findTheatre(theatreId);
	}

	public Theatre deleteTheatre(int theatreId) {
		return dao.deleteTheatre(theatreId);
	}

	public Theatre updateTheatre(int theatreId, Theatre theatre) {
		return dao.updateTheatre(theatreId, theatre);
	}

	public List<Theatre> findAllTheatre() {
		return dao.findAllTheatre();
	}

}
