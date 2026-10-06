package com.mastercard.developer.service;

import com.mastercard.developer.exception.ServiceException;
import org.openapitools.client.model.DirectServiceRequestDetails;
import org.openapitools.client.model.DirectServiceResponseDetails;

public interface DSAService {
  DirectServiceResponseDetails getResponse(DirectServiceRequestDetails directServiceRequest)
      throws ServiceException;
}
