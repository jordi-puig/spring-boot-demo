package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
            .withUser("user").password("user").authorities("ROLE_USER")
            .and()
            .withUser("master").password("master").authorities("ROLE_USER", "ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/convert/binary/").access("hasRole('ROLE_USER_BINARY') or hasRole('ROLE_ADMIN')")
            .antMatchers("/convert/hexa/").access("hasRole('ROLE_USER_HEXA') or hasRole('ROLE_ADMIN')")
            .antMatchers("/convert/roman/").access("hasRole('ROLE_USER_ROMAN') or hasRole('ROLE_ADMIN')")
            .and()
            .formLogin().loginPage("/loginPage")
            .defaultSuccessUrl("/homePage")
            .failureUrl("/loginPage?error")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .logout().logoutSuccessUrl("/loginPage?logout");

    }
}
