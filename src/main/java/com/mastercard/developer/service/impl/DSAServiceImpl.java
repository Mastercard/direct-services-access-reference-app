package com.mastercard.developer.service.impl;

import com.mastercard.developer.exception.ServiceException;
import com.mastercard.developer.service.DSAService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.JSON;
import org.openapitools.client.api.DirectServicesApi;
import org.openapitools.client.model.DirectServiceRequest;
import org.openapitools.client.model.DirectServiceResponse;
import org.openapitools.client.model.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DSAServiceImpl implements DSAService {

  private DirectServicesApi directServicesApi;

  @Autowired
  public DSAServiceImpl(ApiClient apiClient) {
    log.info("-->> INITIALIZING ACCOUNT API");
    directServicesApi = new DirectServicesApi(apiClient);
  }

  /**
   * getResponse processes the DirectService request and returns the DirectService response
   * URL: /services
   * Method: POST
   * Success Response: 200
   * Error Response: 4XX or 5XX
   *
   * @param directServiceRequest DirectServiceRequest
   * @return An instance of DirectServiceResponse
   */
  public DirectServiceResponse getResponse(DirectServiceRequest directServiceRequest)
      throws ServiceException {
    try {
      log.info("<-- CALLING DIRECT SERVICES ENDPOINT -->");
      DirectServiceResponse directServiceResponse = directServicesApi.servicesPost(directServiceRequest);
      Assertions.assertNotNull(directServiceResponse, "Missing object 'directServiceResponse' when calling servicesPost(Async)");
      log.info("<-- DIRECT SERVICES TRANSACTION SUCCESSFULLY -->");
      return directServiceResponse;
    } catch (ApiException e) {
      log.error("<<-- DIRECT SERVICES TRANSACTION FAILED -->>");
      throw new ServiceException(e.getMessage(), deserializeErrors(e.getResponseBody()));
    }
  }

  private Errors deserializeErrors(String body) {
    return new JSON().deserialize(body, Errors.class);
  }
}
