package com.token.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Token {

	@Id
	private Integer tokenId;
	
	private String role;

	private String userId;

	private Long userRefer;

	private String username;

	private String census;

	private Date loginTime;

	private int loginCount;

	private Boolean isPasswordChanged = false;

	private int expiryInMinutes;

}
