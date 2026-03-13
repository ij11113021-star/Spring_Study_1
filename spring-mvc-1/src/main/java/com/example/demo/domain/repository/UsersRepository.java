package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	boolean existsByEmail(String email);
	
}
