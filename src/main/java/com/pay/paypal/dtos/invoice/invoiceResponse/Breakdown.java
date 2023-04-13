package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Breakdown{

	@JsonProperty("tax_total")
	private TaxTotal taxTotal;

	@JsonProperty("shipping")
	private Shipping shipping;

	@JsonProperty("custom")
	private Custom custom;

	@JsonProperty("discount")
	private Discount discount;

	@JsonProperty("item_total")
	private ItemTotal itemTotal;
}