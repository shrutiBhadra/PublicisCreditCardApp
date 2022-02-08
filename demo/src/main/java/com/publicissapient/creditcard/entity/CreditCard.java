package com.publicissapient.creditcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;



/**
 * Represents the credit card detail of an account holder.
 * @author Shruti Bhadra
 * @version 0.0.1
 *
 */
@Entity
public class CreditCard {
	
	//name of the credit card holder
	private String userName;
	
	// unique credit card number
	@com.publicissapient.creditcard.validator.CreditCardNumber
	@Id
	@Size(max= 19)	
	private String creditCardNumber;

	//balance limit for any customer.
	@Column(name = "limit_upto")
	private int limit;
	
	//current balance in an account.
	private int balance;
		
	/**
	 * Gets the name of the credit card holder.
	 * @return A string representing the 
	 * 			credit card holder name.
	 * **/
	public String getUserName() {
		return userName;
	}

	/** 
	 * Sets the name of the credit card holder.
	 * @param userName A string containing 
	 * 			the credit holder name.
	 * **/
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the credit card number.
	 * @return A string representing 
	 * 			the credit card number.
	 * **/
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * Sets the credit card number.
	 * @param A String containing 
	 * 			the credit card number.
	 * **/
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * Gets the account limit of the credit card.
	 * @return An integer value representing 
	 * 			the account limit.
	 * **/
	public int getLimit() {
		return limit;
	}

	/**
	 * Sets the account limit of the credit card.
	 * @param An integer containing 
	 * 			the account limit of the credit card.
	 * **/	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	/**
	 * Gets the account current balance of 
	 * the credit card.
	 * @return An integer value representing 
	 * 			the account current balance.
	 * **/
	public int getBalance() {
		return balance;
	}
	
	/**
	 * Sets the account current balance of 
	 * the credit card.
	 * @param An integer containing 
	 * 			the account limit of the credit card.
	 * **/
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
