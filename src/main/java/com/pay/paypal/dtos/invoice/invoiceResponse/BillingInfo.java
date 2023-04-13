package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BillingInfo{

	@JsonProperty("address")
	private Address address;

	@JsonProperty("email_address")
	private String emailAddress;

	@JsonProperty("name")
	private Name name;
}