package com.msgboard.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "authenticatioin")
public class Authentication {

	/** ログインユーザ名 */
	@Id
	private String loginUser;
	
	/** password */
	private String password;
	
	/** 有効日付 */
	private Date validDate;
	
	/** ユーザID */
	@OneToOne
	@JoinColumn(name="user_id", referencedColumnName = "userId")
	private User user;
	
	
}
