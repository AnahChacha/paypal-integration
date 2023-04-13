package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Custom{

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("label")
	private String label;
}