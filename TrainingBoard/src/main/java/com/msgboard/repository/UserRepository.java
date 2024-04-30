package com.msgboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msgboard.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
