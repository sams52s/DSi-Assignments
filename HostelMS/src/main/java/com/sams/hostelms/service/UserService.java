package com.sams.hostelms.service;

import com.sams.hostelms.dto.UserRegistrationDto;
import com.sams.hostelms.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

}
