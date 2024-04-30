package com.msgboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msgboard.entity.User;
import com.msgboard.repository.UserRepository;

import jakarta.transaction.Transactional;



@Service
public class UserService {

	@Autowired
	private UserRepository u_repos;
	
	/** ユーザの登録 */
	@Transactional
	public User saveUser(User user) {
		return u_repos.save(user);
	}
	
}
