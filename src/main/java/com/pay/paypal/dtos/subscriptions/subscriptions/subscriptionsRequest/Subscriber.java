package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest.Name;
import com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscriber{

	@JsonProperty("email_address")
	private String emailAddress;

	@JsonProperty("name")
	private Name name;

	@JsonProperty("shipping_address")
	private ShippingAddress shippingAddress;
}