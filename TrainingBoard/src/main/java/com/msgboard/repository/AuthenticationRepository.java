package com.msgboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msgboard.entity.Authentication;

public interface AuthenticationRepository extends JpaRepository<Authentication, String>{

}
