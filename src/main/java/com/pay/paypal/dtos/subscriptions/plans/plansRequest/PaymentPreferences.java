package com.pay.paypal.dtos.subscriptions.plans.plansRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentPreferences{

	@JsonProperty("setup_fee")
	private SetupFee setupFee;

	@JsonProperty("setup_fee_failure_action")
	private String setupFeeFailureAction;

	@JsonProperty("auto_bill_outstanding")
	private Boolean autoBillOutstanding;

	@JsonProperty("payment_failure_threshold")
	private Integer paymentFailureThreshold;
}