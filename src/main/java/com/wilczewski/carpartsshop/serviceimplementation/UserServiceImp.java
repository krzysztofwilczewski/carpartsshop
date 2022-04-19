package com.wilczewski.carpartsshop.serviceimplementation;

import com.wilczewski.carpartsshop.entity.Role;
import com.wilczewski.carpartsshop.entity.User;
import com.wilczewski.carpartsshop.repository.RoleRepository;
import com.wilczewski.carpartsshop.repository.UserRepository;
import com.wilczewski.carpartsshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;


    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
