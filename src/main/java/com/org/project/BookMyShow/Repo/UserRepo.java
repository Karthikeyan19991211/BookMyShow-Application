package com.org.project.BookMyShow.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.org.project.BookMyShow.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>
{
	@Query("select a from User a where a.userEmail = ?1 and a.userPassword=?2")
	public User findByEmail(String userEmail,String userPassword);
}
