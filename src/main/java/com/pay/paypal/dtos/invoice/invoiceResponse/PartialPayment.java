package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PartialPayment{

	@JsonProperty("minimum_amount_due")
	private MinimumAmountDue minimumAmountDue;

	@JsonProperty("allow_partial_payment")
	private Boolean allowPartialPayment;
}