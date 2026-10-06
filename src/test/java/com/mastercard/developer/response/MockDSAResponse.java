package com.mastercard.developer.response;

import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.AlmResponseDetails;
import org.openapitools.client.model.AuthenticationResponseDetails;
import org.openapitools.client.model.CardResponseDetails;
import org.openapitools.client.model.DigitalPaymentResponseDetails;
import org.openapitools.client.model.DirectServiceResponseDetails;
import org.openapitools.client.model.MoResponseDetails;
import org.openapitools.client.model.ResponseDetails;
import org.openapitools.client.model.SecurityResponseDetails;
import org.openapitools.client.model.Service;
import org.openapitools.client.model.TokenResponseDetails;

public class MockDSAResponse {
  public static final String ACCOUNT_NUMBER = "5400000000000000";
  public static final String RESPONSE_CODE = "12";
  public static final String CLIENT_TRANSACTION_ID = "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=";
  public static final String MASTERCARD_REFERENCE_ID = "123456789";
  public static final String CVC_RESPONSE_CODE = "M";
  public static final String TOKEN_TYPE = "C";
  public static final byte[] MERCHANT_ID = "ZDNkM0xtMWhZM2x6TG1OdmJR".getBytes();
  public static final byte[] PIN_BLOCK = "AQJeCgULCwc=".getBytes();

  public static DirectServiceResponseDetails getCombinedResponse() {
    DirectServiceResponseDetails combinedResponse = new DirectServiceResponseDetails();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.setClientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);

    CardResponseDetails cardResponse = new CardResponseDetails();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.setAlm(getAlmResponseDetails());
    responseDetails.setCard(cardResponse);

