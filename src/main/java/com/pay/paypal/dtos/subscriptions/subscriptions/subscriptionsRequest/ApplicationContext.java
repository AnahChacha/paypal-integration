package com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationContext{

	@JsonProperty("user_action")
	private String userAction;

	@JsonProperty("return_url")
	private String returnUrl;

	@JsonProperty("brand_name")
	private String brandName;

	@JsonProperty("locale")
	private String locale;

	@JsonProperty("cancel_url")
	private String cancelUrl;

	@JsonProperty("shipping_preference")
	private String shippingPreference;

	@JsonProperty("payment_method")
	private PaymentMethod paymentMethod;
}