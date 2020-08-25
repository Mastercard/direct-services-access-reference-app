# AcquirerAdviceRequest

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Request](../docs/models/DirectServiceRequest.md) page.

The sample below provides the specific fields required by the acquirer advice use case.

## Sample JSON

```json
{
  "serviceType": "ADVICE",
  "clientTransactionId": "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=",
  "customer": {
    "id": "567899"
  },
  "card": {
    "accountNumber": "5400000000000000"
  },
  "transaction": {
    "amount": "0000000050000",
    "currency": "840",
    "adviceReasonCode": "190"
  },
  "original": {
    "responseCode": "00"
  }
}
```
