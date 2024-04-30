package com.msgboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msgboard.entity.User;
import com.msgboard.service.UserService;



/**
 * ユーザ登録、掲示板移行処理を行うコントローラクラス
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;
	
	
	/** ユーザ登録画面の表示 */
	@GetMapping("/register")
	public String getRegister(@ModelAttribute User user) {
		return "user/register";
	}
	
	/** ユーザ登録処理 */
	@PostMapping("/register")
	public String postRegister(User user) {
		service.saveUser(user);
		
		return "redirect:/user/list";
	}
	
}
