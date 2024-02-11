package com.org.project.BookMyShow.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.project.BookMyShow.Entity.Shows;
import com.org.project.BookMyShow.Repo.ShowsRepo;

@Repository
public class ShowsDAO {
	@Autowired
	ShowsRepo repo;

	public Shows saveShows(Shows show) {
		return repo.save(show);
	}

	public Shows findShow(int showId) {
		Optional<Shows> show = repo.findById(showId);

		if (show.isPresent()) {
			return show.get();
		}
		return null;

	}

	public Shows deleteShow(int showId) {
		Shows show = findShow(showId);

		if (show != null) {
			repo.delete(show);
			return show;
		}
		return null;
	}

	public Shows updateShow(int showId, Shows show) {
		Shows exShow = findShow(showId);

		if (exShow != null) {
			show.setShowId(showId);

			if (show.getShowType() == null) {
				show.setShowType(exShow.getShowType());
			}
			if (show.getShowTiming() == null) {
				show.setShowTiming(exShow.getShowTiming());
			}

			return repo.save(show);
		}
		return null;
	}
	
	public List<Shows> findAllShows()
	{
		return repo.findAll();
	}

}
