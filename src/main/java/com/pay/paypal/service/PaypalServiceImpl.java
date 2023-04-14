package com.pay.paypal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pay.paypal.dbEntity.subscriptions.catalogProducts.CreateProducts;
import com.pay.paypal.dtos.invoice.invoiceRequest.ItemsItem;
import com.pay.paypal.dtos.invoice.invoiceRequest.*;
import com.pay.paypal.dtos.invoice.invoiceResponse.CreateInvoiceResponse;
import com.pay.paypal.dtos.orders.orderRequest.CreateOrderRequest;
import com.pay.paypal.dtos.orders.orderRequest.PurchaseUnitsItem;
import com.pay.paypal.dtos.orders.orderResponse.CreateOrderResponse;
import com.pay.paypal.dtos.payouts.payoutRequest.Amount;
import com.pay.paypal.dtos.payouts.payoutRequest.CreatePayoutRequest;
import com.pay.paypal.dtos.payouts.payoutResponse.CreatePayoutResponse;
import com.pay.paypal.dtos.subscriptions.catalogProducts.catalogProductsRequest.CreateCatalogRequest;
import com.pay.paypal.dtos.subscriptions.catalogProducts.catalogProductsResponse.CreateCatalogResponse;
import com.pay.paypal.dtos.subscriptions.plans.plansRequest.*;
import com.pay.paypal.dtos.subscriptions.plans.plansResponse.CreatePlansResponse;
import com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsRequest.CreateSubscriptionsRequest;
import com.pay.paypal.dtos.subscriptions.subscriptions.subscriptionsResponse.CreateSubscriptionsResponse;
import com.pay.paypal.repository.CatalogRepository;
import com.pay.paypal.tokens.AccessTokenResponse;
import com.pay.paypal.tokens.ClientTokenRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;


@Service
@Slf4j
@RequiredArgsConstructor
public class PaypalServiceImpl implements PaypalService {
    private final ObjectMapper mapper = new ObjectMapper();
    private final RestTemplate restTemplate = new RestTemplate();
    private final CatalogRepository catalogRepository;

    @Value("${paypal.username}")
    private String username;

    @Value("${paypal.password}")
    private String password;

    @Override
    public AccessTokenResponse createAccessToken() throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");

