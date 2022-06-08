package com.doma.danina.repository;

import com.doma.danina.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {

    @Query("SELECT u FROM User u WHERE u.id =:id")
    User getUserById(@Param("id") long id);

    @Query("SELECT u FROM User u WHERE u.name =:name")
    User getUserByName(@Param("name") String name);

    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int deleteUserById(@Param("id") long id);

    @Modifying
    @Query("UPDATE User u SET u.pwd=:newPwd Where u.id=:id")
    int modify(@Param("id") long id, @Param("newPwd") String newPwd);

    @Query("SELECT u from User u order by u.name desc")
    List<User> getUsers();
}
