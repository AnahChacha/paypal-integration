package com.pay.paypal.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientTokenResponse{

	@JsonProperty("client_token")
	private String clientToken;

	@JsonProperty("id_token")
	private String idToken;

	@JsonProperty("expires_in")
	private Integer expiresIn;
}