        String url = "https://api-m.sandbox.paypal.com/v1/oauth2/token";
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).build();

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, httpHeaders);

        ResponseEntity<JsonNode> response = restTemplate.exchange(builder.toString(), HttpMethod.POST, entity, JsonNode.class);
        int statusCodeValue = response.getStatusCodeValue();
        log.info("status {}", statusCodeValue);
        log.info("statusBody {}", mapper.writeValueAsString(response.getBody()));

        JsonNode responseBody = response.getBody();
        return mapper.treeToValue(responseBody, AccessTokenResponse.class);
    }

    @Override
    public JsonNode createClientToken(ClientTokenRequest clientTokenRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String url = "https://api-m.sandbox.paypal.com/v1/identity/generate-token";

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).build();
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<JsonNode> response = restTemplate.exchange(builder.toString(), HttpMethod.POST, httpEntity, JsonNode.class);
        int statusCodeValue = response.getStatusCodeValue();
        log.info("status {}", statusCodeValue +" OK");
        log.info("clientTokenBody {}", response.getBody());

        JsonNode clientBody = response.getBody();
        return clientBody;
    }

    @Override
    @SneakyThrows
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        CreateOrderRequest createOrderRequest1 = new CreateOrderRequest();
        createOrderRequest1.setApplicationContext(createOrderRequest.getApplicationContext());
        createOrderRequest1.getApplicationContext().setCancelUrl(createOrderRequest.getApplicationContext().getCancelUrl());
        createOrderRequest1.getApplicationContext().setReturnUrl(createOrderRequest.getApplicationContext().getReturnUrl());

        createOrderRequest1.setPurchaseUnits(createOrderRequest.getPurchaseUnits());
        createOrderRequest1.getPurchaseUnits().stream().map(purchaseUnitsItem -> new PurchaseUnitsItem(new com.pay.paypal.dtos.orders.orderRequest.Amount(purchaseUnitsItem.getAmount().getBreakdown(), purchaseUnitsItem.getAmount().getValue(), purchaseUnitsItem.getAmount().getCurrencyCode()),
                (List<com.pay.paypal.dtos.orders.orderRequest.ItemsItem>) purchaseUnitsItem.getItems().stream().map(itemsItem -> new com.pay.paypal.dtos.orders.orderRequest.ItemsItem(itemsItem.getName(), itemsItem.getQuantity(), itemsItem.getDescription(), new com.pay.paypal.dtos.orders.orderRequest.UnitAmount(itemsItem.getUnitAmount().getValue(), itemsItem.getUnitAmount().getCurrencyCode())))));

        createOrderRequest1.setIntent(createOrderRequest.getIntent());

        AccessTokenResponse accessTokenResponse = createAccessToken();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessTokenResponse.getAccessToken());
        String url = "https://api-m.sandbox.paypal.com/v2/checkout/orders";

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).build();

        HttpEntity<CreateOrderRequest> entity = new HttpEntity<>(createOrderRequest, httpHeaders);
        ResponseEntity<JsonNode> orderResponse = restTemplate.exchange(builder.toString(), HttpMethod.POST, entity, JsonNode.class);

        int statusCodeValue = orderResponse.getStatusCodeValue();
        System.out.println("=======================" + statusCodeValue);
        log.info("statusCode {}", statusCodeValue);
        log.info("orderBody = {}", orderResponse.getBody());

        JsonNode orderResponseBody = orderResponse.getBody();

        CreateOrderResponse createOrderResponse = mapper.treeToValue(orderResponseBody, CreateOrderResponse.class);
        return createOrderResponse;
    }

    @Override
    @SneakyThrows
    public CreateInvoiceResponse createInvoice(CreateInvoiceRequest invoiceRequest) {
        CreateInvoiceRequest createInvoiceRequest = new CreateInvoiceRequest();
        createInvoiceRequest.setAmount(invoiceRequest.getAmount());
        createInvoiceRequest.getAmount().setBreakdown(invoiceRequest.getAmount().getBreakdown());
        createInvoiceRequest.getAmount().getBreakdown().setShipping(invoiceRequest.getAmount().getBreakdown().getShipping());
        createInvoiceRequest.getAmount().getBreakdown().setDiscount(invoiceRequest.getAmount().getBreakdown().getDiscount());
        createInvoiceRequest.getAmount().getBreakdown().setCustom(invoiceRequest.getAmount().getBreakdown().getCustom());
        createInvoiceRequest.getAmount().getBreakdown().getShipping().setAmount(invoiceRequest.getAmount().getBreakdown().getShipping().getAmount());
        createInvoiceRequest.getAmount().getBreakdown().getShipping().setTax(invoiceRequest.getAmount().getBreakdown().getShipping().getTax());
        createInvoiceRequest.getAmount().getBreakdown().getShipping().getTax().setName(invoiceRequest.getAmount().getBreakdown().getShipping().getTax().getName());
        createInvoiceRequest.getAmount().getBreakdown().getDiscount().setInvoiceDiscount(invoiceRequest.getAmount().getBreakdown().getDiscount().getInvoiceDiscount());
        createInvoiceRequest.getAmount().getBreakdown().getDiscount().getInvoiceDiscount().setPercent(invoiceRequest.getAmount().getBreakdown().getDiscount().getInvoiceDiscount().getPercent());
        createInvoiceRequest.getAmount().getBreakdown().getDiscount().setAmount(invoiceRequest.getAmount().getBreakdown().getDiscount().getAmount());
        createInvoiceRequest.getAmount().getBreakdown().getDiscount().setPercent(invoiceRequest.getAmount().getBreakdown().getDiscount().getPercent());
        createInvoiceRequest.getAmount().getBreakdown().getCustom().setLabel(invoiceRequest.getAmount().getBreakdown().getCustom().getLabel());
        createInvoiceRequest.getAmount().getBreakdown().getCustom().setAmount(invoiceRequest.getAmount().getBreakdown().getCustom().getAmount());
        createInvoiceRequest.getAmount().setCurrencyCode(invoiceRequest.getAmount().getCurrencyCode());
        createInvoiceRequest.getAmount().setValue(invoiceRequest.getAmount().getValue());

        createInvoiceRequest.setInvoicer(invoiceRequest.getInvoicer());
        createInvoiceRequest.getInvoicer().setAdditionalNotes(invoiceRequest.getInvoicer().getAdditionalNotes());
        createInvoiceRequest.getInvoicer().setWebsite(invoiceRequest.getInvoicer().getWebsite());
        createInvoiceRequest.getInvoicer().setLogoUrl(invoiceRequest.getInvoicer().getLogoUrl());
        createInvoiceRequest.getInvoicer().setTaxId(invoiceRequest.getInvoicer().getTaxId());
        createInvoiceRequest.getInvoicer().setName(invoiceRequest.getInvoicer().getName());
        createInvoiceRequest.getInvoicer().getName().setGivenName(invoiceRequest.getInvoicer().getName().getGivenName());
        createInvoiceRequest.getInvoicer().getName().setSurname(invoiceRequest.getInvoicer().getName().getSurname());
        createInvoiceRequest.getInvoicer().setAddress(invoiceRequest.getInvoicer().getAddress());
        createInvoiceRequest.getInvoicer().getAddress().setAddressLine1(invoiceRequest.getInvoicer().getAddress().getAddressLine1());
        createInvoiceRequest.getInvoicer().getAddress().setAddressLine2(invoiceRequest.getInvoicer().getAddress().getAddressLine2());
        createInvoiceRequest.getInvoicer().getAddress().setAdminArea1(invoiceRequest.getInvoicer().getAddress().getAdminArea1());
        createInvoiceRequest.getInvoicer().getAddress().setAdminArea2(invoiceRequest.getInvoicer().getAddress().getAdminArea2());
        createInvoiceRequest.getInvoicer().getAddress().setPostalCode(invoiceRequest.getInvoicer().getAddress().getPostalCode());
        createInvoiceRequest.getInvoicer().getAddress().setCountryCode(invoiceRequest.getInvoicer().getAddress().getCountryCode());
        createInvoiceRequest.getInvoicer().setPhones(invoiceRequest.getInvoicer().getPhones());
        createInvoiceRequest.getInvoicer().getPhones().stream().map(phonesItem -> new PhonesItem(phonesItem.getCountryCode(), phonesItem.getPhoneType(), phonesItem.getNationalNumber()));

        createInvoiceRequest.setDetail(invoiceRequest.getDetail());
        createInvoiceRequest.getDetail().setInvoiceDate(invoiceRequest.getDetail().getInvoiceDate());
        createInvoiceRequest.getDetail().setInvoiceNumber(invoiceRequest.getDetail().getInvoiceNumber());
        createInvoiceRequest.getDetail().setNote(invoiceRequest.getDetail().getNote());
        createInvoiceRequest.getDetail().setMemo(invoiceRequest.getDetail().getMemo());
        createInvoiceRequest.getDetail().setReference(invoiceRequest.getDetail().getReference());
        createInvoiceRequest.getDetail().setTermsAndConditions(invoiceRequest.getDetail().getTermsAndConditions());
        createInvoiceRequest.getDetail().setPaymentTerm(invoiceRequest.getDetail().getPaymentTerm());
        createInvoiceRequest.getDetail().getPaymentTerm().setTermType(invoiceRequest.getDetail().getPaymentTerm().getTermType());
        createInvoiceRequest.getDetail().getPaymentTerm().setDueDate(invoiceRequest.getDetail().getPaymentTerm().getDueDate());

        createInvoiceRequest.setConfiguration(invoiceRequest.getConfiguration());
        createInvoiceRequest.getConfiguration().setAllowTip(invoiceRequest.getConfiguration().getAllowTip());
        createInvoiceRequest.getConfiguration().setTaxInclusive(invoiceRequest.getConfiguration().getTaxInclusive());
        createInvoiceRequest.getConfiguration().setTaxCalculatedAfterDiscount(invoiceRequest.getConfiguration().getTaxCalculatedAfterDiscount());
        createInvoiceRequest.getConfiguration().setPartialPayment(invoiceRequest.getConfiguration().getPartialPayment());
        createInvoiceRequest.getConfiguration().getPartialPayment().setAllowPartialPayment(invoiceRequest.getConfiguration().getPartialPayment().getAllowPartialPayment());
        createInvoiceRequest.getConfiguration().getPartialPayment().setMinimumAmountDue(invoiceRequest.getConfiguration().getPartialPayment().getMinimumAmountDue());
        createInvoiceRequest.getConfiguration().getPartialPayment().getMinimumAmountDue().setCurrencyCode(invoiceRequest.getConfiguration().getPartialPayment().getMinimumAmountDue().getCurrencyCode());
        createInvoiceRequest.getConfiguration().getPartialPayment().getMinimumAmountDue().setValue(invoiceRequest.getConfiguration().getPartialPayment().getMinimumAmountDue().getValue());

        createInvoiceRequest.setPrimaryRecipients(invoiceRequest.getPrimaryRecipients());
        createInvoiceRequest.getPrimaryRecipients().stream().map(primaryRecipientsItem -> new PrimaryRecipientsItem(new ShippingInfo(new Address(primaryRecipientsItem.getShippingInfo().getAddress().getAddressLine1(), primaryRecipientsItem.getShippingInfo().getAddress().getAddressLine2(), primaryRecipientsItem.getShippingInfo().getAddress().getAdminArea1(), primaryRecipientsItem.getShippingInfo().getAddress().getAdminArea2(), primaryRecipientsItem.getShippingInfo().getAddress().getPostalCode(), primaryRecipientsItem.getShippingInfo().getAddress().getCountryCode()),
                new Name(primaryRecipientsItem.getShippingInfo().getName().getSurname(), primaryRecipientsItem.getShippingInfo().getName().getGivenName())),
                new BillingInfo()));

        createInvoiceRequest.setItems(invoiceRequest.getItems());
        createInvoiceRequest.getItems().stream().map(itemsItem -> new ItemsItem(itemsItem.getQuantity(), itemsItem.getName(), new Discount(new InvoiceDiscount(itemsItem.getDiscount().getPercent()), itemsItem.getDiscount().getAmount(), itemsItem.getDiscount().getPercent()),
                itemsItem.getUnitOfMeasure(), itemsItem.getTax(), itemsItem.getUnitAmount(), itemsItem.getDescription()));

        AccessTokenResponse accessTokenResponse = createAccessToken();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessTokenResponse.getAccessToken());
        String url = "https://api-m.sandbox.paypal.com/v2/invoicing/invoices";

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).build();
        HttpEntity<CreateInvoiceRequest> httpEntity = new HttpEntity<>(createInvoiceRequest, httpHeaders);
        ResponseEntity<JsonNode> invoiceResponse = restTemplate.exchange(builder.toString(), HttpMethod.POST, httpEntity, JsonNode.class);

        int statusCodeValue = invoiceResponse.getStatusCodeValue();
        log.info("statusCode{}", statusCodeValue);
        log.info("invoiceResponseBody{}", invoiceResponse.getBody());
