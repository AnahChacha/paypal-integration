package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTerm{

	@JsonProperty("due_date")
	private String dueDate;

	@JsonProperty("term_type")
	private String termType;
}