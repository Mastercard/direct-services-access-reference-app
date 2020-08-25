package com.mastercard.developer.executor;

import com.mastercard.developer.exception.ServiceException;
import com.mastercard.developer.service.DSAService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicesExecutorTest {

  @InjectMocks
  ServicesExecutor servicesExecutor;

  @Mock
  private DSAService dsaService;

  @Test
  public void executeTest() throws ServiceException {
    servicesExecutor.execute();
  }
}
