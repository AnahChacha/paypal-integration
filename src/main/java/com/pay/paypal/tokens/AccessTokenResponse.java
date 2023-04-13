package com.pay.paypal.tokens;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessTokenResponse{

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("token_type")
	private String tokenType;

	@JsonProperty("supported_authn_schemes")
	private List<String> supportedAuthnSchemes;

	@JsonProperty("app_id")
	private String appId;

	@JsonProperty("expires_in")
	private Integer expiresIn;

	@JsonProperty("nonce")
	private String nonce;

	@JsonProperty("client_metadata")
	private ClientMetadata clientMetadata;
}