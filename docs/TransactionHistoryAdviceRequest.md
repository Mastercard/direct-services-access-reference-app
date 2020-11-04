# TransactionHistoryAdviceRequest

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Request](docs/models/DirectServiceRequest.md) page.

The sample below provides the specific fields required by the transaction history advice use case.

## Sample JSON

```json
{
  "serviceType": "ADVICE",
  "clientTransactionId": "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=",
  "customer": {
    "id": "567899"
  },
  "card": {
    "accountNumber": "5400000000000000",
    "sequenceNumber": "891",
    "token": {
      "transactionId": "fe8Rr7GWCOXCRaM6KNWDb/s4gyxalgQKt/M8L6BdndA="
    }
  },
  "transaction": {
    "transactionType": "00",
    "fromAccountType": "20",
    "toAccountType": "20",
    "amount": "0000000050000",
    "currency": "840",
    "submittedOn": "2019-04-12T10:28:04.651",
    "adviceReasonCode": "201"
  },
  "terminal": {
    "panEntryMode": "CONTACTLESS_MAGNETIC_STRIPE"
  },
  "cardAcceptor": {
    "name": "Walmart",
    "location": {
      "city": "O'Fallon",
      "state": "MO",
      "country": "USA"
    }
  },
  "original": {
    "mastercardReferenceId": "123456789",
    "transaction": {
      "transactionType": "00"
    },
    "authorizationCode": "123456",
    "responseCode": "00",
    "messageType": "0110",
    "services": [
      {
        "code": "50",
        "result": "C"
      },
      {
        "code": "51",
        "result": "V",
        "issuerAuthenticationData": "AQheCgcLCwcBCF4KBwsLBw==",
        "atcInfo": "0008800042G"
      }
    ]
  }
}
```
