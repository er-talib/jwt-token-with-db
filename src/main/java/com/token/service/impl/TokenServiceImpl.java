package com.token.service.impl;

import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.token.entities.Token;
import com.token.repository.TokenRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl {

	@Autowired
	private TokenRepository tokenRepository;

	public Token addTokenDetails(Token token) {
		token.setLoginTime(new Date(System.currentTimeMillis() + TimeUnit.MILLISECONDS.toMillis(10)));
		Token addTokenDetails = tokenRepository.save(token);
		return addTokenDetails;

	}

	public String encode(Token token) {

		String secretKey = "SBM";
		Claims claims = Jwts.claims();
		claims.put("tokenId", token.getTokenId());
		claims.put("authority", token.getRole());
		claims.put("userId", token.getUserId());
		claims.put("userRefer", token.getUserRefer());
		claims.put("username", token.getUsername());
		claims.put("census", token.getCensus());
		claims.put("loginCount", token.getLoginCount());
		claims.put("isPasswordChanged", token.getIsPasswordChanged());
		claims.put("loginTime", token.getLoginTime());
		claims.put("expiryInMinutes", new Date(System.currentTimeMillis() + TimeUnit.MILLISECONDS.toMillis(10)));

		return Jwts.builder().setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encode(secretKey.getBytes())).compact();

	}

	public Token getTokenDetails(Integer tokenId) {
		Token token = this.tokenRepository.findById(tokenId).get();
		return token;

	}

}
