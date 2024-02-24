package com.org.project.BookMyShow.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.project.BookMyShow.Entity.Screen;
import com.org.project.BookMyShow.Repo.ScreenRepo;

@Repository
public class ScreenDAO {
	@Autowired
	ScreenRepo repo;

	public Screen saveScreen(Screen screen) {
		return repo.save(screen);
	}

	public Screen findScreen(int screenId) {
		Optional<Screen> screen = repo.findById(screenId);

		if (screen.isPresent()) {
			return screen.get();
		}
		return null;
	}

	public Screen deleteScreen(int screenId) {
		Screen screen = findScreen(screenId);

		if (screen != null) {
			repo.delete(screen);
			return screen;
		}
		return screen;
	}

	public Screen updateScreen(int screenId, Screen screen) {
		Screen exScreen = findScreen(screenId);

		if (exScreen != null) {
			screen.setScreenId(screenId);

			if (screen.getScreenName() == null) {
				screen.setScreenName(exScreen.getScreenName());
			}
			if (screen.getScreenSize() == null) {
				screen.setScreenSize(exScreen.getScreenSize());
			}
			if (screen.getScreenType() == null) {
				screen.setScreenType(exScreen.getScreenType());
			}
			if (screen.getTotalSeats() == 0) {
				screen.setTotalSeats(exScreen.getTotalSeats());
			}

			return repo.save(screen);
		}
		return null;
	}
	
	public List<Screen> findAllScreens()
	{
		return repo.findAll();
	}

}
