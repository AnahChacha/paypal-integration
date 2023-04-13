package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount{

	@JsonProperty("invoice_discount")
	private InvoiceDiscount invoiceDiscount;

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("percent")
	private String percent;
}