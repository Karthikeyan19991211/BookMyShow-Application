package com.org.project.BookMyShow.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.project.BookMyShow.Entity.Theatre;

public interface TheatreRepo extends JpaRepository<Theatre, Integer>
{

}
