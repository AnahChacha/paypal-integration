package com.pay.paypal.dtos.payouts.payoutResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SenderBatchHeader{

	@JsonProperty("email_message")
	private String emailMessage;

	@JsonProperty("sender_batch_id")
	private String senderBatchId;

	@JsonProperty("email_subject")
	private String emailSubject;
}