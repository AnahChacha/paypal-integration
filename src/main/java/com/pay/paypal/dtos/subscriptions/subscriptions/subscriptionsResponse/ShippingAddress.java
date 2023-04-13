package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingAddress{

	@JsonProperty("address")
	private Address address;

	@JsonProperty("name")
	private Name name;
}