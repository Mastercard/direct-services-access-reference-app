# FraudServicesAdviceResponse

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Response](docs/models/DirectServiceResponse.md) page.

The sample below provides the specific fields required by the fraud services advice use case.

## Sample JSON

```json
{
  "response": {
    "responseCode": "85",
    "clientTransactionId": "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=",
    "mastercardReferenceId": "123456789",
    "card": {
      "accountNumber": "5400000000000000",
      "token": {
        "type": "C"
      },
      "cvcResponseCode": "M"
    },
    "securityServices": [
      {
        "code": "18",
        "result": "C"
      },
      {
        "code": "18",
        "result": "U"
      }
    ]
  },
  "request": {
    "serviceType": "ADVICE",
    "clientTransactionId": "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=",
    "customer": {
      "id": "567899"
    },
    "card": {
      "accountNumber": "5400000000000000",
      "validationCode": "567",
      "country": "840",
      "token": {
        "type": "C"
      }
    },
    "transaction": {
      "transactionType": "00",
      "fromAccountType": "00",
      "toAccountType": "00",
      "purpose": 0,
      "typeIdentifier": "C01",
      "amount": 50000,
      "currency": "840",
      "settlementAmount": 50000,
      "billingAmount": 50000,
      "category": "T",
      "adviceReasonCode": "201",
      "promotionCode": "GREECE",
      "cardholderVerificationMethod": "P"
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
      "magStripeTrack2Data": "9456963027849254982D8739279"
    },
    "authentication": {
      "cvcResponseCode": "M"
    },
    "original": {
      "mastercardReferenceId": "123456789",
      "responseCode": "00",
      "securityServices": [
        {
          "code": "18",
          "result": "C"
        },
        {
          "code": "18",
          "result": "U"
        }
      ]
    }
  }
}
```
