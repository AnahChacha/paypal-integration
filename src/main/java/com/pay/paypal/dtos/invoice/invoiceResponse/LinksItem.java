package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LinksItem{

	@JsonProperty("method")
	private String method;

	@JsonProperty("rel")
	private String rel;

	@JsonProperty("href")
	private String href;
}