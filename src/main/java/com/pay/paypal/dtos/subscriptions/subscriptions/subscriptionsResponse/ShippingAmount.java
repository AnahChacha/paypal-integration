package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingAmount{

	@JsonProperty("value")
	private String value;

	@JsonProperty("currency_code")
	private String currencyCode;
}