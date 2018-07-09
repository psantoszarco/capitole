package com.project.multi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.multi.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Users findByUserName(String username);

}
