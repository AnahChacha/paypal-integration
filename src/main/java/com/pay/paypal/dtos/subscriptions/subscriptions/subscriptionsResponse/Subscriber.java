package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subscriber{

	@JsonProperty("email_address")
	private String emailAddress;

	@JsonProperty("name")
	private Name name;

	@JsonProperty("shipping_address")
	private ShippingAddress shippingAddress;
}