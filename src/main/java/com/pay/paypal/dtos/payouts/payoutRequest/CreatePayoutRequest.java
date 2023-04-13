package com.pay.paypal.dtos.payouts.payoutRequest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePayoutRequest{

	@JsonProperty("sender_batch_header")
	private SenderBatchHeader senderBatchHeader;

	@JsonProperty("items")
	private List<ItemsItem> items;
}