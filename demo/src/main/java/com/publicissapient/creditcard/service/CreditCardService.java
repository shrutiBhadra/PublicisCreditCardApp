package com.publicissapient.creditcard.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publicissapient.creditcard.entity.CreditCard;
import com.publicissapient.creditcard.repository.CreditCardRepository;

import lombok.extern.slf4j.Slf4j;


/** 
 * @author Shruti Bhadra
 *  version 0.0.1
 */
@Service
@Slf4j
public class CreditCardService {
	
	Logger logger = LoggerFactory.getLogger(CreditCardService.class);
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	/**
	 * Saving the credit card if credit card number 
	 * validated with Luhn 10 algorithm.
	 * @param creditCard CreditCard object to save in database.
	 * @return error code 101 when it is not valid luhn 10 else 200 success code.
	 * **/
	public void saveCreditCard(CreditCard creditCard) {
	
			logger.info("Saving credit card details in database");
			creditCardRepository.save(creditCard);
			logger.info("credit card " + creditCard.getCreditCardNumber() + " saved");
			
	}

	/** 
	 * Get all the credit card details available in the application.
	 * @return list of all credit card details.
	 * **/
	public List<CreditCard> getAllCreditCardDetails() {

		logger.info("Getting all credit card details");
		List<CreditCard> creditCardList = new ArrayList<>();
		creditCardList = creditCardRepository.findAll();
		return creditCardList;
	}
	
}
