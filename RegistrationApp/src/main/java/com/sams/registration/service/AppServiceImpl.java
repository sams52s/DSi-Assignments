package com.sams.registration.service;

import com.sams.registration.model.dto.UserRegistrationDto;
import com.sams.registration.model.repository.AppUserRepository;
import com.sams.registration.model.user.AppUser;
import com.sams.registration.model.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.sams.registration.model.user.UserRole.USER;

@Service
public class AppServiceImpl implements AppService{

    private final AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AppServiceImpl(AppUserRepository appUserRepository) {
        super();
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser save(UserRegistrationDto userRegistrationDto) {
        AppUser user = new AppUser(
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                passwordEncoder.encode(userRegistrationDto.getPassword()),
                UserRole.USER
                );
        return appUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        mapRolesToAuthorities(
                                Collections.singleton(user.getRoles())
                        )
                );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }
}
