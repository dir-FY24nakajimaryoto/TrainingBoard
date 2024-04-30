package com.msgboard.controller;

import org.springframework.web.bind.annotation.PostMapping;

/**
 * ログアウトコントローラ
 */
public class LogoutController {

	@PostMapping("/logout")
	public String postLogout() {
		return "redirect:/login";
	}
	
}
