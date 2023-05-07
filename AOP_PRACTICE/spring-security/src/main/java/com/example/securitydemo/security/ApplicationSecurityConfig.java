package com.example.securitydemo.security;

import com.example.securitydemo.ApplicationPermission;
import com.example.securitydemo.ApplicationRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

import static com.example.securitydemo.ApplicationRoles.STUDENT;
import static com.example.securitydemo.ApplicationRoles.ADMIN;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder encoder;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                //.antMatchers("/students/**").hasRole("STUDENT")
                .antMatchers("/students/**").hasAuthority(ApplicationPermission.STUDENT_READ.name())
                .anyRequest()
                .authenticated()
                .and().httpBasic();

    }

    /**
     * it should be overridden shortcut is ctrl+o and select method name
     * it should be bean
     * The usern name and password must be set and role must be assigned
     * Password ust be encoded
     *
     * @return
     */
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        return new InMemoryUserDetailsManager(Arrays.asList(
                User.builder()
                        .username("Hari")
                        .password(encoder.encode("passwd"))
                        .roles(STUDENT.name())
                        .authorities(STUDENT.getAuthority())
                        .build(),
                User.builder()
                        .username("Umesh")
                        .password(encoder.encode("passwd"))
                        .roles(STUDENT.name())
                        .authorities(STUDENT.getAuthority())
                        .build(),
                User.builder()
                        .username("kartik")
                        .password(encoder.encode("passwd1"))
                        .roles(STUDENT.name(), ADMIN.name())
                        .authorities(ADMIN.getAuthority())
                        .build()));
    }


}
