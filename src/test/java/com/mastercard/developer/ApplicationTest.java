package com.mastercard.developer;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import com.mastercard.developer.exception.ServiceException;
import com.mastercard.developer.executor.ServicesExecutor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.client.model.Error;
import org.openapitools.client.model.ErrorResponse;
import org.openapitools.client.model.Errors;

@ExtendWith(MockitoExtension.class)
class ApplicationTest {

    @InjectMocks
    private Application application;

    @Mock
    private ServicesExecutor servicesExecutor;

    @Test
    void testRun() throws ServiceException {
        doNothing().when(servicesExecutor).execute();

        application.run();

        verify(servicesExecutor, atMostOnce()).execute();
    }

    @Test
    void test1Run() throws Exception {
        String MESSAGE = "size must be 6 bytes";
        doThrow(new ServiceException(MESSAGE, getCustomError())).when(servicesExecutor).execute();

        application.run();

        verify(servicesExecutor, atMostOnce()).execute();
    }
    private Errors getCustomError() {
        String SOURCE = "network-access-services";
        String REASON_CODE = "VALIDATION_ERROR";
        String DESCRIPTION = "customer.id";
        Error error = new Error();
        error.source(SOURCE).reasonCode(REASON_CODE).description(DESCRIPTION).recoverable(false);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.addErrorItem(error);
        return new Errors().errors(errorResponse);
    }
}
