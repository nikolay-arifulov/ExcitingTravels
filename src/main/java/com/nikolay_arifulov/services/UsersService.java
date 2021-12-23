package com.nikolay_arifulov.services;

import com.nikolay_arifulov.models.User;

import java.util.Set;

public interface UsersService {

    User getUserById(Integer userId);

    User getUserByUsername(String username);

    Integer getAge(User user);

    Set<User> getUsersByNameWithoutUserById(String name, Integer userId);

    void addFriendToUser(Integer userId, Integer friendId);

    void deleteFriendFromUser(Integer userId, Integer friendId);
}
