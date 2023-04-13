package com.pay.paypal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.pay.paypal.dtos.invoice.invoiceRequest.CreateInvoiceRequest;
import com.pay.paypal.dtos.invoice.invoiceResponse.CreateInvoiceResponse;
import com.pay.paypal.dtos.orders.orderRequest.CreateOrderRequest;
import com.pay.paypal.dtos.orders.orderResponse.CreateOrderResponse;
import com.pay.paypal.dtos.payouts.payoutRequest.CreatePayoutRequest;
import com.pay.paypal.dtos.payouts.payoutResponse.CreatePayoutResponse;
import com.pay.paypal.dtos.subscriptions.catalogProducts.catalogProductsRequest.CreateCatalogRequest;
import com.pay.paypal.dtos.subscriptions.catalogProducts.catalogProductsResponse.CreateCatalogResponse;
import com.pay.paypal.dtos.subscriptions.plans.plansRequest.CreatePlansRequest;
import com.pay.paypal.dtos.subscriptions.plans.plansResponse.CreatePlansResponse;
import com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest.CreateSubscriptionsRequest;
import com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsResponse.CreateSubscriptionsResponse;
import com.pay.paypal.tokens.AccessTokenResponse;
import com.pay.paypal.tokens.ClientTokenRequest;


public interface PaypalService {
    AccessTokenResponse createAccessToken() throws JsonProcessingException;
    JsonNode createClientToken(ClientTokenRequest clientTokenRequest);
    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);
    CreateInvoiceResponse createInvoice(CreateInvoiceRequest invoiceRequest);
    CreatePayoutResponse createPayouts(CreatePayoutRequest payoutRequest);
    CreateCatalogResponse createCatalog(CreateCatalogRequest catalogRequest);
    CreatePlansResponse createPlans(CreatePlansRequest createPlansRequest);
    CreateSubscriptionsResponse createSubscriptions(CreateSubscriptionsRequest subscriptionsRequest);

//    N/B: creating transactions that have payload i.e response and request in it  whenever we want to invoke each transaction and for it to return a
//    response that we need,we invoke first the response because that is what we need to return and pass the request
//    because we hit the request to return the response
}

//i am proud of myself because i try my best not to have a boiler plate code hence using @SneakyThrows
