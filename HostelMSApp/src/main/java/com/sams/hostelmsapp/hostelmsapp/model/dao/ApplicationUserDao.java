package com.sams.hostelmsapp.hostelmsapp.model.dao;

import com.sams.hostelmsapp.hostelmsapp.model.auth.ApplicationUser;

import java.util.Optional;

//I create this interface so that I can sweets any db very easily.
public interface ApplicationUserDao {

     Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
