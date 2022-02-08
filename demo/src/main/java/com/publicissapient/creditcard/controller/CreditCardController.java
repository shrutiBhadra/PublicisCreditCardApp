package com.publicissapient.creditcard.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.creditcard.entity.CreditCard;
import com.publicissapient.creditcard.model.JwtRequest;
import com.publicissapient.creditcard.model.JwtResponse;
import com.publicissapient.creditcard.service.CreditCardService;
import com.publicissapient.creditcard.service.UserService;
import com.publicissapient.creditcard.utility.JWTUtility;

@RestController
@Validated
/* @RequestMapping("/creditcard") */
public class CreditCardController {

	Logger logger = LoggerFactory.getLogger(CreditCardController.class);
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveCreditCardDetails(@Valid @RequestBody CreditCard creditCard) {
		logger.info("Inititiating to save credit card details");
		creditCardService.saveCreditCard(creditCard);
	}
	
	@GetMapping("/details")
	public List<CreditCard> getAllCreditCardDetails() {
		logger.info("Get all the credit card deta");
		return creditCardService.getAllCreditCardDetails();
	}
	
	@PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}
