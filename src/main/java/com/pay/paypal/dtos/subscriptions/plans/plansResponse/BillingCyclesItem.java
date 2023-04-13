package com.pay.paypal.dtos.subscriptions.plans.plansResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillingCyclesItem{

	@JsonProperty("sequence")
	private Integer sequence;

	@JsonProperty("tenure_type")
	private String tenureType;

	@JsonProperty("total_cycles")
	private Integer totalCycles;

	@JsonProperty("pricing_scheme")
	private PricingScheme pricingScheme;

	@JsonProperty("frequency")
	private Frequency frequency;
}