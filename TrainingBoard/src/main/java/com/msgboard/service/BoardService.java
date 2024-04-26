package com.msgboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msgboard.entity.Board;
import com.msgboard.repository.BoardRipository;

/**
 * DB.CRUD操作を行うクラス
 */
@Service
public class BoardService {

	@Autowired
	BoardRipository b_repos;
	
	
	/** 全件検索 */
	public List<Board> getBoardList(){
		
		// リポジトリのfindAllメソッドを呼び出す
		return b_repos.findAll();
		
	}
	
}
