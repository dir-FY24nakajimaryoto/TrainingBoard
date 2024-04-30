package com.msgboard.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	/** 主キー. 自動生成 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	
	/** 名前 */
	@Column(length = 20, nullable = false)
	@NotEmpty
	@Length(max = 20)
	private String name;
	
	
	@OneToOne(mappedBy = "user")
	private Authentication authentication;
	
	
	/** レコードが削除される前に行う処理 */
	@PreRemove
	@Transactional
	private void preRemove() {
		// 認証エンティティからuserを切り離す
		if (authentication!=null) {
			authentication.setUser(null);
		}
	}
	
}
