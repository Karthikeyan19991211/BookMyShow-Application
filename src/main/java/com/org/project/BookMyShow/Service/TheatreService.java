package com.org.project.BookMyShow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.ScreenDAO;
import com.org.project.BookMyShow.DAO.TheatreDAO;
import com.org.project.BookMyShow.Entity.Screen;
import com.org.project.BookMyShow.Entity.Theatre;
import com.org.project.BookMyShow.Exception.ListNotFoundException;
import com.org.project.BookMyShow.Exception.NotFoundException;
import com.org.project.BookMyShow.Util.ResponseStructure;

@Service
public class TheatreService {
	@Autowired
	TheatreDAO dao;

	@Autowired
	ScreenDAO screenDao;

	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre) {

		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		structure.setMessage("Theatre Details saved Successfully...!!!!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveTheatre(theatre));

		return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Theatre>> findTheatre(int theatreId) {

		Theatre theatre = dao.findTheatre(theatreId);

		if (theatre != null) {
			ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
			structure.setMessage("Theatre Details Finded Successfully...!!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(theatre);

			return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.FOUND);

		}

		throw new NotFoundException("Theatre details doesn't exist....");
	}

	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(int theatreId) {

		Theatre theatre = dao.deleteTheatre(theatreId);
		if (theatre != null) {
			ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
			structure.setMessage("Theatre Details Deleted Successfully...!!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(theatre);

			return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.OK);
		}

		throw new NotFoundException("Theatre details doesn't exist...");

	}

	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(int theatreId, Theatre theatre) {

		Theatre theatre2 = dao.updateTheatre(theatreId, theatre);
		if (theatre2 != null) {
			ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
			structure.setMessage("Theatre Details Updated Successfully...!!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(theatre2);

			return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.OK);
		}

		throw new NotFoundException("Theatre details doesn't exist....");
	}

	public ResponseEntity<ResponseStructure<List<Theatre>>> findAllTheatre() {

		List<Theatre> listTheatre = dao.findAllTheatre();

		if (listTheatre != null) {
			ResponseStructure<List<Theatre>> structure = new ResponseStructure<List<Theatre>>();
			structure.setMessage("All Theatre Details finded Successfully...!!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(listTheatre);

			return new ResponseEntity<ResponseStructure<List<Theatre>>>(structure, HttpStatus.FOUND);
		}

		throw new ListNotFoundException("List of Theatre doesn't exist...!!!!");
	}

	public ResponseEntity<ResponseStructure<Theatre>> addAllScreenToTheatre(int theatreId) {
		Theatre exTheatre = dao.findTheatre(theatreId);
		List<Screen> screen = screenDao.findAllScreens();

		if (exTheatre != null) {
			if (screen != null) {
				exTheatre.setScreen(screen);

				Theatre newTheatre = dao.saveTheatre(exTheatre);

				ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
				structure.setMessage("Added all Screens into the Theatre...!!!");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(newTheatre);

				return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.OK);
			}
			throw new ListNotFoundException("List of Sccreen details doesn't exist...!!!");
		}
		throw new NotFoundException("Theatre details doesn't exist...!!!");
	}

	public ResponseEntity<ResponseStructure<Theatre>> addScreenToTheatre(int theatreId, int screenId) {
		Theatre exTheatre = dao.findTheatre(theatreId);

		Screen screen = screenDao.findScreen(screenId);

		if (exTheatre != null) {
			if (screen != null) {

				List<Screen> listScreen = exTheatre.getScreen();

				listScreen.add(screen);
				exTheatre.setScreen(listScreen);

				Theatre newTheatre = dao.saveTheatre(exTheatre);

				ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
				structure.setMessage("Added all Screens into the Theatre...!!!");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(newTheatre);

				return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.OK);

			}
			throw new NotFoundException("Screen details doesn't exist...!!!!");
		}
		throw new NotFoundException("Theatre details doesn't exist...!!!!");

	}

}