    responseDetails.setSecurity(
        new SecurityResponseDetails()
            .digitalPayment(new DigitalPaymentResponseDetails().merchantId(MERCHANT_ID)));
    List<Service> services = new ArrayList<>();
    services.add(new Service().code("50").result("C"));
    services.add(new Service().code("51").result("V"));
    responseDetails.setServices(services);
    List<Service> sercurityServices = new ArrayList<>();
    sercurityServices.add(new Service().code("18").result("C"));
    sercurityServices.add(new Service().code("18").result("U"));
    responseDetails.setSecurityServices(sercurityServices);
    responseDetails.setAuthentication(
        new AuthenticationResponseDetails()
            .securityProtocol(9)
            .cardholderAuthentication(0)
            .ucafCollectionIndicator(0));
    combinedResponse.setResponse(responseDetails);
    return combinedResponse;
  }

  public static DirectServiceResponseDetails getECommerceResponse() {
    DirectServiceResponseDetails eCommerceResponse = new DirectServiceResponseDetails();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.setClientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);

    CardResponseDetails cardResponse = new CardResponseDetails();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.setCvcResponseCode(CVC_RESPONSE_CODE);
    cardResponse.setToken(new TokenResponseDetails().type(TOKEN_TYPE));
    cardResponse.setAlm(getAlmResponseDetails());
    responseDetails.setCard(cardResponse);

    responseDetails.setSecurity(new SecurityResponseDetails().pinBlock(PIN_BLOCK));
    responseDetails.setAuthentication(
        new AuthenticationResponseDetails()
            .securityProtocol(9)
            .cardholderAuthentication(0)
            .ucafCollectionIndicator(0));
    eCommerceResponse.setResponse(responseDetails);
    return eCommerceResponse;
  }

  public static DirectServiceResponseDetails getInPersonResponse() {
    DirectServiceResponseDetails inPersonResponse = new DirectServiceResponseDetails();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.clientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);

    CardResponseDetails cardResponse = new CardResponseDetails();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.setAlm(getAlmResponseDetails());
    responseDetails.card(cardResponse);

    inPersonResponse.setResponse(responseDetails);
    return inPersonResponse;
  }

  public static DirectServiceResponseDetails getReversalResponse() {
    DirectServiceResponseDetails reversalResponse = new DirectServiceResponseDetails();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);

    CardResponseDetails cardResponse = new CardResponseDetails();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.setAlm(getAlmResponseDetails());
    responseDetails.card(cardResponse);

    reversalResponse.setResponse(responseDetails);
    return reversalResponse;
  }

  public static DirectServiceResponseDetails getAcquirerAdviceResponse() {
    DirectServiceResponseDetails acquirerAdviceResponse = new DirectServiceResponseDetails();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.clientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);

    CardResponseDetails cardResponse = new CardResponseDetails();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.setAlm(getAlmResponseDetails());
    responseDetails.card(cardResponse);

    acquirerAdviceResponse.setResponse(responseDetails);
    return acquirerAdviceResponse;
  }

  public static DirectServiceResponseDetails getTransactionHistoryAdviceResponse() {
    DirectServiceResponseDetails transactionHistoryAdviceResponse =
        new DirectServiceResponseDetails();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.clientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);

    CardResponseDetails cardResponse = new CardResponseDetails();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.setAlm(getAlmResponseDetails());
    responseDetails.card(cardResponse);

    List<Service> services = new ArrayList<>();
    services.add(new Service().code("50").result("C"));
    services.add(new Service().code("51").result("V"));
    responseDetails.setServices(services);
    transactionHistoryAdviceResponse.setResponse(responseDetails);
    return transactionHistoryAdviceResponse;
  }

  public static DirectServiceResponseDetails getFraudServicesOriginalResponse() {
    DirectServiceResponseDetails fraudServicesOriginalResponse = new DirectServiceResponseDetails();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.clientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);
    CardResponseDetails cardResponse = new CardResponseDetails();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.cvcResponseCode(CVC_RESPONSE_CODE);
    cardResponse.setToken(new TokenResponseDetails().type(TOKEN_TYPE));
    cardResponse.setAlm(getAlmResponseDetails());
    responseDetails.card(cardResponse);
    List<Service> securityServices = new ArrayList<>();
    securityServices.add(new Service().code("18C").result("C"));
    securityServices.add(new Service().code("18U").result("U"));
    responseDetails.services(securityServices);

    responseDetails.setAuthentication(
        new AuthenticationResponseDetails()
            .securityProtocol(9)
            .cardholderAuthentication(0)
            .ucafCollectionIndicator(0));
    fraudServicesOriginalResponse.setResponse(responseDetails);
    return fraudServicesOriginalResponse;
  }

  public static DirectServiceResponseDetails getFraudServicesAdviceResponse() {
    DirectServiceResponseDetails fraudServicesAdviceResponse = new DirectServiceResponseDetails();
    ResponseDetails responseDetails = new ResponseDetails();
    responseDetails.setResponseCode(RESPONSE_CODE);
    responseDetails.clientTransactionId(CLIENT_TRANSACTION_ID);
    responseDetails.setMastercardReferenceId(MASTERCARD_REFERENCE_ID);
    CardResponseDetails cardResponse = new CardResponseDetails();
    cardResponse.setAccountNumber(ACCOUNT_NUMBER);
    cardResponse.cvcResponseCode(CVC_RESPONSE_CODE);
    cardResponse.setToken(new TokenResponseDetails().type(TOKEN_TYPE));
    cardResponse.setAlm(getAlmResponseDetails());
    responseDetails.card(cardResponse);
    List<Service> services = new ArrayList<>();
    services.add(new Service().code("18").result("C"));
    services.add(new Service().code("18").result("U"));
    responseDetails.services(services);

    fraudServicesAdviceResponse.setResponse(responseDetails);
    return fraudServicesAdviceResponse;
  }

  private static AlmResponseDetails getAlmResponseDetails() {
    AlmResponseDetails almResponseDetails = new AlmResponseDetails();
    almResponseDetails.setServiceCode("00000");
    almResponseDetails.setProductCode("456");
    almResponseDetails.setProductClass("1");
    almResponseDetails.setRateType("801");
    almResponseDetails.setMo(
        new MoResponseDetails().acceptanceBrand(MoResponseDetails.AcceptanceBrandEnum.MCC));
    return almResponseDetails;
  }
}
