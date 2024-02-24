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

import com.org.project.BookMyShow.DTO.AdminDTO;
import com.org.project.BookMyShow.Entity.Admin;
import com.org.project.BookMyShow.Service.AdminService;
import com.org.project.BookMyShow.Util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	AdminService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDTO>> saveAdmin(@Valid @RequestBody Admin admin,BindingResult res) {
		return service.saveAdmin(admin);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<AdminDTO>> findAdmin(@RequestParam int adminId) {
		return service.findAdmin(adminId);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<AdminDTO>> deleteAdmin(@RequestParam int adminId) {
		return service.deleteAdmin(adminId);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<AdminDTO>> updateAdmin(@RequestParam int adminId, @RequestBody Admin admin) {
		return service.updateAdmin(adminId, admin);
	}

	@GetMapping("findAllAdmin")
	public ResponseEntity<ResponseStructure<List<AdminDTO>>> findAllAdmin() {
		return service.findAllAdmin();
	}
	
	@PutMapping("assign")
	public ResponseEntity<ResponseStructure<AdminDTO>> theatreAssignAdmin(@RequestParam int adminId,@RequestParam int theatreId)
	{
		return service.theatreAssignAdmin(adminId, theatreId);
	}
	
	@GetMapping("adminLogin")
	public ResponseEntity<ResponseStructure<Admin>> findByEmail(@RequestParam String adminEmail,@RequestParam String adminPassword)
	{
		return service.findByEmail(adminEmail, adminPassword);
	}

}
