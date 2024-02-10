package com.org.project.BookMyShow.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.project.BookMyShow.Entity.Shows;

public interface ShowsRepo extends JpaRepository<Shows, Integer>
{

}
