package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentTerm{

	@JsonProperty("due_date")
	private String dueDate;

	@JsonProperty("term_type")
	private String termType;
}