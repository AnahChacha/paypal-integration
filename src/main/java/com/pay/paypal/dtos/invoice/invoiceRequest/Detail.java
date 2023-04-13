package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail{

	@JsonProperty("reference")
	private String reference;

	@JsonProperty("terms_and_conditions")
	private String termsAndConditions;

	@JsonProperty("note")
	private String note;

	@JsonProperty("payment_term")
	private PaymentTerm paymentTerm;

	@JsonProperty("memo")
	private String memo;

	@JsonProperty("invoice_number")
	private String invoiceNumber;

	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("invoice_date")
	private String invoiceDate;
}