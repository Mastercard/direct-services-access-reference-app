# InPersonRequest

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Request](docs/models/DirectServiceRequest.md) page.

The sample below provides the specific fields required by the in-person use case.

## Sample JSON

```json
{
  "serviceType": "ORIGINAL",
  "clientTransactionId": "03vLwCxtn3/pZCliH5mXY1Bozs5HspdIdn20H/GTRrU=",
  "customer": {
    "id": "567899"
  },
  "card": {
    "accountNumber": "5400000000000000",
    "expiry": "2023-12",
    "sequenceNumber": 891
  },
  "terminal": {
    "panEntryMode": "CONTACTLESS_MAGNETIC_STRIPE"
  },
  "cardAcceptor": {
    "merchantType": "5499"
  },
  "security": {
    "magStripeTrack2Data": "5155443800189981D22072010000525700004"
  }
}
```
