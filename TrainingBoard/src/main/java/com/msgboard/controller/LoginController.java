package com.msgboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * ログイン処理のコントローラ
 */
@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

}
