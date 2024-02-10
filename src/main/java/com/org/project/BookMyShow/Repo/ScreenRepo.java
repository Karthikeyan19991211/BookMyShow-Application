package com.org.project.BookMyShow.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.project.BookMyShow.Entity.Screen;

public interface ScreenRepo extends JpaRepository<Screen, Integer> 
{

}
