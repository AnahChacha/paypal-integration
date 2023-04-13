package com.pay.paypal.dtos.payouts.payoutResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreatePayoutResponse {

	@JsonProperty("batch_header")
	private BatchHeader batchHeader;

	@JsonProperty("links")
	private List<LinksItem> links;
}