package com.msgboard.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msgboard.entity.Board;
import com.msgboard.repository.BoardRepository;

import jakarta.transaction.Transactional;

/**
 * DB.CRUD操作を行うクラス
 */
@Service
public class BoardService {

	@Autowired
	private BoardRepository b_repos;
	
	
	/** 全件検索 */
	public List<Board> getBoardList(){
		// リポジトリのfindAllメソッドを呼び出す
		return b_repos.findAll();
	}
	
	/** 単件検索 **/
	public Board getBoard(Integer id) {
		return b_repos.findById(id).get();
	}
	
	
	/** スレッド追加 **/
	@Transactional
	public Board saveBoard(Board board) {
		return b_repos.save(board);
	}
	
	
	/** スレッドの削除処理 */
	@Transactional
	public void deleteBoard(Set<Integer> idck) {
		
		for (Integer id : idck) {
			b_repos.deleteById(id);
		}
		
	}
	
	
}
