package com.pay.paypal.tokens;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientMetadata{

	@JsonProperty("ui_type")
	private String uiType;

	@JsonProperty("logo_uri")
	private String logoUri;

	@JsonProperty("name")
	private String name;

	@JsonProperty("scopes")
	private List<String> scopes;

	@JsonProperty("display_name")
	private String displayName;
}