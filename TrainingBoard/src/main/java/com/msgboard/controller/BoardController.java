package com.msgboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msgboard.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	
	/** 一覧画面を表示 */
	@GetMapping("/list")
	public String getList(Model model) {
		
		// 全件検索結果をModelに登録
		model.addAttribute("boardlist", service.getBoardList());
		
		return "board/list";
	}
	
}
