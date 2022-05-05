package com.wilczewski.carpartsshop.repository;

import com.wilczewski.carpartsshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User getUserByEmail(@Param("email") String email);

    public Long countById(Integer id);

    @Query("UPDATE User u SET u.enabled = ?2 where u.id = ?1")
    @Modifying
    public void updateUserEnabledStatus(Integer id, boolean enabled);
}
