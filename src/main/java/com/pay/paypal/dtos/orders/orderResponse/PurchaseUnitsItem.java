package com.pay.paypal.dtos.orders.orderResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PurchaseUnitsItem{

	@JsonProperty("payee")
	private Payee payee;

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("reference_id")
	private String referenceId;

	@JsonProperty("items")
	private List<ItemsItem> items;
}