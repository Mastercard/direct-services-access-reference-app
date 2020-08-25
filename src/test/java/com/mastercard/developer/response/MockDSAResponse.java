package com.mastercard.developer.response;

import com.mastercard.developer.example.DirectServicesExample;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.AuthenticationResponse;
import org.openapitools.client.model.CardResponse;
import org.openapitools.client.model.DigitalPaymentResponse;
import org.openapitools.client.model.DirectServiceResponse;
import org.openapitools.client.model.ResponseDetails;
import org.openapitools.client.model.SecurityResponse;
import org.openapitools.client.model.Service;
import org.openapitools.client.model.TokenResponse;

public class MockDSAResponse {
  public static final String ACCOUNT_NUMBER = "5400000000000000";
  public static final String RESPONSE_CODE = "12";
  public static final String CLIENT_TRANSACTION_ID = "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=";
  public static final String MASTERCARD_REFERENCE_ID = "123456789";
  public static final String CVC_RESPONSE_CODE = "M";
  public static final String TOKEN_TYPE = "C";
  public static final byte[] MERCHANT_ID = "ZDNkM0xtMWhZM2x6TG1OdmJR".getBytes();
  public static final byte[] PIN_BLOCK = "AQJeCgULCwc=".getBytes();

  public static DirectServiceResponse getCombinedResponse() {
    DirectServiceResponse combinedResponse = new DirectServiceResponse();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.setClientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);
    responseDetails.setCard(new CardResponse().accountNumber(ACCOUNT_NUMBER));
    responseDetails.setSecurity(new SecurityResponse().digitalPayment(new DigitalPaymentResponse().merchantId(MERCHANT_ID)));
    List<Service> services = new ArrayList<>();
    services.add(new Service().code("50").result("C"));
    services.add(new Service().code("51").result("V"));
    responseDetails.setServices(services);
    List<Service> sercurityServices = new ArrayList<>();
    sercurityServices.add(new Service().code("18").result("C"));
    sercurityServices.add(new Service().code("18").result("U"));
    responseDetails.setSecurityServices(sercurityServices);
    responseDetails.setAuthentication(new AuthenticationResponse()
        .securityProtocol(9)
        .cardholderAuthentication(0)
        .ucafCollectionIndicator(0));
    combinedResponse.setResponse(responseDetails);
    combinedResponse.request(DirectServicesExample.buildAllFieldsRequest());
    return combinedResponse;
  }

  public static DirectServiceResponse getECommerceResponse() {
    DirectServiceResponse eCommerceResponse = new DirectServiceResponse();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.setClientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);

    CardResponse cardResponse = new CardResponse();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.setCvcResponseCode(CVC_RESPONSE_CODE);
    cardResponse.setToken(new TokenResponse().type(TOKEN_TYPE));
    responseDetails.setCard(cardResponse);
    responseDetails.setSecurity(new SecurityResponse().pinBlock(PIN_BLOCK));
    responseDetails.setAuthentication(new AuthenticationResponse()
        .securityProtocol(9)
        .cardholderAuthentication(0)
        .ucafCollectionIndicator(0));
    eCommerceResponse.setResponse(responseDetails);
    eCommerceResponse.setRequest(DirectServicesExample.buildEcommerceRequest());
    return eCommerceResponse;
  }

  public static DirectServiceResponse getInPersonResponse() {
    DirectServiceResponse inPersonResponse = new DirectServiceResponse();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.clientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);
    responseDetails.card(new CardResponse().accountNumber(ACCOUNT_NUMBER));

    inPersonResponse.setResponse(responseDetails);
    inPersonResponse.request(DirectServicesExample.buildFraudServicesOriginalRequest());
    return inPersonResponse;
  }

  public static DirectServiceResponse getReversalResponse() {
    DirectServiceResponse reversalResponse = new DirectServiceResponse();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);
    responseDetails.card(new CardResponse().accountNumber(ACCOUNT_NUMBER));

    reversalResponse.setResponse(responseDetails);
    reversalResponse.request(DirectServicesExample.buildReversalRequest());
    return reversalResponse;
  }


  public static DirectServiceResponse getAcquirerAdviceResponse() {
    DirectServiceResponse acquirerAdviceResponse = new DirectServiceResponse();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.clientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);
    responseDetails.card(new CardResponse().accountNumber(ACCOUNT_NUMBER));

    acquirerAdviceResponse.setResponse(responseDetails);
    acquirerAdviceResponse.request(DirectServicesExample.buildAcquirerAdviceRequest());
    return acquirerAdviceResponse;
  }

  public static DirectServiceResponse getTransactionHistoryAdviceResponse() {
    DirectServiceResponse transactionHistoryAdviceResponse = new DirectServiceResponse();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.clientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);
    responseDetails.card(new CardResponse().accountNumber(ACCOUNT_NUMBER));
    List<Service> services = new ArrayList<>();
    services.add(new Service().code("50").result("C"));
    services.add(new Service().code("51").result("V"));
    responseDetails.setServices(services);
    transactionHistoryAdviceResponse.setResponse(responseDetails);
    transactionHistoryAdviceResponse.request(DirectServicesExample.buildTransactionHistoryAdviceRequest());
    return transactionHistoryAdviceResponse;
  }

  public static DirectServiceResponse getFraudServicesOriginalResponse() {
    DirectServiceResponse fraudServicesOriginalResponse = new DirectServiceResponse();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.clientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);
    CardResponse cardResponse = new CardResponse();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.cvcResponseCode(CVC_RESPONSE_CODE);
    cardResponse.setToken(new TokenResponse().type(TOKEN_TYPE));
    responseDetails.card(cardResponse);
    List<Service> securityServices = new ArrayList<>();
    securityServices.add(new Service().code("18C").result("C"));
    securityServices.add(new Service().code("18U").result("U"));
    responseDetails.services(securityServices);

    responseDetails.setAuthentication(new AuthenticationResponse()
        .securityProtocol(9)
        .cardholderAuthentication(0)
        .ucafCollectionIndicator(0));
    fraudServicesOriginalResponse.setResponse(responseDetails);
    fraudServicesOriginalResponse.request(DirectServicesExample.buildFraudServicesOriginalRequest());
    return fraudServicesOriginalResponse;
  }

  public static DirectServiceResponse getFraudServicesAdviceResponse() {
    DirectServiceResponse fraudServicesAdviceResponse = new DirectServiceResponse();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.clientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);
    CardResponse cardResponse = new CardResponse();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.cvcResponseCode(CVC_RESPONSE_CODE);
    cardResponse.setToken(new TokenResponse().type(TOKEN_TYPE));
    responseDetails.card(cardResponse);
    List<Service> services = new ArrayList<>();
    services.add(new Service().code("18").result("C"));
    services.add(new Service().code("18").result("U"));
    responseDetails.services(services);

    fraudServicesAdviceResponse.setResponse(responseDetails);
    fraudServicesAdviceResponse.request(DirectServicesExample.buildFraudServicesAdviceRequest());
    return fraudServicesAdviceResponse;
  }
}
