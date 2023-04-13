package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubscriptionsRequest{

	@JsonProperty("shipping_amount")
	private ShippingAmount shippingAmount;

	@JsonProperty("start_time")
	private String startTime;

	@JsonProperty("subscriber")
	private Subscriber subscriber;

	@JsonProperty("application_context")
	private ApplicationContext applicationContext;

	@JsonProperty("plan_id")
	private String planId;
}