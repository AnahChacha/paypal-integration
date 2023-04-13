package com.pay.paypal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import com.pay.paypal.service.PaypalService;
import com.pay.paypal.tokens.ClientTokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "paypal")
@RequiredArgsConstructor
public class PaypalController {
    private final PaypalService paypalService;

    @PostMapping(value = "/createAccessToken")
    public ResponseEntity<?>createAccessToken() throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(paypalService.createAccessToken());
    }

//    the ? is used when we are not sure of what is to be returned and whenever its invoked the handler request will not have a problem
    @PostMapping(value = "/createClientToken")
    public ResponseEntity<?>createClientToken(ClientTokenRequest clientTokenRequest){
        return ResponseEntity.status(HttpStatus.OK).body(paypalService.createClientToken(clientTokenRequest));
    }

    @PostMapping(value = "/createOrder")
    public ResponseEntity<CreateOrderResponse>createOrder(@RequestBody CreateOrderRequest createOrderRequest){
       return ResponseEntity.ok(paypalService.createOrder(createOrderRequest));
    }

    @PostMapping(value = "/createInvoice")
    public ResponseEntity<CreateInvoiceResponse>createInvoice(@RequestBody CreateInvoiceRequest invoiceRequest){
      return ResponseEntity.status(HttpStatus.CREATED).body(paypalService.createInvoice(invoiceRequest));
    }

    @PostMapping(value = "/createPayouts")
    public ResponseEntity<CreatePayoutResponse>createPayouts(@RequestBody CreatePayoutRequest payoutRequest){
        return ResponseEntity.status(HttpStatus.OK).body(paypalService.createPayouts(payoutRequest));
    }

    @PostMapping(value = "/createCatalog")
    public ResponseEntity<CreateCatalogResponse>createCatalogs(@RequestBody CreateCatalogRequest catalogRequest){
        return ResponseEntity.ok(paypalService.createCatalog(catalogRequest));
    }

    @PostMapping(value = "/createPlans")
    public ResponseEntity<CreatePlansResponse>createPlans(@RequestBody CreatePlansRequest createPlansRequest){
        return ResponseEntity.ok(paypalService.createPlans(createPlansRequest));
    }

    @PostMapping(value = "createSubscriptions")
    public ResponseEntity<CreateSubscriptionsResponse>createSubscriptions(@RequestBody CreateSubscriptionsRequest subscriptionsRequest){
       return ResponseEntity.status(HttpStatus.CREATED).body(paypalService.createSubscriptions(subscriptionsRequest));
    }
}
