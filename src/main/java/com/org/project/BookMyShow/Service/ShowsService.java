package com.org.project.BookMyShow.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.MovieDAO;
import com.org.project.BookMyShow.DAO.ScreenDAO;
import com.org.project.BookMyShow.DAO.ShowsDAO;
import com.org.project.BookMyShow.DTO.ScreenDTO;
import com.org.project.BookMyShow.DTO.ShowsDTO;
import com.org.project.BookMyShow.Entity.Movie;
import com.org.project.BookMyShow.Entity.Screen;
import com.org.project.BookMyShow.Entity.Shows;
import com.org.project.BookMyShow.Exception.ListNotFoundException;
import com.org.project.BookMyShow.Exception.NotFoundException;
import com.org.project.BookMyShow.Util.ResponseStructure;

@Service
public class ShowsService {
	@Autowired
	ShowsDAO dao;

	@Autowired
	ScreenDAO sDao;

	@Autowired
	MovieDAO mDao;

	public ResponseEntity<ResponseStructure<Shows>> saveShows(Shows shows) {
		ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
		structure.setMessage("Show Details saved Successfilly...!!!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveShows(shows));
		return new ResponseEntity<ResponseStructure<Shows>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<ShowsDTO>> findShows(int showsId) {

		Shows show = dao.findShow(showsId);

		if (show != null) {
			Movie movie = mDao.findMovie(show.getMovieId());

			Screen screen = sDao.findScreen(show.getScreen().getScreenId());

			ScreenDTO sDto = new ScreenDTO();
			ModelMapper mapper1 = new ModelMapper();
			mapper1.map(screen, sDto);

			ShowsDTO dto = new ShowsDTO();
			dto.setMovie(movie);
			dto.setScreen(sDto);

			ModelMapper mapper = new ModelMapper();
			mapper.map(show, dto);

			ResponseStructure<ShowsDTO> structure = new ResponseStructure<ShowsDTO>();
			structure.setMessage("Show Deletails finded successfully...!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);

			return new ResponseEntity<ResponseStructure<ShowsDTO>>(structure, HttpStatus.FOUND);
		}

		throw new NotFoundException("Show details doesn't exist...!!!");

	}

	public ResponseEntity<ResponseStructure<Shows>> deleteShows(int showsId) {
		Shows show = dao.deleteShow(showsId);
		if (show != null) {
			ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
			structure.setMessage("Shoe Details Deleted Successfully....!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(show);
			return new ResponseEntity<ResponseStructure<Shows>>(structure, HttpStatus.OK);
		}
		throw new NotFoundException("Show details doesn't exist...!!!");
	}

	public ResponseEntity<ResponseStructure<Shows>> updateShows(int showsId, Shows shows) {

		Shows newShow = dao.updateShow(showsId, shows);

		if (newShow != null) {
			ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
			structure.setMessage("Show Details Updated successfully..!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(newShow);

			return new ResponseEntity<ResponseStructure<Shows>>(structure, HttpStatus.OK);
		}

		throw new NotFoundException("Show details doesn't exist...!!!");
	}

	public ResponseEntity<ResponseStructure<List<Shows>>> findAllShows() {
		List<Shows> listShow = dao.findAllShows();

		if (listShow != null) {
			ResponseStructure<List<Shows>> structure = new ResponseStructure<List<Shows>>();
			structure.setMessage("All Show Details finded successfully...!!! ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(listShow);
			return new ResponseEntity<ResponseStructure<List<Shows>>>(structure, HttpStatus.FOUND);
		}
		throw new ListNotFoundException("List of Show details doesn't exist...!!!");
	}

	/*
	 * public ResponseEntity<ResponseStructure<Shows>> assignScreen(int showId, int
	 * screenId) { Shows show = dao.findShow(showId);
	 * 
	 * show.setScreen(sDao.findScreen(screenId));
	 * 
	 * ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
	 * structure.setMessage("Successfully Screen assigned into the Show....!!!");
	 * structure.setStatus(HttpStatus.OK.value());
	 * structure.setData(dao.saveShows(show));
	 * 
	 * return new ResponseEntity<ResponseStructure<Shows>>(structure,
	 * HttpStatus.OK);
	 * 
	 * }
	 */

	public ResponseEntity<ResponseStructure<ShowsDTO>> assignMovie(int showId, int movieId) {
		Shows show = dao.findShow(showId);
		Movie movie = mDao.findMovie(movieId);

		if (show != null) {
			if (movie != null) {
				show.setMovieId(movieId);
				Shows newShow = dao.saveShows(show);

				ScreenDTO sDto = new ScreenDTO();
				ModelMapper mapper1 = new ModelMapper();
				mapper1.map(newShow, sDto);

				ShowsDTO dto = new ShowsDTO();
				dto.setMovie(movie);
				dto.setScreen(sDto);

				ModelMapper mapper = new ModelMapper();
				mapper.map(newShow, dto);

				ResponseStructure<ShowsDTO> structure = new ResponseStructure<ShowsDTO>();
				structure.setMessage("Successfully movie added into the show");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);

				return new ResponseEntity<ResponseStructure<ShowsDTO>>(structure, HttpStatus.OK);
			}
			throw new NotFoundException("Movie details doesn't exist...!!!"); // movie not find
		}

		throw new NotFoundException("Show details doesn't exist...!!!"); // show not find
	}
}
