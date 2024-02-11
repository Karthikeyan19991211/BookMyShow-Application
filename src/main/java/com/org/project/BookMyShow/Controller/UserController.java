package com.org.project.BookMyShow.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.project.BookMyShow.Entity.User;
import com.org.project.BookMyShow.Service.UserService;

@RestController
@RequestMapping("user")
public class UserController 
{
	@Autowired
	UserService service;

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping
	public User findUser(@RequestParam int userId) {
		return service.findUser(userId);
	}

	@DeleteMapping
	public User deleteUser(@RequestParam int userId) {
		return service.deleteUser(userId);
	}

	@PutMapping
	public User updateUser(@RequestParam int userId,@RequestBody User user) {
		return service.updateUser(userId, user);
	}

	@GetMapping("findAllUser")
	public List<User> findAllUser() {
		return service.findAllUser();
	}


}
