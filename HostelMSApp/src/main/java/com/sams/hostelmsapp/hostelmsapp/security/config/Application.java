package com.sams.hostelmsapp.hostelmsapp.security.config;

import com.sams.hostelmsapp.hostelmsapp.jwt.JwtTokenVerifier;
import com.sams.hostelmsapp.hostelmsapp.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.sams.hostelmsapp.hostelmsapp.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.concurrent.TimeUnit;

import static com.sams.hostelmsapp.hostelmsapp.model.UserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //THIS IS FOR PERMITS BASED AUTHENTICATION
public class Application extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    //Inheriting password encoder interface.
    @Autowired
    public Application(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifier(),JwtUsernameAndPasswordAuthenticationFilter.class)
                //.and()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/api/**").hasRole(BORDER.name())
                .anyRequest()
                .authenticated()
                .and()
        //this is for JWT

/*                  This for form login authentication.
                .formLogin()
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/home",true)
                    .passwordParameter("password")//default parameters
                    .usernameParameter("username")//default parameters I can change it, and I have to do it form from also.
                .and()
                //default time 2 week.
                .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    .key("secured")
                    .rememberMeParameter("remember-me")//default parameters
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID","remember-me")
                    .logoutSuccessUrl("/")//After log out directory.*/
        ;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider (){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }
/*
    @Override
    @Bean
     UserDetailsService userDetailsService() {
        UserDetails rifatUser= User.builder()
                .username("rifat")
                .password(passwordEncoder.encode("123")) //Password Encoding here
//                .roles(BORDER.name()) //ROLE_BORDER for spring security. ROLL BASED AUTHENTICATION
                .authorities(BORDER.getGrantedAuthorities()) //THIS IS PERMITS BASED AUTHENTICATION
                .build();
        UserDetails samsUser= User.builder()
                .username("sams")
                .password(passwordEncoder.encode("123"))
//                .roles(ADMIN.name()) //ROLE_ADMIN for spring security. ROLL BASED AUTHENTICATION
                .authorities(ADMIN.getGrantedAuthorities()) //THIS IS PERMITS BASED AUTHENTICATION
                .build();
        UserDetails nihalUser= User.builder()
                .username("nihal")
                .password(passwordEncoder.encode("123"))
//                .roles(SUPERVISOR.name()) //ROLE_SUPERVISOR for spring security. ROLL BASED AUTHENTICATION
                .authorities(SUPERVISOR.getGrantedAuthorities()) //THIS IS PERMITS BASED AUTHENTICATION
                .build();
        return new InMemoryUserDetailsManager(
                rifatUser,
                samsUser,
                nihalUser
        );
    }*/
}
