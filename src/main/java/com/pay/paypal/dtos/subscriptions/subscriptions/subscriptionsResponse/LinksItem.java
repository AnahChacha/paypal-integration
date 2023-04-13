package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinksItem{

	@JsonProperty("method")
	private String method;

	@JsonProperty("rel")
	private String rel;

	@JsonProperty("href")
	private String href;
}