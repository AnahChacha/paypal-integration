package com.pay.paypal.dtos.orders.orderResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Payee{

	@JsonProperty("email_address")
	private String emailAddress;

	@JsonProperty("merchant_id")
	private String merchantId;
}