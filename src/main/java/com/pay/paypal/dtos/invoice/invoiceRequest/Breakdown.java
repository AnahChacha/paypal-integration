package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Breakdown{

	@JsonProperty("shipping")
	private Shipping shipping;

	@JsonProperty("custom")
	private Custom custom;

	@JsonProperty("discount")
	private Discount discount;
}