package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateSubscriptionsResponse{

	@JsonProperty("shipping_amount")
	private ShippingAmount shippingAmount;

	@JsonProperty("start_time")
	private String startTime;

	@JsonProperty("quantity")
	private String quantity;

	@JsonProperty("subscriber")
	private Subscriber subscriber;

	@JsonProperty("create_time")
	private String createTime;

	@JsonProperty("links")
	private List<LinksItem> links;

	@JsonProperty("id")
	private String id;

	@JsonProperty("plan_overridden")
	private Boolean planOverridden;

	@JsonProperty("plan_id")
	private String planId;

	@JsonProperty("status")
	private String status;

	@JsonProperty("status_update_time")
	private String statusUpdateTime;
}