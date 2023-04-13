package com.pay.paypal.dtos.subscriptions.plans.plansRequest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlansRequest{

	@JsonProperty("payment_preferences")
	private PaymentPreferences paymentPreferences;

	@JsonProperty("product_id")
	private String productId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("billing_cycles")
	private List<BillingCyclesItem> billingCycles;

	@JsonProperty("description")
	private String description;

	@JsonProperty("taxes")
	private Taxes taxes;

	@JsonProperty("status")
	private String status;
}