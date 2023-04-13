package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configuration{

	@JsonProperty("tax_calculated_after_discount")
	private Boolean taxCalculatedAfterDiscount;

	@JsonProperty("partial_payment")
	private PartialPayment partialPayment;

	@JsonProperty("allow_tip")
	private Boolean allowTip;

	@JsonProperty("tax_inclusive")
	private Boolean taxInclusive;
}