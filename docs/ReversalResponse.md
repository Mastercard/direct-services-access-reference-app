# ReversalResponse

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Response](docs/models/DirectServiceResponse.md) page.

The sample below provides the specific fields required by the reversal use case.

## Sample JSON

```json
{
  "response": {
    "responseCode": "12",
    "mastercardReferenceId": "00NUAN",
    "card": {
      "accountNumber": "5400000000000000",
       "expiry": "2023-01"
    }
  },
  "request": {
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
}
```
