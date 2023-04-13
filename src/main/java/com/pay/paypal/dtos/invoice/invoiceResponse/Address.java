package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address{

	@JsonProperty("country_code")
	private String countryCode;

	@JsonProperty("admin_area_1")
	private String adminArea1;

	@JsonProperty("address_line_1")
	private String addressLine1;

	@JsonProperty("admin_area_2")
	private String adminArea2;

	@JsonProperty("address_line_2")
	private String addressLine2;

	@JsonProperty("postal_code")
	private String postalCode;
}