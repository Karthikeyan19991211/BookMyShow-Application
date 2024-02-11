package com.org.project.BookMyShow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.project.BookMyShow.DAO.UserDAO;
import com.org.project.BookMyShow.Entity.User;

@Service
public class UserService {
	@Autowired
	UserDAO dao;

	public User saveUser(User user) {
		return dao.saveUser(user);
	}

	public User findUser(int userId) {
		return dao.findUser(userId);
	}

	public User deleteUser(int userId) {
		return dao.deleteUser(userId);
	}

	public User updateUser(int userId, User user) {
		return dao.updateUser(userId, user);
	}

	public List<User> findAllUser() {
		return dao.findAllUser();
	}

}
