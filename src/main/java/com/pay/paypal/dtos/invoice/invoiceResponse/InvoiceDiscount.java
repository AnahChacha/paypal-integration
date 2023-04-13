package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InvoiceDiscount{

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("percent")
	private String percent;
}