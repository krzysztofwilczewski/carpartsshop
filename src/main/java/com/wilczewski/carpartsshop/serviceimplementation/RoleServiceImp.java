package com.wilczewski.carpartsshop.serviceimplementation;

import com.wilczewski.carpartsshop.entity.Role;
import com.wilczewski.carpartsshop.entity.User;
import com.wilczewski.carpartsshop.repository.RoleRepository;
import com.wilczewski.carpartsshop.repository.UserRepository;
import com.wilczewski.carpartsshop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

   private RoleRepository roleRepository;

   @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }



    public List<Role> allRoles(){
        return  roleRepository.findAll();
    }
}
