package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Configuration{

	@JsonProperty("tax_calculated_after_discount")
	private Boolean taxCalculatedAfterDiscount;

	@JsonProperty("partial_payment")
	private PartialPayment partialPayment;

	@JsonProperty("allow_tip")
	private Boolean allowTip;

	@JsonProperty("tax_inclusive")
	private Boolean taxInclusive;

	@JsonProperty("template_id")
	private String templateId;
}