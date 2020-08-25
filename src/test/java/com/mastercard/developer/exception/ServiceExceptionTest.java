package com.mastercard.developer.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openapitools.client.model.Error;
import org.openapitools.client.model.ErrorResponse;
import org.openapitools.client.model.Errors;

class ServiceExceptionTest {

    private static final String MESSAGE = "size must be 6 bytes";
    private static final String SOURCE = "network-access-services";
    private static final String REASON_CODE = "VALIDATION_ERROR";
    private static final String DESCRIPTION = "customer.id";

    @Test
    void testServiceExceptionMessage() {
        ServiceException exception = new ServiceException(MESSAGE);
        assertEquals(MESSAGE, exception.getMessage());
    }

    @Test
    void testServiceExceptionThrowable() {
        try {
            throwException();
        } catch (ServiceException e) {
            Assertions.assertAll(
                    () -> assertEquals(MESSAGE, e.getMessage()),
                    () -> {
                        Errors errors = e.getServiceErrors();
                        assertNotNull(errors);
                        List<Error> errorList = errors.getErrors().getError();
                        assertFalse(errorList.isEmpty());
                        errorList.forEach(error -> {
                            assertEquals(SOURCE, error.getSource());
                            assertEquals(REASON_CODE, error.getReasonCode());
                            assertEquals(DESCRIPTION, error.getDescription());
                            Assertions.assertFalse(error::getRecoverable);
                        });
                    }
            );
        }
    }

    private void throwException() throws ServiceException {
        throw new ServiceException(MESSAGE, getCustomError());
    }

    private Errors getCustomError() {
        Error error = new Error();
        error.source(SOURCE).reasonCode(REASON_CODE).description(DESCRIPTION).recoverable(false);
        ErrorResponse errorList = new ErrorResponse();
        errorList.addErrorItem(error);
        return new Errors().errors(errorList);
    }
}
