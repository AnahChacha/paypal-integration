package com.pay.paypal.dtos.orders.orderRequest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseUnitsItem{

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("items")
	private List<ItemsItem> items;
}