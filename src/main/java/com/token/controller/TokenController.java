package com.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.token.entities.Token;
import com.token.service.impl.TokenServiceImpl;

@RestController
public class TokenController {

	@Autowired
	private TokenServiceImpl tokenServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<?> addTokenDetails(@RequestBody Token token) {
		Token tokenDetails = this.tokenServiceImpl.addTokenDetails(token);
		String encodeToken = this.tokenServiceImpl.encode(tokenDetails);
		return ResponseEntity.status(HttpStatus.OK).body(encodeToken);
	}
}