//        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        JsonNode responseBody = invoiceResponse.getBody();
        CreateInvoiceResponse createInvoiceResponse = mapper.treeToValue(responseBody, CreateInvoiceResponse.class);

        return createInvoiceResponse;
    }

    @Override
    @SneakyThrows
    public CreatePayoutResponse createPayouts(CreatePayoutRequest payoutRequest) {
        CreatePayoutRequest createPayoutRequest1 = new CreatePayoutRequest();
        createPayoutRequest1.setSenderBatchHeader(payoutRequest.getSenderBatchHeader());
        createPayoutRequest1.getSenderBatchHeader().setSenderBatchId(payoutRequest.getSenderBatchHeader().getSenderBatchId());
        createPayoutRequest1.getSenderBatchHeader().setEmailSubject(payoutRequest.getSenderBatchHeader().getEmailSubject());
        createPayoutRequest1.getSenderBatchHeader().setEmailMessage(payoutRequest.getSenderBatchHeader().getEmailMessage());

        createPayoutRequest1.setItems(payoutRequest.getItems());
        createPayoutRequest1.getItems().stream().map(itemsItem -> new com.pay.paypal.dtos.payouts.payoutRequest.ItemsItem(itemsItem.getRecipientType(), itemsItem.getNote(), new Amount(itemsItem.getAmount().getCurrency(), itemsItem.getAmount().getValue()),
                itemsItem.getReceiver(), itemsItem.getSenderItemId(), itemsItem.getNotificationLanguage()));

//        we must always invoke and intitiliaze the access token
        AccessTokenResponse accessTokenResponse = createAccessToken();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessTokenResponse.getAccessToken());
        String url = "https://api-m.sandbox.paypal.com/v1/payments/payouts";

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).build();
        HttpEntity<CreatePayoutRequest> entity = new HttpEntity<>(payoutRequest, httpHeaders);

        ResponseEntity<JsonNode> response = restTemplate.exchange(builder.toString(), HttpMethod.POST, entity, JsonNode.class);
        int statusCodeValue = response.getStatusCodeValue();
        log.info("statusCode {}", statusCodeValue);
        log.info("payoutsResponseBody {}", response.getBody());

        JsonNode responseBody = response.getBody();
        CreatePayoutResponse createPayoutResponse = mapper.treeToValue(responseBody, CreatePayoutResponse.class);
        return createPayoutResponse;

    }

    @Override
    @SneakyThrows
    public CreateCatalogResponse createCatalog(CreateCatalogRequest catalogRequest) {
        CreateCatalogRequest catalogRequest1 = new CreateCatalogRequest();
        catalogRequest1.setHomeUrl(catalogRequest.getHomeUrl());
        catalogRequest1.setImageUrl(catalogRequest.getImageUrl());
        catalogRequest1.setName(catalogRequest.getName());
        catalogRequest1.setDescription(catalogRequest.getDescription());
        catalogRequest1.setId(catalogRequest.getId());
        catalogRequest1.setType(catalogRequest.getType());
        catalogRequest1.setCategory(catalogRequest.getCategory());
//        System.out.println("catalog product lists  ======= " + catalogRequest1);

//        saving products details(catalog products)
        CreateProducts products=new CreateProducts();
        products.setHomeUrl(catalogRequest1.getHomeUrl());
        products.setImageUrl(catalogRequest1.getImageUrl());
        products.setName(catalogRequest1.getName());
        products.setDescription(catalogRequest1.getDescription());
        products.setProductId(UUID.randomUUID().toString());
        products.setType(catalogRequest1.getType());
        products.setCategory(catalogRequest1.getCategory());

        catalogRepository.save(products);


        AccessTokenResponse accessTokenResponse = createAccessToken();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessTokenResponse.getAccessToken());
        HttpEntity<CreateCatalogRequest> httpEntity = new HttpEntity<>(catalogRequest, httpHeaders);
        String url = "https://api-m.sandbox.paypal.com/v1/catalogs/products";
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).build();
        ResponseEntity<JsonNode> productsResponse = restTemplate.exchange(builder.toString(), HttpMethod.POST, httpEntity, JsonNode.class);

        int statusCodeValue = productsResponse.getStatusCodeValue();
        log.info("statusCode = {}", statusCodeValue);
