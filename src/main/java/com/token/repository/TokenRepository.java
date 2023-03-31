package com.token.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.token.entities.Token;


@Repository
public interface TokenRepository extends JpaRepository<Token, Serializable> {

}
