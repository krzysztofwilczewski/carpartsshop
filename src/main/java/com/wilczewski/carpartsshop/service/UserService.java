package com.wilczewski.carpartsshop.service;

import com.wilczewski.carpartsshop.entity.User;
import com.wilczewski.carpartsshop.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<User> listAllUsers();

    void save(User user);

    boolean isEmailUnique(Integer id, String email);

    User get(Integer id) throws UserNotFoundException;

    void delete(Integer id) throws UserNotFoundException;

    void updateUserEnabledStatus(Integer id, boolean enabled);

}
