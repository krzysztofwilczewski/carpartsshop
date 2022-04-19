package com.wilczewski.carpartsshop.user;

import com.wilczewski.carpartsshop.entity.Role;
import com.wilczewski.carpartsshop.entity.User;
import com.wilczewski.carpartsshop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import java.util.List;

@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTests {

    private UserRepository userRepository;
    private TestEntityManager testEntityManager;

    @Autowired
    public UserTests(UserRepository userRepository, TestEntityManager testEntityManager) {
        this.userRepository = userRepository;
        this.testEntityManager = testEntityManager;
    }





    @Test
    public void createUser(){
       // Role admin = testEntityManager.find(Role.class, 1);
        Role admin = new Role(1);
        User wilk = new User("Krzysztof", "Wilczewski", "wilczek@gmail.com","1234");
        wilk.addRole(admin);
        userRepository.save(wilk);
    }

    @Test
    public void createSecondUser(){
        User aga = new User("Aga", "Wilczewska", "osawilk@gmail.com", "agalamaga");
        Role seller = new Role(2);
        aga.addRole(seller);
        userRepository.save(aga);
    }

    @Test
    public void findAllUsers(){
        List<User> list = userRepository.findAll();
        list.forEach(user -> System.out.println(user));

    }

    @Test
    public void updateUser(){
        User user = userRepository.findById(1).get();
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Test
    public void addRole(){
        User user = userRepository.findById(1).get();
        Role seller = new Role(2);
        user.addRole(seller);
        userRepository.save(user);
    }
}

