package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UnitAmount{

	@JsonProperty("value")
	private String value;

	@JsonProperty("currency_code")
	private String currencyCode;
}