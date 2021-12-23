package com.nikolay_arifulov.security.details;

import com.nikolay_arifulov.models.User;
import com.nikolay_arifulov.repositories.UsersRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findUserByUsernameOrEmail(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserDetailsImpl(user);
    }
}
