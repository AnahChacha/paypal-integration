package com.pay.paypal.dtos.payouts.payoutResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BatchHeader{

	@JsonProperty("sender_batch_header")
	private SenderBatchHeader senderBatchHeader;

	@JsonProperty("batch_status")
	private String batchStatus;

	@JsonProperty("payout_batch_id")
	private String payoutBatchId;
}