package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest.Address;
import com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress{

	@JsonProperty("address")
	private Address address;

	@JsonProperty("name")
	private Name name;
}