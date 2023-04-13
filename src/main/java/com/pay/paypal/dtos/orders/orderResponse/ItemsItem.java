package com.pay.paypal.dtos.orders.orderResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemsItem{

	@JsonProperty("quantity")
	private String quantity;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("unit_amount")
	private UnitAmount unitAmount;
}