package com.pay.paypal.dtos.orders.orderRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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