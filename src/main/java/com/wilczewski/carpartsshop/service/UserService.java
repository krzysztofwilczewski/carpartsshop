package com.wilczewski.carpartsshop.service;

import com.wilczewski.carpartsshop.entity.User;

import java.util.List;

public interface UserService {
    List<User> listAllUsers();

    void save(User user);

}
