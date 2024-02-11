package com.org.project.BookMyShow.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.project.BookMyShow.Entity.Admin;
import com.org.project.BookMyShow.Repo.AdminRepo;

@Repository
public class AdminDAO {

	@Autowired
	AdminRepo repo;

	public Admin saveAdmin(Admin admin) {
		return repo.save(admin);
	}

	public Admin findAdmin(int adminId) {
		Optional<Admin> admin = repo.findById(adminId);

		if (admin.isPresent()) {
			return admin.get();
		}

		return null;
	}

	public Admin deleteAdmin(int adminId) {
		Admin admin = findAdmin(adminId);

		if (admin != null) {
			repo.delete(admin);
			return admin;

		}

		return null;
	}

	public Admin updateAdmin(int adminId, Admin admin) {
		Admin exAdmin = findAdmin(adminId);

		if (exAdmin != null) {
			admin.setAdminId(adminId);

			if (admin.getAdminName() == null) {
				admin.setAdminName(exAdmin.getAdminName());
			}

			if (admin.getAdminContact() == 0) {
				admin.setAdminContact(exAdmin.getAdminContact());
			}

			if (admin.getAdminEmail() == null) {
				admin.setAdminEmail(exAdmin.getAdminEmail());
			}

			if (admin.getAdminPassword() == null) {
				admin.setAdminPassword(exAdmin.getAdminPassword());
			}

			return repo.save(admin);

		}
		return null;
	}
	
	public List<Admin> findAllAdmin()
	{
		return repo.findAll();
	}

}
