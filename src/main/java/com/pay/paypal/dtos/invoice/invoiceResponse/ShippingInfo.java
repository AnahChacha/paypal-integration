package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShippingInfo{

	@JsonProperty("address")
	private Address address;

	@JsonProperty("name")
	private Name name;
}