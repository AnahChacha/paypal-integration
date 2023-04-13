package com.pay.paypal.dtos.payouts.payoutRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pay.paypal.dtos.payouts.payoutRequest.Amount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemsItem{

	@JsonProperty("recipient_type")
	private String recipientType;

	@JsonProperty("note")
	private String note;

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("receiver")
	private String receiver;

	@JsonProperty("sender_item_id")
	private String senderItemId;

	@JsonProperty("notification_language")
	private String notificationLanguage;
}