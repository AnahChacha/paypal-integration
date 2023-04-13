package com.pay.paypal.dtos.orders.orderResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Breakdown{

	@JsonProperty("item_total")
	private ItemTotal itemTotal;
}