package com.pay.paypal.dtos.invoice.invoiceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemsItem{

	@JsonProperty("quantity")
	private String quantity;

	@JsonProperty("name")
	private String name;

	@JsonProperty("discount")
	private Discount discount;

	@JsonProperty("unit_of_measure")
	private String unitOfMeasure;

	@JsonProperty("tax")
	private Tax tax;

	@JsonProperty("id")
	private String id;

	@JsonProperty("unit_amount")
	private UnitAmount unitAmount;

	@JsonProperty("description")
	private String description;
}