package com.nikolay_arifulov.repositories;

import com.nikolay_arifulov.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsernameOrEmail(String username, String email);

    Optional<User> findUserByUsername(String username);

    Set<User> findUsersByFirstNameStartingWithIgnoreCaseAndLastNameStartingWithIgnoreCase(String firstName,
                                                                                          String lastName);

    Set<User> findUsersByFirstNameStartingWithIgnoreCaseOrLastNameStartingWithIgnoreCase(String firstName,
                                                                                         String lastName);
}
