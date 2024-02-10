package com.org.project.BookMyShow.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.project.BookMyShow.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>
{

}
