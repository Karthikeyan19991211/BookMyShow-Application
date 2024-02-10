package com.org.project.BookMyShow.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.project.BookMyShow.Entity.User;
import com.org.project.BookMyShow.Repo.UserRepo;

@Repository
public class UserDAO {
	@Autowired
	UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User findUser(int userId) {
		Optional<User> user = repo.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	public User deleteUser(int userId) {
		User user = findUser(userId);
		if (user != null) {
			repo.delete(user);
			return user;
		}
		return null;
	}

	public User updateUser(int userId, User user) {
		User exUser = findUser(userId);

		if (exUser != null) {
			user.setUserId(userId);
			if (user.getUserName() == null) {
				user.setUserName(exUser.getUserName());
			}
			if (user.getUserContact() == 0) {
				user.setUserContact(exUser.getUserContact());
			}
			if (user.getUserEmail() == null) {
				user.setUserEmail(exUser.getUserEmail());
			}
			if (user.getUserPassword() == null) {
				user.setUserPassword(exUser.getUserPassword());
			}

			return repo.save(user);
		}
		return null;
	}

}
