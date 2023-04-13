package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name{

	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("surname")
	private String surname;

	@JsonProperty("given_name")
	private String givenName;
}