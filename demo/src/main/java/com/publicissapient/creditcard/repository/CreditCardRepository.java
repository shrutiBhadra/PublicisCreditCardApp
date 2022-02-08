package com.publicissapient.creditcard.repository;

import org.springframework.stereotype.Repository;

import com.publicissapient.creditcard.entity.CreditCard;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String>{

	
}
