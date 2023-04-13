package com.pay.paypal.dtos.subscriptions.plans.plansResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricingScheme{

	@JsonProperty("update_time")
	private String updateTime;

	@JsonProperty("create_time")
	private String createTime;

	@JsonProperty("fixed_price")
	private FixedPrice fixedPrice;

	@JsonProperty("version")
	private Integer version;
}