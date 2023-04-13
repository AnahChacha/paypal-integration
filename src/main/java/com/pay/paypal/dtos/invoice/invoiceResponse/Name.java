package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Name{

	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("surname")
	private String surname;

	@JsonProperty("given_name")
	private String givenName;
}