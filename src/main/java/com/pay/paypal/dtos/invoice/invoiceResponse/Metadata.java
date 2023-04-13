package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Metadata{

	@JsonProperty("last_update_time")
	private String lastUpdateTime;

	@JsonProperty("created_by_flow")
	private String createdByFlow;

	@JsonProperty("create_time")
	private String createTime;

	@JsonProperty("recipient_view_url")
	private String recipientViewUrl;

	@JsonProperty("invoicer_view_url")
	private String invoicerViewUrl;

	@JsonProperty("spam_info")
	private SpamInfo spamInfo;

	@JsonProperty("caller_type")
	private String callerType;
}