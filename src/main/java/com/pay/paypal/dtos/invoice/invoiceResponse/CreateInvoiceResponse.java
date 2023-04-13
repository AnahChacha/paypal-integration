package com.pay.paypal.dtos.invoice.invoiceResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateInvoiceResponse{

	@JsonProperty("amount")
	private Amount amount;

	@JsonProperty("due_amount")
	private DueAmount dueAmount;

	@JsonProperty("configuration")
	private Configuration configuration;

	@JsonProperty("invoicer")
	private Invoicer invoicer;

	@JsonProperty("links")
	private List<LinksItem> links;

	@JsonProperty("unilateral")
	private Boolean unilateral;

	@JsonProperty("id")
	private String id;

	@JsonProperty("detail")
	private Detail detail;

	@JsonProperty("primary_recipients")
	private List<PrimaryRecipientsItem> primaryRecipients;

	@JsonProperty("items")
	private List<ItemsItem> items;

	@JsonProperty("status")
	private String status;
}