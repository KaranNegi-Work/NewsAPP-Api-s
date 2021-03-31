package com.Project.App.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Project.App.Entities.Entities;
public interface UserRepository extends JpaRepository<Entities,Integer>{
	
	Entities findByEmailAndPassword(String email, String password);
	Entities findByEmail(String email);

}
