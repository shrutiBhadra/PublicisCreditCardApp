package com.publicissapient.creditcard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	private String jwtToken;

}
