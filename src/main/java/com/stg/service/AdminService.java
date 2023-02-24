package com.stg.service;

import java.util.List;

import com.stg.model.Admin;


public interface AdminService {
	public abstract Admin addAdmin(Admin admin);
    public abstract Admin getAdmin(String email,String password);
    public abstract  List<Admin> getAlladmins();
    

}
