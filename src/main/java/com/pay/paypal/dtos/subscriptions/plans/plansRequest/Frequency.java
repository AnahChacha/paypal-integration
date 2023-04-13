package com.pay.paypal.dtos.subscriptions.plans.plansRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Frequency{

	@JsonProperty("interval_count")
	private Integer intervalCount;

	@JsonProperty("interval_unit")
	private String intervalUnit;
}