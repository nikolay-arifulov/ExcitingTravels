package com.nikolay_arifulov.security.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .permitAll();
    }
}
