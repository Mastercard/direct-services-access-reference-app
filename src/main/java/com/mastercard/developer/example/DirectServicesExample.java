package com.mastercard.developer.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openapitools.client.model.AdditionalAmountsRequestDetails;
import org.openapitools.client.model.AlmRequestDetails;
import org.openapitools.client.model.AuthenticationRequestDetails;
import org.openapitools.client.model.CardAcceptor;
import org.openapitools.client.model.CardRequestDetails;
import org.openapitools.client.model.Customer;
import org.openapitools.client.model.DigitalPaymentRequestDetails;
import org.openapitools.client.model.DirectServiceRequestDetails;
import org.openapitools.client.model.Location;
import org.openapitools.client.model.OriginalAuthorization;
import org.openapitools.client.model.SecurityRequestDetails;
import org.openapitools.client.model.Service;
import org.openapitools.client.model.Terminal;
import org.openapitools.client.model.TokenRequestDetails;
import org.openapitools.client.model.TransactionRequestDetails;
import org.openapitools.client.model.Wallet;

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
  public static final String AUTHORIZATION_CODE = "123456";
  public static final String ACQUIRER_ID = "123456";
  public static final Integer PURPOSE_EXTENDED = 2;

  /**
   * Creates an instance of DirectServiceRequestDetails for a combined request with multiple use
   * cases (in this case E-Commerce and Fraud Services Original use cases) and sets all required
   * and (available) optional information of request required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequestDetails
   * @implNote The required field values used in this tutorial are dummy values and for demo
   *     purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequestDetails buildAllFieldsRequest() {
    DirectServiceRequestDetails combinedRequest = new DirectServiceRequestDetails();
    combinedRequest.setServiceType(ORIGINAL_SERVICE_TYPE);
    combinedRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);

    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    combinedRequest.setCustomer(customer);

    CardRequestDetails cardRequest = new CardRequestDetails();
    cardRequest.setAccountNumber(ACCOUNT_NUMBER);
    cardRequest.setValidationCode("567");
    cardRequest.setSequenceNumber("891");
    cardRequest.setCountry("840");
    cardRequest.setToken(
        new TokenRequestDetails().transactionId("fe8Rr7GWCOXCRaM6KNWDb/s4gyxalgQKt/M8L6BdndA=").type("C"));
    cardRequest.setAlm(getAlmRequestDetails());
    combinedRequest.card(cardRequest);

    Wallet wallet = new Wallet();
    wallet.setId("101");
    combinedRequest.wallet(wallet);

    TransactionRequestDetails transactionRequest = getTransactionRequest();
    combinedRequest.setTransaction(transactionRequest);

    combinedRequest.setTerminal(getTerminal());

    CardAcceptor cardAcceptor = getCardAcceptor();
    combinedRequest.setCardAcceptor(cardAcceptor);

    SecurityRequestDetails securityRequest = new SecurityRequestDetails();
    securityRequest.setMagStripeTrack1Data(TRACK_DATA);
    securityRequest.setMagStripeTrack2Data(TRACK_DATA);
    securityRequest.setUniversalCardholderAuthenticationField(CHIP_DATA);
    securityRequest.setPinBlockFormat(PIN_BLOCK_FORMAT);
    securityRequest.setPinKeyIndex(98);
    combinedRequest.setSecurity(securityRequest);

    AuthenticationRequestDetails authenticationRequest = new AuthenticationRequestDetails();
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
    cardAcceptor.setMerchantType("5499");
    cardAcceptor.setAssignedId("786RGF");
    cardAcceptor.setPaymentFacilitatorId("987898");
    cardAcceptor.setSalesOrgId("456723");
    cardAcceptor.setSubMerchantId("BOA568");
    cardAcceptor.name("Walmart");
    getLocation(cardAcceptor);
    return cardAcceptor;
  }

  private static TransactionRequestDetails getTransactionRequest() {
    TransactionRequestDetails transactionRequest = new TransactionRequestDetails();
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
    transactionRequest.setAdditionalAmounts(getAdditionalAmounts());
    transactionRequest.setPurposeExtended(PURPOSE_EXTENDED);
    return transactionRequest;
  }

  private static AdditionalAmountsRequestDetails getAdditionalAmounts() {
    AdditionalAmountsRequestDetails additionalAmounts = new AdditionalAmountsRequestDetails();
    additionalAmounts.setAccountType(0);
    additionalAmounts.setAmountType(AdditionalAmountsRequestDetails.AmountTypeEnum._57);
    additionalAmounts.setCurrencyCode(840);
    additionalAmounts.setAmountIndicator("C");
    additionalAmounts.setAmount(50000);
    return additionalAmounts;
  }

  private static AlmRequestDetails getAlmRequestDetails() {
    AlmRequestDetails almRequestDetails = new AlmRequestDetails();
    almRequestDetails.setCredentialExclusionIndicator(
        AlmRequestDetails.CredentialExclusionIndicatorEnum.DEBIT);
    almRequestDetails.setAccountNumberIndicator("1");
    almRequestDetails.setAccountNumber(ACCOUNT_NUMBER);
    almRequestDetails.setAccountNumberExpiry("2028-12-31");
    return almRequestDetails;
  }

  /**
   * Creates an instance of DirectServiceRequestDetails for Ecommerce request and sets all required
   * and (available) optional information of request required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequestDetails
   * @implNote The required field values used in this tutorial are dummy values and for demo
   *     purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequestDetails buildEcommerceRequest() {
    DirectServiceRequestDetails eCommerceRequest = new DirectServiceRequestDetails();
    eCommerceRequest.setServiceType(ORIGINAL_SERVICE_TYPE);
    eCommerceRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    eCommerceRequest.setCustomer(customer);
    CardRequestDetails cardRequest = new CardRequestDetails();
    cardRequest.accountNumber(ACCOUNT_NUMBER);
    cardRequest.setValidationCode("567");
    cardRequest.setSequenceNumber("891");
    cardRequest.setAlm(getAlmRequestDetails());
    eCommerceRequest.card(cardRequest);
    Wallet wallet = new Wallet();
    wallet.setId("101");
    eCommerceRequest.wallet(wallet);
    TransactionRequestDetails transactionRequest = new TransactionRequestDetails();
    transactionRequest.setTransactionType("00");
    transactionRequest.setFromAccountType("20");
    transactionRequest.setToAccountType("20");
    transactionRequest.setAdditionalAmounts(getAdditionalAmounts());
    transactionRequest.setPurposeExtended(PURPOSE_EXTENDED);
    eCommerceRequest.setTransaction(transactionRequest);
    Terminal terminal = new Terminal();
    terminal.setPanEntryMode(PAN_ENTRY_MODE);
    eCommerceRequest.setTerminal(terminal);
    CardAcceptor cardAcceptor = new CardAcceptor();
    cardAcceptor.setMerchantType("5499");
    cardAcceptor.setAssignedId("786RGF");
    cardAcceptor.setPaymentFacilitatorId("987898");
    cardAcceptor.setSalesOrgId("456723");
    cardAcceptor.setSubMerchantId("BOA568");
    eCommerceRequest.setCardAcceptor(cardAcceptor);
    SecurityRequestDetails securityRequest = new SecurityRequestDetails();
    securityRequest.setUniversalCardholderAuthenticationField(CHIP_DATA);
    securityRequest.setPinBlockFormat(PIN_BLOCK_FORMAT);
    securityRequest.setPinKeyIndex(98);
    DigitalPaymentRequestDetails digitalPaymentRequest = new DigitalPaymentRequestDetails();
    securityRequest.setDigitalPayment(digitalPaymentRequest);
    eCommerceRequest.setSecurity(securityRequest);

    AuthenticationRequestDetails authenticationRequest = new AuthenticationRequestDetails();
    authenticationRequest.setSecurityProtocol(9);
    authenticationRequest.setCardholderAuthentication(0);
    authenticationRequest.setUcafCollectionIndicator(0);

    eCommerceRequest.authentication(authenticationRequest);
    return eCommerceRequest;
  }

  /**
   * Creates an instance of DirectServiceRequestDetails for InPerson request and sets all required
   * and (available) optional information of request required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequestDetails
   * @implNote The required field values used in this tutorial are dummy values and for demo
   *     purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequestDetails buildInPersonRequest() {
    DirectServiceRequestDetails inPersonRequest = new DirectServiceRequestDetails();
    inPersonRequest.setServiceType(ORIGINAL_SERVICE_TYPE);
    inPersonRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    inPersonRequest.setCustomer(customer);
    CardRequestDetails cardRequest = new CardRequestDetails();
    cardRequest.setAccountNumber(ACCOUNT_NUMBER);
    cardRequest.setSequenceNumber("891");
    cardRequest.setAlm(getAlmRequestDetails());
    inPersonRequest.card(cardRequest);
    inPersonRequest.setTerminal(new Terminal().panEntryMode(PAN_ENTRY_MODE));
    inPersonRequest.setCardAcceptor(new CardAcceptor().merchantType("5499"));
    inPersonRequest.setSecurity(
        new SecurityRequestDetails().magStripeTrack1Data(TRACK_DATA).magStripeTrack2Data(TRACK_DATA));
    return inPersonRequest;
  }

  /**
   * Creates an instance of DirectServiceRequestDetails for Reversal request and sets all required
   * and (available) optional information of request required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequestDetails
   * @implNote The required field values used in this tutorial are dummy values and for demo
   *     purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequestDetails buildReversalRequest() {
    DirectServiceRequestDetails reversalRequest = new DirectServiceRequestDetails();
    reversalRequest.setServiceType("REVERSAL");
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    reversalRequest.setCustomer(customer);
    CardRequestDetails card = new CardRequestDetails();
    card.setAccountNumber(ACCOUNT_NUMBER);
    reversalRequest.setCard(card);
    TransactionRequestDetails transaction = new TransactionRequestDetails();
    transaction.setAmount(123L);
    transaction.setCurrency("840");
    transaction.setAdditionalAmounts(getAdditionalAmounts());
    transaction.setPurposeExtended(PURPOSE_EXTENDED);
    reversalRequest.setTransaction(transaction);
    OriginalAuthorization authorization = new OriginalAuthorization();
    authorization.setResponseCode("00");
    reversalRequest.setOriginal(authorization);
    return reversalRequest;
  }

  /**
   * Creates an instance of DirectServiceRequestDetails for Acquirer Advice request and sets all
   * required and (available) optional information of request required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequestDetails
   * @implNote The required field values used in this tutorial are dummy values and for demo
   *     purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequestDetails buildAcquirerAdviceRequest() {
    DirectServiceRequestDetails acquirerAdviceRequest = new DirectServiceRequestDetails();
    acquirerAdviceRequest.setServiceType(ADVICE_SERVICE_TYPE);
    acquirerAdviceRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    acquirerAdviceRequest.setCustomer(customer);
    CardRequestDetails cardRequest = new CardRequestDetails();
    cardRequest.setAccountNumber(ACCOUNT_NUMBER);
    cardRequest.setAlm(getAlmRequestDetails());
    acquirerAdviceRequest.card(cardRequest);
    TransactionRequestDetails transactionRequest = new TransactionRequestDetails();
    transactionRequest.setAmount(0000000050000L);
    transactionRequest.setCurrency("840");
    transactionRequest.setAdviceReasonCode("190");
    transactionRequest.setAdditionalAmounts(getAdditionalAmounts());
    transactionRequest.setPurposeExtended(PURPOSE_EXTENDED);
    acquirerAdviceRequest.setTransaction(transactionRequest);
    OriginalAuthorization original = new OriginalAuthorization();
    original.setResponseCode("00");
    acquirerAdviceRequest.setOriginal(original);
    return acquirerAdviceRequest;
  }

  /**
   * Creates an instance of DirectServiceRequestDetails for Transaction History Advice request and
   * sets all required and (available) optional information of request required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequestDetails
   * @implNote The required field values used in this tutorial are dummy values and for demo
   *     purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequestDetails buildTransactionHistoryAdviceRequest() {
    DirectServiceRequestDetails transactionHistoryAdviceRequest = new DirectServiceRequestDetails();
    transactionHistoryAdviceRequest.setServiceType(ADVICE_SERVICE_TYPE);
    transactionHistoryAdviceRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    transactionHistoryAdviceRequest.setCustomer(customer);
    TokenRequestDetails tokenRequest = new TokenRequestDetails();
    tokenRequest.transactionId("fe8Rr7GWCOXCRaM6KNWDb/s4gyxalgQKt/M8L6BdndA=");
    CardRequestDetails cardRequest = new CardRequestDetails();
    cardRequest.accountNumber(ACCOUNT_NUMBER);
    cardRequest.setValidationCode("567");
    cardRequest.setCountry("840");
    cardRequest.setToken(new TokenRequestDetails().type("C"));
    cardRequest.setAlm(getAlmRequestDetails());
    transactionHistoryAdviceRequest.setCard(cardRequest);
    TransactionRequestDetails transactionRequest = new TransactionRequestDetails();
    transactionRequest.setTransactionType("00");
    transactionRequest.setFromAccountType("00");
    transactionRequest.setToAccountType("00");
    transactionRequest.setPurpose(00L);
    transactionRequest.setTypeIdentifier("C01");
    transactionRequest.setAmount(000000050000L);
    transactionRequest.setCurrency("840");
    transactionRequest.setAdviceReasonCode("201");
    transactionRequest.setAdditionalAmounts(getAdditionalAmounts());
    transactionRequest.setPurposeExtended(PURPOSE_EXTENDED);
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
    TransactionRequestDetails originalTransactionRequest = new TransactionRequestDetails();
    originalTransactionRequest.setTransactionType("00");
    originalRequest.setTransaction(originalTransactionRequest);
    originalRequest.setResponseCode("00");
    originalRequest.setAuthorizationCode(AUTHORIZATION_CODE);
    originalRequest.setMessageType("0110");
    List<Service> serviceList = new ArrayList<>();
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
   * Creates an instance of DirectServiceRequestDetails for Fraud Services Original request and sets
   * all required and (available) optional information of request required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequestDetails
   * @implNote The required field values used in this tutorial are dummy values and for demo
   *     purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequestDetails buildFraudServicesOriginalRequest() {
    DirectServiceRequestDetails fraudServicesOriginalRequest = new DirectServiceRequestDetails();
    fraudServicesOriginalRequest.setServiceType(ORIGINAL_SERVICE_TYPE);
    fraudServicesOriginalRequest.setClientTransactionId(CLIENT_TRANSACTION_ID);
    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    fraudServicesOriginalRequest.setCustomer(customer);
    CardRequestDetails cardRequest = new CardRequestDetails();
    cardRequest.setAccountNumber(ACCOUNT_NUMBER);
    cardRequest.setValidationCode("567");
    cardRequest.setSequenceNumber("891");
    cardRequest.setCountry("840");
    cardRequest.setToken(new TokenRequestDetails().type("C"));
    cardRequest.setAlm(getAlmRequestDetails());
    fraudServicesOriginalRequest.card(cardRequest);
    TransactionRequestDetails transactionRequest = getTransactionRequest();
    fraudServicesOriginalRequest.setTransaction(transactionRequest);
    Terminal terminal = getTerminal();
    fraudServicesOriginalRequest.setTerminal(terminal);
    CardAcceptor cardAcceptor = getCardAcceptor();
    fraudServicesOriginalRequest.setCardAcceptor(cardAcceptor);

    SecurityRequestDetails securityRequest = new SecurityRequestDetails();
    securityRequest.setMagStripeTrack1Data(TRACK_DATA);
    securityRequest.setMagStripeTrack2Data(TRACK_DATA);
    securityRequest.setUniversalCardholderAuthenticationField(CHIP_DATA);
    securityRequest.setPinBlockFormat(PIN_BLOCK_FORMAT);
    securityRequest.setPinKeyIndex(98);
    fraudServicesOriginalRequest.setSecurity(securityRequest);
    AuthenticationRequestDetails authenticationRequest = new AuthenticationRequestDetails();
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
   * Creates an instance of DirectServiceRequestDetails for Fraud Services Advice request and sets
   * all required and (available) optional information of request required:
   * - serviceType
   * - accountNumber
   * - customer.id
   *
   * @return An instance of DirectServiceRequestDetails
   * @implNote The required field values used in this tutorial are dummy values and for demo
   *     purposes only, please change to valid values before running this application.
   */
  public static DirectServiceRequestDetails buildFraudServicesAdviceRequest() {
    DirectServiceRequestDetails fraudServicesAdviceRequest = new DirectServiceRequestDetails();
    fraudServicesAdviceRequest.setServiceType(ADVICE_SERVICE_TYPE);
    fraudServicesAdviceRequest.setClientTransactionId("03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU");

    Customer customer = new Customer();
    customer.setId(CUSTOMER_ID);
    fraudServicesAdviceRequest.setCustomer(customer);

    CardRequestDetails cardRequest = new CardRequestDetails();
    cardRequest.setAccountNumber(ACCOUNT_NUMBER);
    cardRequest.setValidationCode("567");
    cardRequest.setCountry("840");
    cardRequest.setToken(new TokenRequestDetails().type("C"));
    cardRequest.setAlm(getAlmRequestDetails());
    fraudServicesAdviceRequest.card(cardRequest);

    TransactionRequestDetails transactionRequest = new TransactionRequestDetails();
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
    transactionRequest.setAdditionalAmounts(getAdditionalAmounts());
    transactionRequest.setPurposeExtended(PURPOSE_EXTENDED);
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

    SecurityRequestDetails securityRequest = new SecurityRequestDetails();
    securityRequest.setMagStripeTrack2Data(TRACK_DATA);
    fraudServicesAdviceRequest.setSecurity(securityRequest);

    AuthenticationRequestDetails authenticationRequest = new AuthenticationRequestDetails();
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
