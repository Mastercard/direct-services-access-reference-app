# FraudServicesOriginalResponse

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Response](docs/models/DirectServiceResponse.md) page.

The sample below provides the specific fields required by the fraud services original use case.

## Sample JSON

```json
{
  "response": {
    "responseCode": "12",
    "clientTransactionId": "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=",
    "mastercardReferenceId": "00OBAN",
    "card": {
      "accountNumber": "5400000000000000",
      "cvcResponseCode": "M"
    },
    "security": {
      "pinBlock": "AQJeCgULCwc=",
      "digitalPayment": {
        "merchantId": "d3d3Lm1hY3lzLmNvbQ=="
      }
    },
    "authentication": {
      "securityProtocol": 9,
      "cardholderAuthentication": 0,
      "ucafCollectionIndicator": 0
    }
  },
  "request": {
    "serviceType": "ORIGINAL",
    "clientTransactionId": "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=",
    "customer": {
      "id": "567899"
    },
    "card": {
      "accountNumber": "5400000000000000",
      "expiry": "2023-12",
      "validationCode": "567",
      "sequenceNumber": "891",
      "country": "840"
    },
    "transaction": {
      "transactionType": "00",
      "fromAccountType": "20",
      "toAccountType": "20",
      "purpose": 0,
      "typeIdentifier": "C01",
      "amount": 50000,
      "currency": "840",
      "submittedOn:": "2019-04-12T10:28:04.651",
      "settlementAmount": 50000,
      "settlementCurrency": "840",
      "billingAmount": 50000,
      "billingCurrency": "840",
      "billingConversionRate": "00050000",
      "settlementDate": "2019-04-12",
      "category": "T",
      "adviceReasonCode": "000",
      "promotionCode": "GREECE"
    },
    "terminal": {
      "panEntryMode": "CONTACTLESS_MAGNETIC_STRIPE",
      "pinEntryMode": "0",
      "attendance": 0,
      "location": 0,
      "cardholderPresence": 0,
      "cardPresence": 0,
      "cardCaptureCapabilities": 0,
      "transactionSecurity": 0,
      "cardholderActivated": 4,
      "cardDataInputCapability": 2,
      "authorizationLifeCycle": 0,
      "country": "840",
      "postalCode": "63026"
    },
    "cardAcceptor": {
      "merchantType": "5499",
      "terminalId": "ID12345",
      "acquirerId": "123456",
      "merchantId": "ID12345",
      "name": "Walmart",
      "location": {
        "city": "O'Fallon",
        "state": "MO",
        "country": "USA"
      }
    },
    "security": {
      "chipData": "NUYyQTAyMDk3ODgyMDI1QzAwOTUwNUFCMjZGQkNEQjE5QTAzMDMwNjE5OUMwMTAwOUYwMjA2MDAwMDAwMDEwMDAwOUYxMDEyMDAxMkUxMjM0QkM3QkJDQzk2MUYwMDAwMDAwMDAwMDAwMEZGOUYxQTAyMDg0MDlGMjcwMTgwOUYzNjAyMDBBMjlGMzcwNDAwMDAwMDU2OUYyNjA4N0FDMjEzMEM3OEQyQTQ3Mw==",
      "magStripeTrack1Data": "94569790763027849890254982D87398989279",
      "magStripeTrack2Data": "9456963027849254982D8739279",
      "universalCardholderAuthenticationField": "aduX3UYzkZWYd_JQ1FbXcaBa",
      "pinBlock": "AQJeCgULCwc=",
      "pinBlockFormat": "ISO_FORMAT_0",
      "pinKeyIndex": 98,
      "digitalPayment": {
        "estimatedAmount": 123,
        "merchantId": "d3d3Lm1hY3lzLmNvbQ=="
      }
    },
    "authentication": {
      "securityProtocol": 9,
      "cardholderAuthentication": 0,
      "ucafCollectionIndicator": 0,
      "avsResponseCode": "P",
      "cvcResponseCode": "M"
    }
  }
}
```
