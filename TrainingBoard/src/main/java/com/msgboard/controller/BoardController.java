package com.msgboard.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msgboard.entity.Board;
import com.msgboard.service.BoardService;


@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	public BoardController(BoardService service) {
		this.service = service;
	}

	
	/** 一覧画面を表示 */
	@GetMapping("/list")
	public String getList(Model model) {
		
		// 全件検索結果をModelに登録
		model.addAttribute("boardlist", service.getBoardList());
		
		return "board/list";
	}
	
	
	/** スレッド登録画面を表示 */
	@GetMapping("/register")
	public String getRegister(@ModelAttribute Board board) {
		return "board/register";
	}
	
	
	/** スレッド登録処理 */
	@PostMapping("/register")
	public String postRegister(Board board) {
		
		board.setCreateDate(new Date());
		
		// スレッド登録
		service.saveBoard(board);
		
		return "redirect:/board/list";
	}
	
	
	/** スレッド編集（更新）画面を表示 */
	@GetMapping("/update/{id}/")
    public String getBoard(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("board", service.getBoard(id));
		
		return "board/update";
		
	}
	
	/** スレッド編集（更新）処理 */
	@PostMapping("/update/{id}/")
	public String postBoard(Board board) {
		
		board.setUpdateDate(new Date());
		
		service.saveBoard(board);
		
		return "redirect:/board/list";
	}
	
	
}
