package com.agritech.agritechgrow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agritech.agritechgrow.entities.User;

public interface UserRepository extends JpaRepository<User,String>{
    @Query("select U from User U where U.email =: email")
    public User getUserByUsername(@Param("email") String email);
}
