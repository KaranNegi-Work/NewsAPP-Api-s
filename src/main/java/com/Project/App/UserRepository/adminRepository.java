package com.Project.App.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.App.Entities.Admins;

public interface adminRepository extends JpaRepository<Admins, String> {
	Admins findByEmailAndPassword(String email, String password);
	Admins findByEmail(String email);

}
