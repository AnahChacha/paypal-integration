package com.pay.paypal.dtos.orders.orderResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateOrderResponse{

	@JsonProperty("create_time")
	private String createTime;

	@JsonProperty("purchase_units")
	private List<PurchaseUnitsItem> purchaseUnits;

	@JsonProperty("links")
	private List<LinksItem> links;

	@JsonProperty("id")
	private String id;

	@JsonProperty("intent")
	private String intent;

	@JsonProperty("status")
	private String status;
}