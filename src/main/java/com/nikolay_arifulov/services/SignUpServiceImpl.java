package com.nikolay_arifulov.services;

import com.nikolay_arifulov.forms.SignUpForm;
import com.nikolay_arifulov.models.User;
import com.nikolay_arifulov.repositories.UsersRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;

    private final UsersRepository usersRepository;

    @Override
    public void signUpUser(SignUpForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .username(form.getUsername())
                .dateOfBirth(LocalDate.parse(form.getDateOfBirth()))
                .role(User.Role.USER)
                .build();

        usersRepository.save(user);
    }
}
