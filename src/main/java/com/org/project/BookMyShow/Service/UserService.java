package com.org.project.BookMyShow.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.UserDAO;
import com.org.project.BookMyShow.DTO.UserDTO;
import com.org.project.BookMyShow.Entity.Admin;
import com.org.project.BookMyShow.Entity.User;
import com.org.project.BookMyShow.Exception.InvalidPasswordException;
import com.org.project.BookMyShow.Exception.InvalidUsernameException;
import com.org.project.BookMyShow.Exception.ListNotFoundException;
import com.org.project.BookMyShow.Exception.NotFoundException;
import com.org.project.BookMyShow.Util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	UserDAO dao;

	public ResponseEntity<ResponseStructure<UserDTO>> saveUser(User user) {

		User newUser = dao.saveUser(user);
		UserDTO dto = new UserDTO();

		ModelMapper mapper = new ModelMapper();
		mapper.map(newUser, dto);

		ResponseStructure<UserDTO> structure = new ResponseStructure<UserDTO>();
		structure.setMessage("User details Saved successfully...!!!!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<UserDTO>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<UserDTO>> findUser(int userId) {

		User user = dao.findUser(userId);
		if (user != null) {
			UserDTO dto = new UserDTO();

			ModelMapper mapper = new ModelMapper();
			mapper.map(user, dto);

			ResponseStructure<UserDTO> structure = new ResponseStructure<UserDTO>();
			structure.setMessage("User details Finded successfully...!!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDTO>>(structure, HttpStatus.FOUND);
		}
		throw new NotFoundException("User details doesn't exist...!!!!");
	}

	public ResponseEntity<ResponseStructure<UserDTO>> deleteUser(int userId) {

		User user = dao.deleteUser(userId);
		if (user != null) {
			UserDTO dto = new UserDTO();

			ModelMapper mapper = new ModelMapper();
			mapper.map(user, dto);

			ResponseStructure<UserDTO> structure = new ResponseStructure<UserDTO>();
			structure.setMessage("User details Deleted successfully...!!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDTO>>(structure, HttpStatus.OK);
		}
		throw new NotFoundException("User details doesn't exist....");
	}

	public ResponseEntity<ResponseStructure<UserDTO>> updateUser(int userId, User user) {

		User newUser = dao.updateUser(userId, user);

		if (newUser != null) {
			UserDTO dto = new UserDTO();

			ModelMapper mapper = new ModelMapper();
			mapper.map(newUser, dto);

			ResponseStructure<UserDTO> structure = new ResponseStructure<UserDTO>();
			structure.setMessage("User details Updated successfully...!!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDTO>>(structure, HttpStatus.OK);
		}
		throw new NotFoundException("User details doesn't exist...!!!!");
	}

	public ResponseEntity<ResponseStructure<List<UserDTO>>> findAllUser() {

		List<User> user = dao.findAllUser();

		if (user != null) {
			List<UserDTO> listDto = new ArrayList<UserDTO>();
			ModelMapper mapper = new ModelMapper();

			for (User u : user) {
				UserDTO dto = new UserDTO();
				mapper.map(u, dto);
				listDto.add(dto);
			}

			ResponseStructure<List<UserDTO>> structure = new ResponseStructure<List<UserDTO>>();
			structure.setMessage("All User details Finded successfully...!!!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(listDto);
			return new ResponseEntity<ResponseStructure<List<UserDTO>>>(structure, HttpStatus.FOUND);
		}
		throw new ListNotFoundException("List of User details doesn't exist...!!!!");
	}
	
	public ResponseEntity<ResponseStructure<User>> findByEmail(String userEmail,String userPassword)
	{
		User user=dao.findByEmail(userEmail, userPassword);
		
		if(user.getUserEmail().equals(userEmail))
		{
			if(user.getUserPassword().equals(userPassword))
			{
				ResponseStructure<User> structure = new ResponseStructure<User>();
				structure.setMessage("Login Successfully done.....!!!!!!");
				structure.setStatus(HttpStatus.ACCEPTED.value());
				structure.setData(user);
				
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);  
			}
			throw new InvalidPasswordException("Enter the correct Password...!!!!");
		}
		throw new InvalidUsernameException("Enter the correct Email...!!!!");
	}
}