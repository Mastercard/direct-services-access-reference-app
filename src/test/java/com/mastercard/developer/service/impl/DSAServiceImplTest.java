package com.mastercard.developer.service.impl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mastercard.developer.example.DirectServicesExample;
import com.mastercard.developer.response.MockDSAResponse;
import java.lang.reflect.Type;
import java.util.HashMap;
import okhttp3.Call;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.model.DirectServiceResponse;

@ExtendWith(MockitoExtension.class)
public class DSAServiceImplTest {

  @InjectMocks
  private DSAServiceImpl dsaService;

  @Mock
  private ApiClient apiClient;

  @BeforeEach
  void setUp() throws Exception {
    when(apiClient.buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any())).thenReturn(mock(
        Call.class));
  }

  @Test
  void testCombined() throws Exception {
    when(apiClient.execute(any(Call.class), any(Type.class))).thenReturn(new ApiResponse<>(201, new HashMap<>(),
        MockDSAResponse.getCombinedResponse()));

    DirectServiceResponse combinedResponse = dsaService.getResponse(DirectServicesExample.buildAllFieldsRequest());

    verify(apiClient, atMostOnce()).buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any());
    verify(apiClient, atMostOnce()).execute(any(Call.class), any(Type.class));

    assertAll(
        () -> assertNotNull(combinedResponse),
        () -> assertEquals(MockDSAResponse.RESPONSE_CODE, combinedResponse.getResponse().getResponseCode()),
        () -> assertEquals(MockDSAResponse.MASTERCARD_REFERENCE_ID, combinedResponse.getResponse().getMastercardReferenceId()),
        () -> assertEquals(MockDSAResponse.CLIENT_TRANSACTION_ID, combinedResponse.getResponse().getClientTransactionId()),
        () -> assertEquals(MockDSAResponse.ACCOUNT_NUMBER, combinedResponse.getResponse().getCard().getAccountNumber()),
        () -> assertEquals(new String(MockDSAResponse.MERCHANT_ID), new String(combinedResponse.getResponse().getSecurity().getDigitalPayment().getMerchantId())),
        () -> assertEquals("50", combinedResponse.getResponse().getServices().get(0).getCode()),
        () -> assertEquals("C", combinedResponse.getResponse().getServices().get(0).getResult()),
        () -> assertEquals("51", combinedResponse.getResponse().getServices().get(1).getCode()),
        () -> assertEquals("V", combinedResponse.getResponse().getServices().get(1).getResult()),
        () -> assertEquals("18", combinedResponse.getResponse().getSecurityServices().get(0).getCode()),
        () -> assertEquals("C", combinedResponse.getResponse().getSecurityServices().get(0).getResult()),
        () -> assertEquals("18", combinedResponse.getResponse().getSecurityServices().get(1).getCode()),
        () -> assertEquals("U", combinedResponse.getResponse().getSecurityServices().get(1).getResult()),
        () -> assertEquals(9, combinedResponse.getResponse().getAuthentication().getSecurityProtocol()),
        () -> assertEquals(0, combinedResponse.getResponse().getAuthentication().getCardholderAuthentication()),
        () -> assertEquals(0, combinedResponse.getResponse().getAuthentication().getUcafCollectionIndicator())
    );
  }

  @Test
  void testECommerce() throws Exception {
    when(apiClient.execute(any(Call.class), any(Type.class))).thenReturn(new ApiResponse<>(201, new HashMap<>(),
        MockDSAResponse.getECommerceResponse()));

    DirectServiceResponse eCommerceResponse = dsaService.getResponse(DirectServicesExample.buildEcommerceRequest());

    verify(apiClient, atMostOnce()).buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any());
    verify(apiClient, atMostOnce()).execute(any(Call.class), any(Type.class));

    assertAll(
        () -> assertNotNull(eCommerceResponse),
        () -> assertEquals(MockDSAResponse.RESPONSE_CODE, eCommerceResponse.getResponse().getResponseCode()),
        () -> assertEquals(MockDSAResponse.MASTERCARD_REFERENCE_ID, eCommerceResponse.getResponse().getMastercardReferenceId()),
        () -> assertEquals(MockDSAResponse.CLIENT_TRANSACTION_ID, eCommerceResponse.getResponse().getClientTransactionId()),
        () -> assertEquals(MockDSAResponse.ACCOUNT_NUMBER, eCommerceResponse.getResponse().getCard().getAccountNumber()),
        () -> assertEquals(9, eCommerceResponse.getResponse().getAuthentication().getSecurityProtocol()),
        () -> assertEquals(0, eCommerceResponse.getResponse().getAuthentication().getCardholderAuthentication()),
        () -> assertEquals(0, eCommerceResponse.getResponse().getAuthentication().getUcafCollectionIndicator())
    );
  }

  @Test
  void testInPerson() throws Exception {
    when(apiClient.execute(any(Call.class), any(Type.class))).thenReturn(new ApiResponse<>(201, new HashMap<>(),
        MockDSAResponse.getInPersonResponse()));

    DirectServiceResponse inPersonResponse = dsaService.getResponse(DirectServicesExample.buildInPersonRequest());

    verify(apiClient, atMostOnce()).buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any());
    verify(apiClient, atMostOnce()).execute(any(Call.class), any(Type.class));

    assertAll(
        () -> assertNotNull(inPersonResponse),
        () -> assertEquals(MockDSAResponse.RESPONSE_CODE, inPersonResponse.getResponse().getResponseCode()),
        () -> assertEquals(MockDSAResponse.MASTERCARD_REFERENCE_ID, inPersonResponse.getResponse().getMastercardReferenceId()),
        () -> assertEquals(MockDSAResponse.CLIENT_TRANSACTION_ID, inPersonResponse.getResponse().getClientTransactionId()),
        () -> assertEquals(MockDSAResponse.ACCOUNT_NUMBER, inPersonResponse.getResponse().getCard().getAccountNumber())
    );
  }

  @Test
  void testReversal() throws Exception {
    when(apiClient.execute(any(Call.class), any(Type.class))).thenReturn(new ApiResponse<>(201, new HashMap<>(),
        MockDSAResponse.getReversalResponse()));

    DirectServiceResponse reversalResponse = dsaService.getResponse(DirectServicesExample.buildReversalRequest());

    verify(apiClient, atMostOnce()).buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any());
    verify(apiClient, atMostOnce()).execute(any(Call.class), any(Type.class));

    assertAll(
        () -> assertNotNull(reversalResponse),
        () -> assertEquals(MockDSAResponse.RESPONSE_CODE, reversalResponse.getResponse().getResponseCode()),
        () -> assertEquals(MockDSAResponse.MASTERCARD_REFERENCE_ID, reversalResponse.getResponse().getMastercardReferenceId()),
        () -> assertEquals(MockDSAResponse.ACCOUNT_NUMBER, reversalResponse.getResponse().getCard().getAccountNumber())
    );
  }

  @Test
  void testAcquirerAdvice() throws Exception {
    when(apiClient.execute(any(Call.class), any(Type.class))).thenReturn(new ApiResponse<>(201, new HashMap<>(),
        MockDSAResponse.getAcquirerAdviceResponse()));

    DirectServiceResponse acquirerAdviceResponse = dsaService.getResponse(DirectServicesExample.buildAcquirerAdviceRequest());

    verify(apiClient, atMostOnce()).buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any());
    verify(apiClient, atMostOnce()).execute(any(Call.class), any(Type.class));

    assertAll(
        () -> assertNotNull(acquirerAdviceResponse),
        () -> assertEquals(MockDSAResponse.RESPONSE_CODE, acquirerAdviceResponse.getResponse().getResponseCode()),
        () -> assertEquals(MockDSAResponse.MASTERCARD_REFERENCE_ID, acquirerAdviceResponse.getResponse().getMastercardReferenceId()),
        () -> assertEquals(MockDSAResponse.CLIENT_TRANSACTION_ID, acquirerAdviceResponse.getResponse().getClientTransactionId()),
        () -> assertEquals(MockDSAResponse.ACCOUNT_NUMBER, acquirerAdviceResponse.getResponse().getCard().getAccountNumber())
    );
  }

  @Test
  void testTransactionHistoryAdvice() throws Exception {
    when(apiClient.execute(any(Call.class), any(Type.class))).thenReturn(new ApiResponse<>(201, new HashMap<>(),
        MockDSAResponse.getTransactionHistoryAdviceResponse()));

    DirectServiceResponse transactionHistoryAdviceResponse = dsaService.getResponse(DirectServicesExample.buildTransactionHistoryAdviceRequest());

    verify(apiClient, atMostOnce()).buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any());
    verify(apiClient, atMostOnce()).execute(any(Call.class), any(Type.class));

    assertAll(
        () -> assertNotNull(transactionHistoryAdviceResponse),
        () -> assertEquals(MockDSAResponse.RESPONSE_CODE, transactionHistoryAdviceResponse.getResponse().getResponseCode()),
        () -> assertEquals(MockDSAResponse.MASTERCARD_REFERENCE_ID, transactionHistoryAdviceResponse.getResponse().getMastercardReferenceId()),
        () -> assertEquals(MockDSAResponse.CLIENT_TRANSACTION_ID, transactionHistoryAdviceResponse.getResponse().getClientTransactionId()),
        () -> assertEquals(MockDSAResponse.ACCOUNT_NUMBER, transactionHistoryAdviceResponse.getResponse().getCard().getAccountNumber()),
        () -> assertEquals("50", transactionHistoryAdviceResponse.getResponse().getServices().get(0).getCode()),
        () -> assertEquals("C", transactionHistoryAdviceResponse.getResponse().getServices().get(0).getResult()),
        () -> assertEquals("51", transactionHistoryAdviceResponse.getResponse().getServices().get(1).getCode()),
        () -> assertEquals("V", transactionHistoryAdviceResponse.getResponse().getServices().get(1).getResult())
    );
  }

  @Test
  void testFraudServicesOriginal() throws Exception {
    when(apiClient.execute(any(Call.class), any(Type.class))).thenReturn(new ApiResponse<>(201, new HashMap<>(),
        MockDSAResponse.getFraudServicesOriginalResponse()));

    DirectServiceResponse fraudServicesOriginalResponse = dsaService.getResponse(DirectServicesExample.buildFraudServicesOriginalRequest());

    verify(apiClient, atMostOnce()).buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any());
    verify(apiClient, atMostOnce()).execute(any(Call.class), any(Type.class));

    assertAll(
        () -> assertNotNull(fraudServicesOriginalResponse),
        () -> assertEquals(MockDSAResponse.RESPONSE_CODE, fraudServicesOriginalResponse.getResponse().getResponseCode()),
        () -> assertEquals(MockDSAResponse.CLIENT_TRANSACTION_ID, fraudServicesOriginalResponse.getResponse().getClientTransactionId()),
        () -> assertEquals(MockDSAResponse.MASTERCARD_REFERENCE_ID, fraudServicesOriginalResponse.getResponse().getMastercardReferenceId()),
        () -> assertEquals(MockDSAResponse.ACCOUNT_NUMBER, fraudServicesOriginalResponse.getResponse().getCard().getAccountNumber()),
        () -> assertEquals(MockDSAResponse.CVC_RESPONSE_CODE, fraudServicesOriginalResponse.getResponse().getCard().getCvcResponseCode()),
        () -> assertEquals(MockDSAResponse.TOKEN_TYPE, fraudServicesOriginalResponse.getResponse().getCard().getToken().getType()),
        () -> assertNotNull(fraudServicesOriginalResponse.getResponse().getServices()),
        () -> assertTrue(fraudServicesOriginalResponse.getResponse().getServices().size() > 0),
        () -> assertEquals("18C", fraudServicesOriginalResponse.getResponse().getServices().get(0).getCode()),
        () -> assertEquals("C", fraudServicesOriginalResponse.getResponse().getServices().get(0).getResult()),
        () -> assertEquals("18U", fraudServicesOriginalResponse.getResponse().getServices().get(1).getCode()),
        () -> assertEquals("U", fraudServicesOriginalResponse.getResponse().getServices().get(1).getResult()),
        () -> assertEquals(9, fraudServicesOriginalResponse.getResponse().getAuthentication().getSecurityProtocol()),
        () -> assertEquals(0, fraudServicesOriginalResponse.getResponse().getAuthentication().getCardholderAuthentication()),
        () -> assertEquals(0, fraudServicesOriginalResponse.getResponse().getAuthentication().getUcafCollectionIndicator())
    );
  }

  @Test
  void testFraudServicesAdvice() throws Exception {
    when(apiClient.execute(any(Call.class), any(Type.class))).thenReturn(new ApiResponse<>(201, new HashMap<>(),
        MockDSAResponse.getFraudServicesAdviceResponse()));

    DirectServiceResponse fraudServicesAdviceResponse = dsaService.getResponse(DirectServicesExample.buildFraudServicesAdviceRequest());

    verify(apiClient, atMostOnce()).buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any());
    verify(apiClient, atMostOnce()).execute(any(Call.class), any(Type.class));

    assertAll(
        () -> assertNotNull(fraudServicesAdviceResponse),
        () -> assertEquals(MockDSAResponse.RESPONSE_CODE, fraudServicesAdviceResponse.getResponse().getResponseCode()),
        () -> assertEquals(MockDSAResponse.CLIENT_TRANSACTION_ID, fraudServicesAdviceResponse.getResponse().getClientTransactionId()),
        () -> assertEquals(MockDSAResponse.MASTERCARD_REFERENCE_ID, fraudServicesAdviceResponse.getResponse().getMastercardReferenceId()),
        () -> assertEquals(MockDSAResponse.ACCOUNT_NUMBER, fraudServicesAdviceResponse.getResponse().getCard().getAccountNumber()),
        () -> assertEquals(MockDSAResponse.CVC_RESPONSE_CODE, fraudServicesAdviceResponse.getResponse().getCard().getCvcResponseCode()),
        () -> assertEquals(MockDSAResponse.TOKEN_TYPE, fraudServicesAdviceResponse.getResponse().getCard().getToken().getType()),
        () -> assertNotNull(fraudServicesAdviceResponse.getResponse().getServices()),
        () -> assertTrue(fraudServicesAdviceResponse.getResponse().getServices().size() > 0),
        () -> assertEquals("18", fraudServicesAdviceResponse.getResponse().getServices().get(0).getCode()),
        () -> assertEquals("C", fraudServicesAdviceResponse.getResponse().getServices().get(0).getResult()),
        () -> assertEquals("18", fraudServicesAdviceResponse.getResponse().getServices().get(1).getCode()),
        () -> assertEquals("U", fraudServicesAdviceResponse.getResponse().getServices().get(1).getResult())
    );
  }
}
