package com.pay.paypal.dtos.invoice.invoiceRequest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingInfo{

	@JsonProperty("address")
	private Address address;

	@JsonProperty("email_address")
	private String emailAddress;

	@JsonProperty("additional_info_value")
	private String additionalInfoValue;

	@JsonProperty("name")
	private Name name;

	@JsonProperty("phones")
	private List<PhonesItem> phones;
}