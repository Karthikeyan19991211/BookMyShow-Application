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

import com.org.project.BookMyShow.Entity.Admin;
import com.org.project.BookMyShow.Service.AdminService;

@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	AdminService service;

	@PostMapping
	public Admin saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@GetMapping
	public Admin findAdmin(@RequestParam int adminId) {
		return service.findAdmin(adminId);
	}

	@DeleteMapping
	public Admin deleteAdmin(@RequestParam int adminId) {
		return service.findAdmin(adminId);
	}

	@PutMapping
	public Admin updateAdmin(@RequestParam int adminId, @RequestBody Admin admin) {
		return service.updateAdmin(adminId, admin);
	}

	@GetMapping("findAllAdmin")
	public List<Admin> findAllAdmin() {
		return service.findAllAdmin();
	}

}
