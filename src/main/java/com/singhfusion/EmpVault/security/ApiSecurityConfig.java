package com.singhfusion.EmpVault.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ApiSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails cheems= User.builder().username("dogesh").password("{noop}Doge123").roles("EMPLOYEE").build();
        UserDetails dogelina= User.builder().username("dogelina").password("{noop}dogelina123").roles("EMPLOYEE","MANAGER").build();
        UserDetails vimdhayak= User.builder().username("vimdhayakjee").password("{noop}vim123").roles("EMPLOYEE","MANAGER","ADMIN").build();
        return new InMemoryUserDetailsManager(cheems,dogelina,vimdhayak);
    }
}
