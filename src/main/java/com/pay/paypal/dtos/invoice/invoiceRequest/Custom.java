package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pay.paypal.dtos.invoice.invoiceRequest.Amount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Custom{

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("label")
	private String label;
}