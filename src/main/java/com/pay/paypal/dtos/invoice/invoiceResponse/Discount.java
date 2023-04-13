package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Discount{

	@JsonProperty("item_discount")
	private ItemDiscount itemDiscount;

	@JsonProperty("invoice_discount")
	private InvoiceDiscount invoiceDiscount;

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("percent")
	private String percent;
}