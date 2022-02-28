package com.sams.registration.service;

import com.sams.registration.model.dto.UserRegistrationDto;
import com.sams.registration.model.user.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppService extends UserDetailsService {
    AppUser save(UserRegistrationDto userRegistrationDto);
}
