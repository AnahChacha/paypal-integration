package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Shipping{

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("tax")
	private Tax tax;
}