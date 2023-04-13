package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pay.paypal.dtos.invoice.invoiceRequest.MinimumAmountDue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartialPayment{

	@JsonProperty("minimum_amount_due")
	private MinimumAmountDue minimumAmountDue;

	@JsonProperty("allow_partial_payment")
	private Boolean allowPartialPayment;
}