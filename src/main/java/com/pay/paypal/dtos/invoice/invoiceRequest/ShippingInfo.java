package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pay.paypal.dtos.invoice.invoiceRequest.Address;
import com.pay.paypal.dtos.invoice.invoiceRequest.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingInfo{

	@JsonProperty("address")
	private Address address;

	@JsonProperty("name")
	private Name name;
}