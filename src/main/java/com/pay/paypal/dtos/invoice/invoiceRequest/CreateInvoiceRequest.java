package com.pay.paypal.dtos.invoice.invoiceRequest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest{

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("configuration")
	private Configuration configuration;

	@JsonProperty("invoicer")
	private Invoicer invoicer;

	@JsonProperty("detail")
	private Detail detail;

	@JsonProperty("primary_recipients")
	private List<PrimaryRecipientsItem> primaryRecipients;

	@JsonProperty("items")
	private List<ItemsItem> items;
}