package com.pay.paypal.dtos.subscriptions.plans.plansResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinksItem{

	@JsonProperty("encType")
	private String encType;

	@JsonProperty("method")
	private String method;

	@JsonProperty("rel")
	private String rel;

	@JsonProperty("href")
	private String href;
}