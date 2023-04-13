package com.pay.paypal.dtos.payouts.payoutRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SenderBatchHeader{

	@JsonProperty("email_message")
	private String emailMessage;

	@JsonProperty("sender_batch_id")
	private String senderBatchId;

	@JsonProperty("email_subject")
	private String emailSubject;
}