package com.mastercard.developer.executor;

import com.mastercard.developer.example.DirectServicesExample;
import com.mastercard.developer.exception.ServiceException;
import com.mastercard.developer.service.DSAService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openapitools.client.model.CardRequest;
import org.openapitools.client.model.Customer;
import org.openapitools.client.model.DirectServiceRequest;
import org.openapitools.client.model.DirectServiceResponse;
import org.openapitools.client.model.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ServicesExecutor {

  private DSAService dsaService;

  @Autowired
  public ServicesExecutor(DSAService dsaService) {
    this.dsaService = dsaService;
  }

  public void execute() throws ServiceException {
    log.info("<<<---- DIRECT SERVICES ACCESS API EXECUTION STARTED ---->>>");

    log.info("<-- SENDING ALL FIELDS/COMBINED REQUEST -->");
    combinedRequest();
    log.info("<-- COMPLETED ALL FIELDS/COMBINED REQUEST -->");

    log.info("<-- SENDING E-COMMERCE REQUEST -->");
    eCommerceRequest();
    log.info("<-- COMPLETED E-COMMERCE REQUEST -->");

    log.info("<-- SENDING IN-PERSON REQUEST -->");
    inPersonRequest();
    log.info("<-- COMPLETED IN-PERSON REQUEST -->");

    log.info("<-- SENDING REVERSAL REQUEST -->");
    reversalRequest();
    log.info("<-- COMPLETED REVERSAL REQUEST -->");

    log.info("<-- SENDING ACQUIRER ADVICE REQUEST -->");
    acquirerAdviceRequest();
    log.info("<-- COMPLETED ACQUIRER ADVICE REQUEST -->");

    log.info("<-- SENDING TRANSACTION HISTORY ADVICE REQUEST -->");
    transactionHistoryAdviceRequest();
    log.info("<-- COMPLETED TRANSACTION HISTORY ADVICE REQUEST -->");

    log.info("<-- SENDING FRAUD SERVICES ORIGINAL REQUEST -->");
    fraudServicesOriginalRequest();
    log.info("<-- COMPLETED FRAUD SERVICES ORIGINAL REQUEST -->");

    log.info("<-- SENDING FRAUD SERVICES ADVICE REQUEST -->");
    fraudServicesAdviceRequest();
    log.info("<-- COMPLETED FRAUD SERVICES ADVICE REQUEST -->");

    log.info("<-- CALLING ERROR HANDLING SCENARIO -->");
    errorHandling();
    log.info("<-- COMPLETED ERROR HANDLING SCENARIO -->");

    log.info("<<<---- DIRECT SERVICES ACCESS API EXECUTION COMPLETED ---->>>");
  }

  /**
   * USE CASE 1: ALL FIELDS/COMBINED
   * User performs an API request with a combination of fields from different use cases below to execute multiple use cases simultaneously.
   *
   * @return An instance of DirectServiceResponse
   */
  private DirectServiceResponse combinedRequest() throws ServiceException {
    return dsaService.getResponse(DirectServicesExample.buildAllFieldsRequest());
  }

  /**
   * USE CASE 2: E-COMMERCE
   * User performs an API request for a transaction using a digital token online, not in person.
   *
   * @return An instance of DirectServiceResponse
   */
  private DirectServiceResponse eCommerceRequest() throws ServiceException {
    return dsaService.getResponse(DirectServicesExample.buildEcommerceRequest());
  }

  /**
   * USE CASE 3: IN-PERSON
   * User performs an API request for a transaction using a digital token in person.
   *
   * @return An instance of DirectServiceResponse
   */
  private DirectServiceResponse inPersonRequest() throws ServiceException {
    return dsaService.getResponse(DirectServicesExample.buildInPersonRequest());
  }

  /**
   * USE CASE 4: REVERSAL
   * User performs an API request for a reversal of an API request previously made.
   *
   * @return An instance of DirectServiceResponse
   */
  private DirectServiceResponse reversalRequest() throws ServiceException {
    return dsaService.getResponse(DirectServicesExample.buildReversalRequest());
  }

  /**
   * USE CASE 5: ACQUIRER ADVICE
   * User performs an API request to gather advice about a previous authorization that was made.
   *
   * @return An instance of DirectServiceResponse
   */
  private DirectServiceResponse acquirerAdviceRequest() throws ServiceException {
    return dsaService.getResponse(DirectServicesExample.buildAcquirerAdviceRequest());
  }

  /**
   * USE CASE 6: TRANSACTION HISTORY ADVICE
   * User performs an API request to gather advice about a previous transaction that was made.
   *
   * @return An instance of DirectServiceResponse
   */
  private DirectServiceResponse transactionHistoryAdviceRequest() throws ServiceException {
    return dsaService.getResponse(DirectServicesExample.buildTransactionHistoryAdviceRequest());
  }

  /**
   * USE CASE 7: FRAUD SERVICES ORIGINAL
   * User performs an API request to request Mastercard fraud services to be performed for a particular transaction.
   *
   * @return An instance of DirectServiceResponse
   */
  private DirectServiceResponse fraudServicesOriginalRequest() throws ServiceException {
    return dsaService.getResponse(DirectServicesExample.buildFraudServicesOriginalRequest());
  }

  /**
   * USE CASE 8: FRAUD SERVICES ADVICE
   * User performs an API request to gather advice about a previous fraud services original request (use case above) that was made.
   *
   * @return An instance of DirectServiceResponse
   */
  private DirectServiceResponse fraudServicesAdviceRequest() throws ServiceException {
    return dsaService.getResponse(DirectServicesExample.buildFraudServicesAdviceRequest());
  }

  /**
   * USE CASE 9: ERROR HANDLING
   * Requests can fail for various reasons, this scenario is added so that you should know what to expect when there is a failure.
   */
  private void errorHandling() {
    DirectServiceRequest errorRequest = new DirectServiceRequest();

    errorRequest.setServiceType("ORIGINAL");
    Customer customer = new Customer();
    customer.setId("567899");
    errorRequest.setCustomer(customer);
    CardRequest card = new CardRequest();
    // Intentionally setting this value to show exception handling scenario.
    card.setAccountNumber(null);
    errorRequest.setCard(card);

    try {
      dsaService.getResponse(errorRequest);
    } catch (ServiceException e) {
      List<Error> errorList = e.getServiceErrors().getErrors().getError();
      Assertions.assertFalse(errorList.isEmpty());
      errorList.forEach(error -> {
        Assertions.assertEquals("network-access-services", error.getSource());
        Assertions.assertEquals("VALIDATION_ERROR", error.getReasonCode());
        log.error("Failed to send request in Error Handling Scenario. Field that caused validation issue: {}", error.getDescription());
      });
    }
  }
}
