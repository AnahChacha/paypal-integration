package com.pay.paypal.dtos.orders.orderRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Breakdown{

	@JsonProperty("item_total")
	private ItemTotal itemTotal;
}