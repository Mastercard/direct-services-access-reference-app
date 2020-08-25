package com.mastercard.developer.service;

import com.mastercard.developer.exception.ServiceException;
import org.openapitools.client.model.DirectServiceRequest;
import org.openapitools.client.model.DirectServiceResponse;

public interface DSAService {
  DirectServiceResponse getResponse(DirectServiceRequest directServiceRequest)
      throws ServiceException;
}
