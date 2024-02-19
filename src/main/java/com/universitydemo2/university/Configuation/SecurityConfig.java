package com.universitydemo2.university.Configuation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails userDetails = User.builder()
                .username("user")
                .password("{noop}123")
                .roles("USER").build();

        UserDetails adminDetails = User.builder()
                .username("admin")
                .password("{noop}123")
                .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(userDetails, adminDetails);
    }


}
