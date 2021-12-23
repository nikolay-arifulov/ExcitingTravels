package com.nikolay_arifulov.services;

import com.nikolay_arifulov.exceptions.UserNotFoundException;
import com.nikolay_arifulov.models.User;
import com.nikolay_arifulov.repositories.UsersRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public User getUserById(Integer userId) {
        return usersRepository.getById(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return usersRepository.findUserByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Integer getAge(User user) {
        return Period.between(user.getDateOfBirth(), LocalDate.now()).getYears();
    }

    @Override
    public Set<User> getUsersByNameWithoutUserById(String name, Integer userId) {
        User user = usersRepository.getById(userId);
        Set<User> users = new HashSet<>();
        String[] names = name.split(" ");

        if (names.length < 2) {
            users.addAll(usersRepository
                    .findUsersByFirstNameStartingWithIgnoreCaseOrLastNameStartingWithIgnoreCase(name, name));
        } else {
            users.addAll(usersRepository
                    .findUsersByFirstNameStartingWithIgnoreCaseAndLastNameStartingWithIgnoreCase(names[0], names[1]));
            users.addAll(usersRepository
                    .findUsersByFirstNameStartingWithIgnoreCaseAndLastNameStartingWithIgnoreCase(names[1], names[0]));
        }

        users.remove(user);
        return users;
    }

    @Override
    public void addFriendToUser(Integer userId, Integer friendId) {
        User user = usersRepository.getById(userId);
        User friend = usersRepository.findById(friendId).orElseThrow(UserNotFoundException::new);
        user.getFriends().add(friend);
        usersRepository.save(user);
    }

    @Override
    public void deleteFriendFromUser(Integer userId, Integer friendId) {
        User user = usersRepository.getById(userId);
        User friend = usersRepository.findById(friendId).orElseThrow(UserNotFoundException::new);
        user.getFriends().remove(friend);
        usersRepository.save(user);
    }
}

