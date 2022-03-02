package com.sams.hostelmsapp.hostelmsapp.service;

import com.sams.hostelmsapp.hostelmsapp.model.dao.ApplicationUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserDao;

    @Autowired //wiring up with FakeApplicationUserDaoService
    public ApplicationUserService(@Qualifier("fake") /*custom implementation*/ ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDao.selectApplicationUserByUsername(username).orElseThrow(()-> new UsernameNotFoundException(String.format("Sorry!  %s is not found. ", username)));
    }
}
