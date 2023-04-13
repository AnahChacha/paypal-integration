package com.pay.paypal.dtos.subscriptions.plans.plansResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePlansResponse{

	@JsonProperty("quantity_supported")
	private Boolean quantitySupported;

	@JsonProperty("create_time")
	private String createTime;

	@JsonProperty("payment_preferences")
	private PaymentPreferences paymentPreferences;

	@JsonProperty("description")
	private String description;

	@JsonProperty("taxes")
	private Taxes taxes;

	@JsonProperty("update_time")
	private String updateTime;

	@JsonProperty("usage_type")
	private String usageType;

	@JsonProperty("product_id")
	private String productId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("billing_cycles")
	private List<BillingCyclesItem> billingCycles;

	@JsonProperty("links")
	private List<LinksItem> links;

	@JsonProperty("id")
	private String id;

	@JsonProperty("status")
	private String status;
}