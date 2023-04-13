package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name{

	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("surname")
	private String surname;

	@JsonProperty("given_name")
	private String givenName;
}