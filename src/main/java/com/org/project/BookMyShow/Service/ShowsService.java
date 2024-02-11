package com.org.project.BookMyShow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.ShowsDAO;
import com.org.project.BookMyShow.Entity.Shows;

@Service
public class ShowsService {
	@Autowired
	ShowsDAO dao;

	public Shows saveShows(Shows shows) {
		return dao.saveShows(shows);
	}

	public Shows findShows(int showsId) {
		return dao.findShow(showsId);
	}

	public Shows deleteShows(int showsId) {
		return dao.deleteShow(showsId);
	}

	public Shows updateShows(int showsId, Shows shows) {
		return dao.updateShow(showsId, shows);
	}

	public List<Shows> findAllShows() {
		return dao.findAllShows();
	}

}
