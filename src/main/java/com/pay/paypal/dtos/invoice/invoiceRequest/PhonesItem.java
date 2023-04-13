package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhonesItem{

	@JsonProperty("country_code")
	private String countryCode;

	@JsonProperty("phone_type")
	private String phoneType;

	@JsonProperty("national_number")
	private String nationalNumber;
}