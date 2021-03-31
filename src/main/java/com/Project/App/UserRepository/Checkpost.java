package com.Project.App.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.App.Entities.Postcheck;

public interface Checkpost extends JpaRepository<Postcheck,Integer> {
	
}
