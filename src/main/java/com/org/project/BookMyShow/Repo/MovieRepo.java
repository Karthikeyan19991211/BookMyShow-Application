package com.org.project.BookMyShow.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.project.BookMyShow.Entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer>
{

}
