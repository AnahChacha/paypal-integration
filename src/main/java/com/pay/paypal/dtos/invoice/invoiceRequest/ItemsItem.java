package com.pay.paypal.dtos.invoice.invoiceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

	@JsonProperty("unit_amount")
	private UnitAmount unitAmount;

	@JsonProperty("description")
	private String description;
}