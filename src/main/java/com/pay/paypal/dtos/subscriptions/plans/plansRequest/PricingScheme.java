package com.pay.paypal.dtos.subscriptions.plans.plansRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pay.paypal.dtos.subscriptions.plans.plansRequest.FixedPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PricingScheme{

	@JsonProperty("fixed_price")
	private FixedPrice fixedPrice;
}