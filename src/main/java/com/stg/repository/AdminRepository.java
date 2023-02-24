package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Admin findByAdminEmail(String adminEmail);

}

