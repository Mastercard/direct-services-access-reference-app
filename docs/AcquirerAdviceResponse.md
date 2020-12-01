# AcquirerAdviceResponse

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Response](docs/models/DirectServiceResponse.md) page.

The sample below provides the specific fields required by the acquirer advice use case.

## Sample JSON

```json
{
  "response": {
    "responseCode": "12",
    "clientTransactionId": "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=",
    "mastercardReferenceId": "00NYAN",
    "card": {
      "accountNumber": "5400000000000000",
      "expiry": "2023-01"
    }
  },
  "request": {
    "serviceType": "ADVICE",
    "clientTransactionId": "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=",
    "customer": {
      "id": "567899"
    },
    "card": {
      "accountNumber": "5400000000000000"
    },
    "transaction": {
      "amount": 50000,
      "currency": "840",
      "adviceReasonCode": "190"
    },
    "original": {
      "responseCode": "00"
    }
  }
}
```
