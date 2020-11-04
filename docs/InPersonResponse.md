# InPersonResponse

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Response](docs/models/DirectServiceResponse.md) page.

The sample below provides the specific fields required by the in-person use case.
                                       
## Sample JSON

```json
{
  "response": {
    "responseCode": "12",
    "clientTransactionId": "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=",
    "mastercardReferenceId": "00NSAN",
    "card": {
      "accountNumber": "5400000000000000"
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
      "sequenceNumber": "891"
    },
    "transaction": {
      "amount": 50000
    },
    "terminal": {
      "panEntryMode": "CONTACTLESS_MAGNETIC_STRIPE"
    },
    "cardAcceptor": {
      "merchantType": "5499"
    },
    "security": {
      "chipData": "NUYyQTAyMDk3ODgyMDI1QzAwOTUwNUFCMjZGQkNEQjE5QTAzMDMwNjE5OUMwMTAwOUYwMjA2MDAwMDAwMDEwMDAwOUYxMDEyMDAxMkUxMjM0QkM3QkJDQzk2MUYwMDAwMDAwMDAwMDAwMEZGOUYxQTAyMDg0MDlGMjcwMTgwOUYzNjAyMDBBMjlGMzcwNDAwMDAwMDU2OUYyNjA4N0FDMjEzMEM3OEQyQTQ3Mw==",
      "magStripeTrack1Data": "94569790763027849890254982D87398989279",
      "magStripeTrack2Data": "9456963027849254982D8739279"
    }
  }
}
```
