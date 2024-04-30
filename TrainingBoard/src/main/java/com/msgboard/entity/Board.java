package com.msgboard.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	/** レッスンNo.の列挙型 */
	public static enum Lesson{
		L0_初期設定,
		L1_学習概要,
		L2_Java基礎,
		L3_オブジェクト指向,
		L4_継承,
		L5_コレクション,
		L6_テスト,
		L7_GitHub,
		L8_データベース,
		L9_JDBC基礎,
		L10_JDBC応用,
		L11_Hibernate,
		L12_インターネット基礎,
		L13_HTML基礎,
		L14_CSS基礎,
		L15_サーブレット基礎,
		L16_サーブレット応用,
		L17_Web開発基礎,
		L18_Web開発応用,
		L19_SpringBoot,
		L20_Tymeleaf,
		L21_SpringBoot実習,
		L22_AWSとシステムのデプロイ,
		その他
	}
	
	
	/** 主キー */
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	/** スレッド設立時刻の自動入力 */
	@Column
	private Date createDate;
	
	/** スレッド更新時刻の自動入力 */
	@Column
	private Date updateDate;
	
	
	/** Lesson No. */
	@Column
	@Enumerated(EnumType.STRING)
	private Lesson lesson;
	
	
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
