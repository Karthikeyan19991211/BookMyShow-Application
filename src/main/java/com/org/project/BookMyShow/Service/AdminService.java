package com.org.project.BookMyShow.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.AdminDAO;
import com.org.project.BookMyShow.DAO.TheatreDAO;
import com.org.project.BookMyShow.DTO.AdminDTO;
import com.org.project.BookMyShow.Entity.Admin;
import com.org.project.BookMyShow.Entity.Theatre;
import com.org.project.BookMyShow.Exception.InvalidPasswordException;
import com.org.project.BookMyShow.Exception.InvalidUsernameException;
import com.org.project.BookMyShow.Exception.ListNotFoundException;
import com.org.project.BookMyShow.Exception.NotFoundException;

import com.org.project.BookMyShow.Util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	AdminDAO dao;

	@Autowired
	TheatreDAO theatreDao;

	public ResponseEntity<ResponseStructure<AdminDTO>> saveAdmin(Admin admin) {
		Admin newAdmin = dao.saveAdmin(admin);
		AdminDTO dto = new AdminDTO();

		ModelMapper mapper = new ModelMapper();
		mapper.map(newAdmin, dto);

		ResponseStructure<AdminDTO> structure = new ResponseStructure<AdminDTO>();
		structure.setMessage("Admin Object is Saved Successfully...!!!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);

		return new ResponseEntity<ResponseStructure<AdminDTO>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<AdminDTO>> findAdmin(int adminId) {
		Admin admin = dao.findAdmin(adminId);

		if (admin != null) {
			AdminDTO dto = new AdminDTO();

			ModelMapper mapper = new ModelMapper();
			mapper.map(admin, dto);

			ResponseStructure<AdminDTO> structure = new ResponseStructure<AdminDTO>();
			structure.setMessage("Admin is finded Successfully...!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);

			return new ResponseEntity<ResponseStructure<AdminDTO>>(structure, HttpStatus.FOUND);
		}
		throw new NotFoundException("Admin details doesn't exist...!!!!");
	}

	public ResponseEntity<ResponseStructure<AdminDTO>> deleteAdmin(int adminId) {
		Admin admin = dao.deleteAdmin(adminId);

		if (admin != null) {
			AdminDTO dto = new AdminDTO();

			ModelMapper mapper = new ModelMapper();
			mapper.map(admin, dto);

			ResponseStructure<AdminDTO> structure = new ResponseStructure<AdminDTO>();
			structure.setMessage("Admin is deleted Successfully...!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);

			return new ResponseEntity<ResponseStructure<AdminDTO>>(structure, HttpStatus.OK);
		}

		throw new NotFoundException("Admin Details doesn't exist...!!!");
	}

	public ResponseEntity<ResponseStructure<AdminDTO>> updateAdmin(int adminId, Admin admin) {
		Admin newAdmin = dao.updateAdmin(adminId, admin);

		if (newAdmin != null) {
			AdminDTO dto = new AdminDTO();

			ModelMapper mapper = new ModelMapper();
			mapper.map(newAdmin, dto);

			ResponseStructure<AdminDTO> structure = new ResponseStructure<AdminDTO>();
			structure.setMessage("Admin details Updated Successfully...!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);

			return new ResponseEntity<ResponseStructure<AdminDTO>>(structure, HttpStatus.OK);
		}
		throw new NotFoundException("Admin Details doesn't exist...!!!");
	}

	public ResponseEntity<ResponseStructure<List<AdminDTO>>> findAllAdmin() {
		List<Admin> admin = dao.findAllAdmin();

		if (admin != null) {
			List<AdminDTO> listDto = new ArrayList<AdminDTO>();
			ModelMapper mapper = new ModelMapper();

			for (Admin a : admin) {
				AdminDTO dto = new AdminDTO();
				listDto.add(dto);
				mapper.map(a, dto);

			}

			ResponseStructure<List<AdminDTO>> structure = new ResponseStructure<List<AdminDTO>>();
			structure.setMessage("All the Admin Details finded successfully...!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(listDto);

			return new ResponseEntity<ResponseStructure<List<AdminDTO>>>(structure, HttpStatus.FOUND);

		}
		throw new ListNotFoundException("List of Admin Details doesn't exist...!!!");
	}

	public ResponseEntity<ResponseStructure<AdminDTO>> theatreAssignAdmin(int adminId, int theatreId) {
		Admin exAdmin = dao.findAdmin(adminId);

		if (exAdmin != null) {
			Theatre theatre = theatreDao.findTheatre(theatreId);

			if (theatre != null) {
				List<Theatre> exTheatre = exAdmin.getTheatre();

				exTheatre.add(theatre);
				exAdmin.setTheatre(exTheatre);

				Admin newAdmin = dao.saveAdmin(exAdmin);
				AdminDTO dto = new AdminDTO();

				ModelMapper mapper = new ModelMapper();
				mapper.map(newAdmin, dto);

				ResponseStructure<AdminDTO> structure = new ResponseStructure<AdminDTO>();
				structure.setMessage("Successfully added Theatre into the Admin..!!!");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);

				return new ResponseEntity<ResponseStructure<AdminDTO>>(structure, HttpStatus.OK);
			}
			throw new NotFoundException("Theatre Details doesn't exist...!!!");
		}
		throw new NotFoundException("Admin Details doesn't exist...!!!");
	}

	public ResponseEntity<ResponseStructure<Admin>> findByEmail(String adminEmail, String adminPassword) {
		Admin admin = dao.findByEmail(adminEmail);
		if (admin != null) {

			if (admin.getAdminEmail().equals(adminEmail)) {
				if (admin.getAdminPassword().equals(adminPassword)) {
					ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
					structure.setMessage("Login Successfully done.....!!!!!!");
					structure.setStatus(HttpStatus.ACCEPTED.value());
					structure.setData(admin);

					return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);
				}
				throw new InvalidPasswordException("Enter the correct Password...!!!!");
			}
			throw new InvalidUsernameException("Enter the correct Email...!!!!");
		}
		throw new InvalidUsernameException("Enter the correct Email...!!!!");
	}
}
