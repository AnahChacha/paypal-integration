package com.pay.paypal.dtos.orders.orderRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Amount{

	@JsonProperty("breakdown")
	private Breakdown breakdown;

	@JsonProperty("value")
	private String value;

	@JsonProperty("currency_code")
	private String currencyCode;
}