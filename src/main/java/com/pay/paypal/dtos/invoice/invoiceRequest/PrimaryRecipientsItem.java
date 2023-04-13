package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrimaryRecipientsItem{

	@JsonProperty("shipping_info")
	@JsonIgnore
	private ShippingInfo shippingInfo;

	@JsonIgnore
	@JsonProperty("billing_info")
	private BillingInfo billingInfo;
}