//        how can one person be so dumb,i had just logged the request entity,and i think because am the one manipulating this code,it does not detect anything wrong
//        log.info("catalogProductsBody {}", mapper.writeValueAsString(catalogRequest1));
        log.info("catalogProducts {}",mapper.writeValueAsString(productsResponse.getBody()));

        JsonNode responseBody = productsResponse.getBody();

        CreateCatalogResponse catalogResponse = mapper.treeToValue(responseBody, CreateCatalogResponse.class);
        return catalogResponse;
    }

    @Override
    @SneakyThrows
    public CreatePlansResponse createPlans(CreatePlansRequest createPlansRequest) {
        CreatePlansRequest createPlansRequest1 = new CreatePlansRequest();
        createPlansRequest1.setPaymentPreferences(createPlansRequest.getPaymentPreferences());

        createPlansRequest1.getPaymentPreferences().setSetupFee(createPlansRequest.getPaymentPreferences().getSetupFee());
        createPlansRequest1.getPaymentPreferences().getSetupFee().setCurrencyCode(createPlansRequest.getPaymentPreferences().getSetupFee().getCurrencyCode());
        createPlansRequest1.getPaymentPreferences().getSetupFee().setValue(createPlansRequest.getPaymentPreferences().getSetupFee().getValue());

        createPlansRequest1.getPaymentPreferences().setSetupFeeFailureAction(createPlansRequest.getPaymentPreferences().getSetupFeeFailureAction());
        createPlansRequest1.getPaymentPreferences().setAutoBillOutstanding(createPlansRequest.getPaymentPreferences().getAutoBillOutstanding());
        createPlansRequest1.getPaymentPreferences().setPaymentFailureThreshold(createPlansRequest.getPaymentPreferences().getPaymentFailureThreshold());

        createPlansRequest1.setProductId(createPlansRequest.getProductId());
        createPlansRequest1.setName(createPlansRequest.getName());

        createPlansRequest1.setBillingCycles(createPlansRequest.getBillingCycles());
        createPlansRequest1.getBillingCycles().stream().map(billingCyclesItem -> new BillingCyclesItem(billingCyclesItem.getSequence(), billingCyclesItem.getTenureType(),
                billingCyclesItem.getTotalCycles(), new PricingScheme(new FixedPrice(billingCyclesItem.getPricingScheme().getFixedPrice().getValue(), billingCyclesItem.getPricingScheme().getFixedPrice().getCurrencyCode())), new Frequency(billingCyclesItem.getFrequency().getIntervalCount(), billingCyclesItem.getFrequency().getIntervalUnit())));

        createPlansRequest1.setDescription(createPlansRequest.getDescription());

        createPlansRequest1.setTaxes(createPlansRequest.getTaxes());
        createPlansRequest1.getTaxes().setInclusive(createPlansRequest.getTaxes().getInclusive());
        createPlansRequest1.getTaxes().setPercentage(createPlansRequest.getTaxes().getPercentage());

        createPlansRequest1.setStatus(createPlansRequest.getStatus());

        AccessTokenResponse accessTokenResponse = createAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessTokenResponse.getAccessToken());
        HttpEntity<CreatePlansRequest> httpEntity = new HttpEntity<>(createPlansRequest, headers);
        String url = "https://api-m.sandbox.paypal.com/v1/billing/plans";

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).build();
        ResponseEntity<JsonNode> response = restTemplate.exchange(builder.toString(), HttpMethod.POST, httpEntity, JsonNode.class);

        int statusCodeValue = response.getStatusCodeValue();
        log.info("statusCode{}", statusCodeValue);
        log.info("plansResponseBody {}", response.getBody());

        JsonNode responseBody = response.getBody();
        CreatePlansResponse createPlansResponse = mapper.treeToValue(responseBody, CreatePlansResponse.class);

        return createPlansResponse;
    }

    // i annotated sneakyThrows since i want a clean code instead of throwing jsonProcessingException
    @Override
    @SneakyThrows
    public CreateSubscriptionsResponse createSubscriptions(CreateSubscriptionsRequest subscriptionsRequest) {
        CreateSubscriptionsRequest subscriptionsRequest1 = new CreateSubscriptionsRequest();
        subscriptionsRequest1.setShippingAmount(subscriptionsRequest.getShippingAmount());
        subscriptionsRequest1.getShippingAmount().setCurrencyCode(subscriptionsRequest.getShippingAmount().getCurrencyCode());
        subscriptionsRequest1.getShippingAmount().setValue(subscriptionsRequest.getShippingAmount().getValue());

        subscriptionsRequest1.setStartTime(subscriptionsRequest.getStartTime());

        subscriptionsRequest1.setSubscriber(subscriptionsRequest.getSubscriber());
        subscriptionsRequest1.getSubscriber().setEmailAddress(subscriptionsRequest.getSubscriber().getEmailAddress());
        subscriptionsRequest1.getSubscriber().setName(subscriptionsRequest.getSubscriber().getName());
        subscriptionsRequest1.getSubscriber().getName().setFullName(subscriptionsRequest.getSubscriber().getName().getFullName());
        subscriptionsRequest1.getSubscriber().getName().setGivenName(subscriptionsRequest.getSubscriber().getName().getGivenName());
        subscriptionsRequest1.getSubscriber().getName().setSurname(subscriptionsRequest.getSubscriber().getName().getSurname());
        subscriptionsRequest1.getSubscriber().setShippingAddress(subscriptionsRequest.getSubscriber().getShippingAddress());
        subscriptionsRequest1.getSubscriber().getShippingAddress().setName(subscriptionsRequest.getSubscriber().getShippingAddress().getName());
        subscriptionsRequest1.getSubscriber().getShippingAddress().getName().setFullName(subscriptionsRequest.getSubscriber().getShippingAddress().getName().getFullName());
        subscriptionsRequest1.getSubscriber().getShippingAddress().setAddress(subscriptionsRequest.getSubscriber().getShippingAddress().getAddress());
        subscriptionsRequest1.getSubscriber().getShippingAddress().getAddress().setAddressLine1(subscriptionsRequest.getSubscriber().getShippingAddress().getAddress().getAddressLine1());
        subscriptionsRequest1.getSubscriber().getShippingAddress().getAddress().setAddressLine2(subscriptionsRequest.getSubscriber().getShippingAddress().getAddress().getAddressLine2());
        subscriptionsRequest1.getSubscriber().getShippingAddress().getAddress().setAdminArea2(subscriptionsRequest.getSubscriber().getShippingAddress().getAddress().getAdminArea2());
        subscriptionsRequest1.getSubscriber().getShippingAddress().getAddress().setAdminArea1(subscriptionsRequest.getSubscriber().getShippingAddress().getAddress().getAdminArea1());
        subscriptionsRequest1.getSubscriber().getShippingAddress().getAddress().setPostalCode(subscriptionsRequest.getSubscriber().getShippingAddress().getAddress().getPostalCode());
        subscriptionsRequest1.getSubscriber().getShippingAddress().getAddress().setCountryCode(subscriptionsRequest.getSubscriber().getShippingAddress().getAddress().getCountryCode());

        subscriptionsRequest1.setApplicationContext(subscriptionsRequest.getApplicationContext());
        subscriptionsRequest1.getApplicationContext().setBrandName(subscriptionsRequest.getApplicationContext().getBrandName());
        subscriptionsRequest1.getApplicationContext().setLocale(subscriptionsRequest.getApplicationContext().getLocale());
        subscriptionsRequest1.getApplicationContext().setShippingPreference(subscriptionsRequest.getApplicationContext().getShippingPreference());
        subscriptionsRequest1.getApplicationContext().setUserAction(subscriptionsRequest.getApplicationContext().getUserAction());
        subscriptionsRequest1.getApplicationContext().setPaymentMethod(subscriptionsRequest.getApplicationContext().getPaymentMethod());
        subscriptionsRequest1.getApplicationContext().getPaymentMethod().setPayerSelected(subscriptionsRequest.getApplicationContext().getPaymentMethod().getPayerSelected());
        subscriptionsRequest1.getApplicationContext().getPaymentMethod().setPayeePreferred(subscriptionsRequest.getApplicationContext().getPaymentMethod().getPayeePreferred());
        subscriptionsRequest1.getApplicationContext().setReturnUrl(subscriptionsRequest.getApplicationContext().getReturnUrl());
        subscriptionsRequest1.getApplicationContext().setCancelUrl(subscriptionsRequest.getApplicationContext().getCancelUrl());

        subscriptionsRequest1.setPlanId(subscriptionsRequest.getPlanId());

        AccessTokenResponse accessTokenResponse=createAccessToken();
        HttpHeaders headers=new HttpHeaders();
        headers.setBearerAuth(accessTokenResponse.getAccessToken());
        HttpEntity<CreateSubscriptionsRequest>entity=new HttpEntity<>(subscriptionsRequest,headers);
        String url="https://api-m.sandbox.paypal.com/v1/billing/subscriptions";

        UriComponents builder=UriComponentsBuilder.fromHttpUrl(url).build();
        ResponseEntity<JsonNode>response=restTemplate.exchange(builder.toString(),HttpMethod.POST,entity, JsonNode.class);

        int statusCodeValue=response.getStatusCodeValue();
        log.info("status {}",statusCodeValue);
        log.info("subscriptionsResponsePayload {}",response.getBody());

        JsonNode responseBody=response.getBody();

        return mapper.treeToValue(responseBody,CreateSubscriptionsResponse.class);
    }
}


