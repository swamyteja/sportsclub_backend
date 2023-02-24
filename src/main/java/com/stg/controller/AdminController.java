package com.stg.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.Admin;
import com.stg.model.Constants;

import com.stg.service.AdminServiceImp;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping(value = "admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    @Autowired
	private AdminServiceImp adminServiceImp;

	@PostMapping(value = "addAdmin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminServiceImp.addAdmin(admin);
	}

	@GetMapping(value = "getAdmin/{email}/{password}")
	public Admin getAdmin(@PathVariable String email, @PathVariable String password) {
		return adminServiceImp.getAdmin(email, password);
	}
	
	
	@GetMapping(value = "getAdminList")
	public List<Admin> readAllAdmins(){
		return adminServiceImp.getAlladmins();
	}
	
	@PostMapping(value = "/authenticate")
	public Map<String,String> generateToken(@RequestBody Admin admin){
		long timestamp = System.currentTimeMillis();
		
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
			.setIssuedAt(new Date(timestamp))
			.setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
			.claim("adminId",admin.getAdminId())
			.claim("adminName",admin.getAdminName())
			.claim("adminEmail" ,admin.getAdminEmail())
			.compact();
		
		Map<String,String> map = new HashMap<>();
		map.put("JWT", token);
		return map;
			
		
	}
	
	
	

}
