package com.pay.paypal.dtos.subscriptions.plans.plansResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Frequency{

	@JsonProperty("interval_count")
	private Integer intervalCount;

	@JsonProperty("interval_unit")
	private String intervalUnit;
}