package com.pay.paypal.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientTokenRequest{

	@JsonProperty("customer_id")
	private String customerId;
}