package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exception.SportsClubException;
import com.stg.model.Admin;
import com.stg.repository.AdminRepository;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
		
	}

	@Override
	public Admin getAdmin(String email, String password) {
		Admin adminTemp = adminRepository.findByAdminEmail(email);
		if (adminTemp != null && adminTemp.getPassword().equals(password)) {
			return adminTemp;
		} else {
			throw new SportsClubException("Admin doesn't exist with the Given mail Id");
		}

	}

	@Override
	public List<Admin> getAlladmins() {
		return adminRepository.findAll();
	}

}
