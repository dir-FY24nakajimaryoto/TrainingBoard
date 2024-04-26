package com.msgboard.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msgboard.entity.Board;

/**
 * Boardリポジトリークラス
 */
public interface BoardRipository extends JpaRepository<Board, Integer>{

	/** 削除メソッドを呼び出す */
	public void deleteById(int id);
	/** 単数検索メソッドを呼び出す */
	public Board findById(int id);
	/** スレッド検索メソッドを呼び出す */
	public List<Board> findByTitleContaining(String key);
	
}
