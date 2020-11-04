package com.mastercard.developer.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openapitools.client.model.AuthenticationRequest;
import org.openapitools.client.model.CardAcceptor;
import org.openapitools.client.model.CardRequest;
import org.openapitools.client.model.Customer;
import org.openapitools.client.model.DigitalPaymentRequest;
import org.openapitools.client.model.DirectServiceRequest;
import org.openapitools.client.model.Location;
import org.openapitools.client.model.OriginalAuthorization;
import org.openapitools.client.model.SecurityRequest;
import org.openapitools.client.model.Service;
import org.openapitools.client.model.Terminal;
import org.openapitools.client.model.TokenRequest;
import org.openapitools.client.model.TransactionRequest;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DirectServicesExample {
  public static final String ACCOUNT_NUMBER = "5400000000000000";
  public static final String ORIGINAL_SERVICE_TYPE = "ORIGINAL";
  public static final String ADVICE_SERVICE_TYPE = "ADVICE";
  public static final String ID = "ID12345";
  public static final String CLIENT_TRANSACTION_ID = "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=";
  public static final String CHIP_DATA = "aduX3UYzkZWYd_JQ1FbXcaBa";
  public static final String PAN_ENTRY_MODE = "CONTACTLESS_MAGNETIC_STRIPE";
  public static final String CUSTOMER_ID = "567899";
  public static final String TRACK_DATA = "9456963027849254982D8739279";
  public static final String PIN_BLOCK_FORMAT = "ISO_FORMAT_0";
  public static final String AUTHORIZATION_CDOE = "123456";
  public static final String ACQUIRER_ID = "123456";

  /**
   * Creates an instance of DirectServiceRequest for a combined request with multiple use cases (in this case E-Commerce and Fraud Services Original use cases) and sets all required and (available) optional information of request
   * required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequest
   * @implNote The required field values used in this tutorial are dummy values and for demo purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequest buildAllFieldsRequest() {
    DirectServiceRequest combinedRequest = new DirectServiceRequest();
    combinedRequest.setServiceType(ORIGINAL_SERVICE_TYPE);
    combinedRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);

    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    combinedRequest.setCustomer(customer);

    CardRequest cardRequest = new CardRequest();
    cardRequest.setAccountNumber(ACCOUNT_NUMBER);
    cardRequest.setValidationCode("567");
    cardRequest.setSequenceNumber("891");
    cardRequest.setCountry("840");
    cardRequest.setToken(new TokenRequest().transactionId("fe8Rr7GWCOXCRaM6KNWDb/s4gyxalgQKt/M8L6BdndA=").type("C"));
    combinedRequest.card(cardRequest);

    TransactionRequest transactionRequest = getTransactionRequest();
    combinedRequest.setTransaction(transactionRequest);

    combinedRequest.setTerminal(getTerminal());

    CardAcceptor cardAcceptor = getCardAcceptor();
    combinedRequest.setCardAcceptor(cardAcceptor);

    SecurityRequest securityRequest = new SecurityRequest();
    securityRequest.setMagStripeTrack1Data(TRACK_DATA);
    securityRequest.setMagStripeTrack2Data(TRACK_DATA);
    securityRequest.setUniversalCardholderAuthenticationField(CHIP_DATA);
    securityRequest.setPinBlockFormat(PIN_BLOCK_FORMAT);
    securityRequest.setPinKeyIndex(98);
    combinedRequest.setSecurity(securityRequest);

    AuthenticationRequest authenticationRequest = new AuthenticationRequest();
    authenticationRequest.setSecurityProtocol(9);
    authenticationRequest.setCardholderAuthentication(0);
    authenticationRequest.setUcafCollectionIndicator(0);
    authenticationRequest.setAvsResponseCode("P");
    authenticationRequest.setCvcResponseCode("M");
    combinedRequest.authentication(authenticationRequest);

    OriginalAuthorization original = new OriginalAuthorization();
    original.setResponseCode("00");
    List<Service> services = new ArrayList<>();
    services.add(new Service().code("18C").result("C"));
    services.add(new Service().code("18C").result("U"));
    original.setSecurityServices(services);
    combinedRequest.setOriginal(original);
    return combinedRequest;
  }

  private static CardAcceptor getCardAcceptor() {
    CardAcceptor cardAcceptor = new CardAcceptor();
    cardAcceptor.setMerchantType("5499");
    cardAcceptor.setTerminalId(ID);
    cardAcceptor.setAcquirerId(ACQUIRER_ID);
    cardAcceptor.setMerchantId(ID);
    cardAcceptor.name("Walmart");
    getLocation(cardAcceptor);
    return cardAcceptor;
  }

  private static TransactionRequest getTransactionRequest() {
    TransactionRequest transactionRequest = new TransactionRequest();
    transactionRequest.setTransactionType("00");
    transactionRequest.setFromAccountType("20");
    transactionRequest.setToAccountType("20");
    transactionRequest.setPurpose(0L);
    transactionRequest.setTypeIdentifier("C01");
    transactionRequest.setAmount(000000050000L);
    transactionRequest.setCurrency("840");
    transactionRequest.setSettlementAmount(000000050000L);
    transactionRequest.setSettlementCurrency("840");
    transactionRequest.setBillingAmount(000000050000L);
    transactionRequest.setBillingCurrency("840");
    transactionRequest.setBillingConversionRate("00050000");
    transactionRequest.setSettlementDate(LocalDate.parse("2019-04-12"));
    transactionRequest.setCategory("T");
    transactionRequest.setAdviceReasonCode("000");
    transactionRequest.setPromotionCode("GREECE");
    transactionRequest.setCardholderVerificationMethod("P");
    return transactionRequest;
  }

  /**
   * Creates an instance of DirectServiceRequest for Ecommerce request and sets all required and (available) optional information of request
   * required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequest
   * @implNote The required field values used in this tutorial are dummy values and for demo purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequest buildEcommerceRequest() {
    DirectServiceRequest eCommerceRequest = new DirectServiceRequest();
    eCommerceRequest.setServiceType(ORIGINAL_SERVICE_TYPE);
    eCommerceRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    eCommerceRequest.setCustomer(customer);
    CardRequest cardRequest = new CardRequest();
    cardRequest.accountNumber(ACCOUNT_NUMBER);
    cardRequest.setValidationCode("567");
    cardRequest.setSequenceNumber("891");
    eCommerceRequest.card(cardRequest);
    TransactionRequest transactionRequest = new TransactionRequest();
    transactionRequest.setTransactionType("00");
    transactionRequest.setFromAccountType("20");
    transactionRequest.setToAccountType("20");
    eCommerceRequest.setTransaction(transactionRequest);
    Terminal terminal = new Terminal();
    terminal.setPanEntryMode(PAN_ENTRY_MODE);
    eCommerceRequest.setTerminal(terminal);
    CardAcceptor cardAcceptor = new CardAcceptor();
    cardAcceptor.setMerchantType("5499");
    eCommerceRequest.setCardAcceptor(cardAcceptor);
    SecurityRequest securityRequest = new SecurityRequest();
    securityRequest.setUniversalCardholderAuthenticationField(CHIP_DATA);
    securityRequest.setPinBlockFormat(PIN_BLOCK_FORMAT);
    securityRequest.setPinKeyIndex(98);
    DigitalPaymentRequest digitalPaymentRequest = new DigitalPaymentRequest();
    securityRequest.setDigitalPayment(digitalPaymentRequest);
    eCommerceRequest.setSecurity(securityRequest);

    AuthenticationRequest authenticationRequest = new AuthenticationRequest();
    authenticationRequest.setSecurityProtocol(9);
    authenticationRequest.setCardholderAuthentication(0);
    authenticationRequest.setUcafCollectionIndicator(0);

    eCommerceRequest.authentication(authenticationRequest);
    return eCommerceRequest;
  }

  /**
   * Creates an instance of DirectServiceRequest for InPerson request and sets all required and (available) optional information of request
   * required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequest
   * @implNote The required field values used in this tutorial are dummy values and for demo purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequest buildInPersonRequest() {
    DirectServiceRequest inPersonRequest = new DirectServiceRequest();
    inPersonRequest.setServiceType(ORIGINAL_SERVICE_TYPE);
    inPersonRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    inPersonRequest.setCustomer(customer);
    CardRequest cardRequest = new CardRequest();
    cardRequest.setAccountNumber(ACCOUNT_NUMBER);
    cardRequest.setSequenceNumber("891");
    inPersonRequest.card(cardRequest);
    inPersonRequest.setTerminal(new Terminal().panEntryMode(PAN_ENTRY_MODE));
    inPersonRequest.setCardAcceptor(new CardAcceptor().merchantType("5499"));
    inPersonRequest.setSecurity(new SecurityRequest().magStripeTrack1Data(TRACK_DATA).magStripeTrack2Data(TRACK_DATA));
    return inPersonRequest;
  }

  /**
   * Creates an instance of DirectServiceRequest for Reversal request and sets all required and (available) optional information of request
   * required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequest
   * @implNote The required field values used in this tutorial are dummy values and for demo purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequest buildReversalRequest() {
    DirectServiceRequest reversalRequest = new DirectServiceRequest();
    reversalRequest.setServiceType("REVERSAL");
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    reversalRequest.setCustomer(customer);
    CardRequest card = new CardRequest();
    card.setAccountNumber(ACCOUNT_NUMBER);
    reversalRequest.setCard(card);
    TransactionRequest transaction = new TransactionRequest();
    transaction.setAmount(123L);
    reversalRequest.setTransaction(transaction);
    OriginalAuthorization authorization = new OriginalAuthorization();
    authorization.setResponseCode("00");
    reversalRequest.setOriginal(authorization);
    return reversalRequest;
  }

  /**
   * Creates an instance of DirectServiceRequest for Acquirer Advice request and sets all required and (available) optional information of request
   * required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequest
   * @implNote The required field values used in this tutorial are dummy values and for demo purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequest buildAcquirerAdviceRequest() {
    DirectServiceRequest acquirerAdviceRequest = new DirectServiceRequest();
    acquirerAdviceRequest.setServiceType(ADVICE_SERVICE_TYPE);
    acquirerAdviceRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    acquirerAdviceRequest.setCustomer(customer);
    CardRequest cardRequest = new CardRequest();
    cardRequest.setAccountNumber(ACCOUNT_NUMBER);
    acquirerAdviceRequest.card(cardRequest);
    TransactionRequest transactionRequest = new TransactionRequest();
    transactionRequest.setAmount(0000000050000L);
    transactionRequest.setCurrency("840");
    transactionRequest.setAdviceReasonCode("190");
    acquirerAdviceRequest.setTransaction(transactionRequest);
    OriginalAuthorization original = new OriginalAuthorization();
    original.setResponseCode("00");
    acquirerAdviceRequest.setOriginal(original);
    return acquirerAdviceRequest;
  }

  /**
   * Creates an instance of DirectServiceRequest for Transaction History Advice request and sets all required and (available) optional information of request
   * required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequest
   * @implNote The required field values used in this tutorial are dummy values and for demo purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequest buildTransactionHistoryAdviceRequest() {
    DirectServiceRequest transactionHistoryAdviceRequest = new DirectServiceRequest();
    transactionHistoryAdviceRequest.setServiceType(ADVICE_SERVICE_TYPE);
    transactionHistoryAdviceRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    transactionHistoryAdviceRequest.setCustomer(customer);
    TokenRequest tokenRequest = new TokenRequest();
    tokenRequest.transactionId("fe8Rr7GWCOXCRaM6KNWDb/s4gyxalgQKt/M8L6BdndA=");
    CardRequest cardRequest = new CardRequest();
    cardRequest.accountNumber(ACCOUNT_NUMBER);
    cardRequest.setValidationCode("567");
    cardRequest.setCountry("840");
    cardRequest.setToken(new TokenRequest().type("C"));
    transactionHistoryAdviceRequest.setCard(cardRequest);
    TransactionRequest transactionRequest = new TransactionRequest();
    transactionRequest.setTransactionType("00");
    transactionRequest.setFromAccountType("00");
    transactionRequest.setToAccountType("00");
    transactionRequest.setPurpose(00L);
    transactionRequest.setTypeIdentifier("C01");
    transactionRequest.setAmount(000000050000L);
    transactionRequest.setCurrency("840");
    transactionRequest.setAdviceReasonCode("201");
    transactionHistoryAdviceRequest.setTransaction(transactionRequest);
    Terminal terminal = new Terminal();
    terminal.setPanEntryMode(PAN_ENTRY_MODE);
    transactionHistoryAdviceRequest.setTerminal(terminal);
    CardAcceptor cardAcceptor = new CardAcceptor();
    cardAcceptor.name("Walmart");
    getLocation(cardAcceptor);
    transactionHistoryAdviceRequest.setCardAcceptor(cardAcceptor);
    OriginalAuthorization originalRequest = new OriginalAuthorization();
    originalRequest.setMastercardReferenceId("123456789");
    TransactionRequest originalTransactionRequest = new TransactionRequest();
    originalTransactionRequest.setTransactionType("00");
    originalRequest.setTransaction(originalTransactionRequest);
    originalRequest.setResponseCode("00");
    originalRequest.setAuthorizationCode(AUTHORIZATION_CDOE);
    originalRequest.setMessageType("0110");
    List<Service> serviceList = new ArrayList();
    Service panService = new Service();
    panService.setCode("50");
    panService.setResult("C");
    Service chipValidationService = new Service();
    chipValidationService.setCode("51");
    chipValidationService.setResult("V");
    serviceList.add(panService);
    serviceList.add(chipValidationService);
    originalRequest.setServices(serviceList);
    transactionHistoryAdviceRequest.setOriginal(originalRequest);
    return transactionHistoryAdviceRequest;
  }

  /**
   * Creates an instance of DirectServiceRequest for Fraud Services Original request and sets all required and (available) optional information of request
   * required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequest
   * @implNote The required field values used in this tutorial are dummy values and for demo purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequest buildFraudServicesOriginalRequest() {
    DirectServiceRequest fraudServicesOriginalRequest = new DirectServiceRequest();
    fraudServicesOriginalRequest.setServiceType(ORIGINAL_SERVICE_TYPE);
    fraudServicesOriginalRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    fraudServicesOriginalRequest.setCustomer(customer);
    CardRequest cardRequest = new CardRequest();
    cardRequest.setAccountNumber(ACCOUNT_NUMBER);
    cardRequest.setValidationCode("567");
    cardRequest.setSequenceNumber("891");
    cardRequest.setCountry("840");
    cardRequest.setToken(new TokenRequest().type("C"));
    fraudServicesOriginalRequest.card(cardRequest);
    TransactionRequest transactionRequest = getTransactionRequest();
    fraudServicesOriginalRequest.setTransaction(transactionRequest);
    Terminal terminal = getTerminal();
    fraudServicesOriginalRequest.setTerminal(terminal);
    CardAcceptor cardAcceptor = getCardAcceptor();
    fraudServicesOriginalRequest.setCardAcceptor(cardAcceptor);

    SecurityRequest securityRequest = new SecurityRequest();
    securityRequest.setMagStripeTrack1Data(TRACK_DATA);
    securityRequest.setMagStripeTrack2Data(TRACK_DATA);
    securityRequest.setUniversalCardholderAuthenticationField(CHIP_DATA);
    securityRequest.setPinBlockFormat(PIN_BLOCK_FORMAT);
    securityRequest.setPinKeyIndex(98);
    fraudServicesOriginalRequest.setSecurity(securityRequest);
    AuthenticationRequest authenticationRequest = new AuthenticationRequest();
    authenticationRequest.setSecurityProtocol(9);
    authenticationRequest.setCardholderAuthentication(0);
    authenticationRequest.setUcafCollectionIndicator(0);
    authenticationRequest.setAvsResponseCode("P");
    authenticationRequest.setCvcResponseCode("M");
    fraudServicesOriginalRequest.authentication(authenticationRequest);

    OriginalAuthorization original = new OriginalAuthorization();
    original.setResponseCode("00");
    List<Service> services = new ArrayList<>();
    services.add(new Service().code("18C").result("C"));
    services.add(new Service().code("18C").result("U"));
    original.setSecurityServices(services);
    fraudServicesOriginalRequest.setOriginal(original);
    return fraudServicesOriginalRequest;
  }

  private static Terminal getTerminal() {
    Terminal terminal = new Terminal();
    terminal.setPanEntryMode(PAN_ENTRY_MODE);
    terminal.setPinEntryMode("0");
    terminal.setAttendance(0);
    terminal.setLocation(0);
    terminal.setCardholderPresence(0);
    terminal.setCardPresence(0);
    terminal.setCardCaptureCapabilities(0);
    terminal.setTransactionSecurity(0);
    terminal.setCardholderActivated(4);
    terminal.setCardDataInputCapability(2);
    terminal.setAuthorizationLifeCycle(0);
    terminal.setCountry("840");
    terminal.setPostalCode("63026");
    return terminal;
  }

  /**
   * Creates an instance of DirectServiceRequest for Fraud Services Advice request and sets all required and (available) optional information of request
   * required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequest
   * @implNote The required field values used in this tutorial are dummy values and for demo purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequest buildFraudServicesAdviceRequest() {
    DirectServiceRequest fraudServicesAdviceRequest = new DirectServiceRequest();
    fraudServicesAdviceRequest.setServiceType(ADVICE_SERVICE_TYPE);
    fraudServicesAdviceRequest.setClientTransactionId("03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU");

    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    fraudServicesAdviceRequest.setCustomer(customer);

    CardRequest cardRequest = new CardRequest();
    cardRequest.setAccountNumber(ACCOUNT_NUMBER);
    cardRequest.setValidationCode("567");
    cardRequest.setCountry("840");
    cardRequest.setToken(new TokenRequest().type("C"));
    fraudServicesAdviceRequest.card(cardRequest);

    TransactionRequest transactionRequest = new TransactionRequest();
    transactionRequest.setTransactionType("00");
    transactionRequest.setFromAccountType("00");
    transactionRequest.setToAccountType("00");
    transactionRequest.setPurpose(00L);
    transactionRequest.setTypeIdentifier("C01");
    transactionRequest.setAmount(000000050000L);
    transactionRequest.setCurrency("840");
    transactionRequest.setSettlementAmount(000000050000L);
    transactionRequest.setBillingAmount(000000050000L);
    transactionRequest.setCategory("T");
    transactionRequest.setAdviceReasonCode("201");
    transactionRequest.setPromotionCode("GREECE");
    transactionRequest.setCardholderVerificationMethod("P");
    fraudServicesAdviceRequest.setTransaction(transactionRequest);

    fraudServicesAdviceRequest.setTerminal(getTerminal());

    CardAcceptor cardAcceptor = new CardAcceptor();
    cardAcceptor.setMerchantType("5499");
    cardAcceptor.setTerminalId(ID);
    cardAcceptor.setAcquirerId(ACQUIRER_ID);
    cardAcceptor.setMerchantId(ID);
    cardAcceptor.setName("walmart");
    getLocation(cardAcceptor);
    fraudServicesAdviceRequest.setCardAcceptor(cardAcceptor);

    SecurityRequest securityRequest = new SecurityRequest();
    securityRequest.setMagStripeTrack2Data(TRACK_DATA);
    fraudServicesAdviceRequest.setSecurity(securityRequest);

    AuthenticationRequest authenticationRequest = new AuthenticationRequest();
    authenticationRequest.setCvcResponseCode("M");
    fraudServicesAdviceRequest.authentication(authenticationRequest);

    OriginalAuthorization originalAuthorization = new OriginalAuthorization();
    originalAuthorization.setResponseCode("00");
    originalAuthorization.setMastercardReferenceId("123456789");
    List<Service> services = new ArrayList<>();
    services.add(new Service().code("18").result("C"));
    services.add(new Service().code("18").result("U"));
    originalAuthorization.services(services);
    fraudServicesAdviceRequest.setOriginal(originalAuthorization);

    return fraudServicesAdviceRequest;
  }

  private static void getLocation(CardAcceptor cardAcceptor) {
    Location location = new Location();
    location.setCity("O'Fallon");
    location.setState("MO");
    location.setCountry("USA");
    cardAcceptor.setLocation(location);
  }
}
