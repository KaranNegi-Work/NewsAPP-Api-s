package com.Project.App.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.App.Entities.AllNews;

public interface UserPostsRepository  extends JpaRepository<AllNews,Integer>{
	
	AllNews findByid(int id);
 
}