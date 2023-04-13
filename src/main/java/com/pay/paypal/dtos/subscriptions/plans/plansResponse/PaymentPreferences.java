package com.pay.paypal.dtos.subscriptions.plans.plansResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentPreferences{

	@JsonProperty("setup_fee")
	private SetupFee setupFee;

	@JsonProperty("setup_fee_failure_action")
	private String setupFeeFailureAction;

	@JsonProperty("service_type")
	private String serviceType;

	@JsonProperty("auto_bill_outstanding")
	private Boolean autoBillOutstanding;

	@JsonProperty("payment_failure_threshold")
	private Integer paymentFailureThreshold;
}