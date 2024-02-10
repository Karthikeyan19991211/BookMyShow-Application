package com.org.project.BookMyShow.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.project.BookMyShow.Entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>
{

}
