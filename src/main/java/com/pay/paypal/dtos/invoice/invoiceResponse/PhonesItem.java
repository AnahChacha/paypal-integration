package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhonesItem{

	@JsonProperty("country_code")
	private String countryCode;

	@JsonProperty("phone_type")
	private String phoneType;

	@JsonProperty("national_number")
	private String nationalNumber;
}