package com.msgboard.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


/**
 * Boardエンティティクラス
 */
@Data
@Entity
@Table(name="board")
public class Board {
	
	/** 主キー */
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	/** スレッド設立時刻の自動入力 */
	@Column
	private Date createDate;
	
	
	/** スレッドタイトル(要修正.後にフォーマットに含める) */
	@Column(nullable = false)
	@NotEmpty(message = "タイトルを入力してください")
	@Size(max = 100, message = "タイトルは100字以下で入力してください")
	private String title;
	
	
	/** 質問内容 */
	@Column(nullable = false)
	@NotEmpty(message = "内容を入力してください")
	private String contents;
		
	
}
