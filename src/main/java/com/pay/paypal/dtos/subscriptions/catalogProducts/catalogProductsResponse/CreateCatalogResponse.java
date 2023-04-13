package com.pay.paypal.dtos.subscriptions.catalogProducts.catalogProductsResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateCatalogResponse{

	@JsonProperty("create_time")
	private String createTime;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("links")
	private List<LinksItem> links;

	@JsonProperty("id")
	private String id;
}