package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Detail{

	@JsonProperty("note")
	private String note;

	@JsonProperty("metadata")
	private Metadata metadata;

	@JsonProperty("payment_term")
	private PaymentTerm paymentTerm;

	@JsonProperty("category_code")
	private String categoryCode;

	@JsonProperty("memo")
	private String memo;

	@JsonProperty("viewed_by_recipient")
	private Boolean viewedByRecipient;

	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("invoice_date")
	private String invoiceDate;

	@JsonProperty("reference")
	private String reference;

	@JsonProperty("terms_and_conditions")
	private String termsAndConditions;

	@JsonProperty("archived")
	private Boolean archived;

	@JsonProperty("additional_data")
	private String additionalData;

	@JsonProperty("group_draft")
	private Boolean groupDraft;

	@JsonProperty("invoice_number")
	private String invoiceNumber;
}