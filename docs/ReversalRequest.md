# ReversalRequest

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Request](docs/models/DirectServiceRequest.md) page.

The sample below provides the specific fields required by the reversal use case.

## Sample JSON

```json
{
  "serviceType": "REVERSAL",
  "customer": {
    "id": "567899"
  },
  "card": {
    "accountNumber": "5400000000000000"
  },
  "transaction": {
    "amount": 123
  },
  "original": {
    "responseCode": "00"
  }
}
```
