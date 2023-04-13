package com.pay.paypal.dtos.payouts.payoutResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
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