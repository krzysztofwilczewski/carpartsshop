package com.wilczewski.carpartsshop.configuration;

import com.wilczewski.carpartsshop.entity.User;
import com.wilczewski.carpartsshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ShopUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        if (user != null){
            return new ShopUserDetails(user);
        }
        throw new UsernameNotFoundException("Nie znaleziono użytkownika o emailu: " + email);
    }
}
