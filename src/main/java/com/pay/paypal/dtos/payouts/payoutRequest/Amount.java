package com.pay.paypal.dtos.payouts.payoutRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Amount{

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("value")
	private String value;
}