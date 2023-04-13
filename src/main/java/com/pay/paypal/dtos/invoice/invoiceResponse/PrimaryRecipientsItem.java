package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PrimaryRecipientsItem{

	@JsonProperty("shipping_info")
	private ShippingInfo shippingInfo;

	@JsonProperty("billing_info")
	private BillingInfo billingInfo;
}