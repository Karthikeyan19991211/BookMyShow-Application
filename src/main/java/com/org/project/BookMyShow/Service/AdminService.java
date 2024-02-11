package com.org.project.BookMyShow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.AdminDAO;
import com.org.project.BookMyShow.Entity.Admin;

@Service
public class AdminService 
{ 
	@Autowired
	AdminDAO dao;
	
	public Admin saveAdmin(Admin admin)
	{
		return dao.saveAdmin(admin);
	}
	
	public Admin findAdmin(int adminId)
	{
		return dao.findAdmin(adminId);
	}
	
	public Admin deleteAdmin(int adminId)
	{
		return dao.findAdmin(adminId);
	}
	
	public Admin updateAdmin(int adminId,Admin admin)
	{
		return dao.updateAdmin(adminId, admin);
	}
	
	public List<Admin> findAllAdmin()
	{
		return dao.findAllAdmin();
	}

}
