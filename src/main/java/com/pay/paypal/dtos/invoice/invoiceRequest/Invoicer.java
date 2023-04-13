package com.pay.paypal.dtos.invoice.invoiceRequest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoicer{

	@JsonProperty("additional_notes")
	private String additionalNotes;

	@JsonProperty("website")
	private String website;

	@JsonProperty("address")
	private Address address;

	@JsonProperty("logo_url")
	private String logoUrl;

	@JsonProperty("name")
	private Name name;

	@JsonProperty("phones")
	private List<PhonesItem> phones;

	@JsonProperty("tax_id")
	private String taxId;
}