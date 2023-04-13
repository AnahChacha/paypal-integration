package com.pay.paypal.dtos.subscriptions.catalogProducts.catalogProductsRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCatalogRequest{

	@JsonProperty("home_url")
	private String homeUrl;

	@JsonProperty("image_url")
	private String imageUrl;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("category")
	private String category;
}