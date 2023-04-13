package com.pay.paypal.dtos.orders.orderRequest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest{

	@JsonProperty("application_context")
	private ApplicationContext applicationContext;

	@JsonProperty("purchase_units")
	private List<PurchaseUnitsItem> purchaseUnits;

	@JsonProperty("intent")
	private String intent;
}