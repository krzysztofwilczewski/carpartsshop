package com.wilczewski.carpartsshop.service;

import com.wilczewski.carpartsshop.entity.User;
import com.wilczewski.carpartsshop.exception.UserNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    public User getByEmail(String email);

  //  List<User> listAllUsers();

    Page<User> listByPage(int pageNumber, String sortField, String sortDir, String keyword);

    void save(User user);

    public User updateAccount(User userUpdated);

    boolean isEmailUnique(Integer id, String email);

    User get(Integer id) throws UserNotFoundException;

    void delete(Integer id) throws UserNotFoundException;

    void updateUserEnabledStatus(Integer id, boolean enabled);

}
