package com.org.project.BookMyShow.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.project.BookMyShow.DTO.UserDTO;
import com.org.project.BookMyShow.Entity.Admin;
import com.org.project.BookMyShow.Entity.User;
import com.org.project.BookMyShow.Service.UserService;
import com.org.project.BookMyShow.Util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController 
{
	@Autowired
	UserService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<UserDTO>> saveUser(@Valid @RequestBody User user,BindingResult res) {
		return service.saveUser(user);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<UserDTO>> findUser(@RequestParam int userId) {
		return service.findUser(userId);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<UserDTO>> deleteUser(@RequestParam int userId) {
		return service.deleteUser(userId);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<UserDTO>> updateUser(@RequestParam int userId,@RequestBody User user) {
		return service.updateUser(userId, user);
	}

	@GetMapping("findAllUser")
	public ResponseEntity<ResponseStructure<List<UserDTO>>> findAllUser() {
		return service.findAllUser();
	}
	
	@GetMapping("userLogin")
	public ResponseEntity<ResponseStructure<User>> findByEmail(@RequestParam String userEmail,@RequestParam String userPassword)
	{
		return service.findByEmail(userEmail, userPassword);
	}
}
