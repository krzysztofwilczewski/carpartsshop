package com.wilczewski.carpartsshop.user;

import static org.assertj.core.api.Assertions.assertThat;

import com.wilczewski.carpartsshop.entity.Role;
import com.wilczewski.carpartsshop.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleTests {

    private RoleRepository roleRepository;

    @Autowired
    public RoleTests(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Test
    public void createRole(){
        Role admin = new Role("Admin", "all");
        Role seller = new Role("Seller", "products, customers, prices, orders");
        Role user = new Role("Customer", "buyer");
        roleRepository.saveAll(List.of(admin, seller, user));
      //  assertThat(roleRepository.save(admin).getId()).isGreaterThan(0);
    }
}
