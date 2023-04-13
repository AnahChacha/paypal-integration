package com.pay.paypal.dtos.subscriptions.plans.plansResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Taxes{

	@JsonProperty("inclusive")
	private Boolean inclusive;

	@JsonProperty("percentage")
	private String percentage;
}