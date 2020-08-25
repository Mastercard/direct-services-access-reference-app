# Errors

## Properties <a name="properties"></a>

| Name | Type | Description |
| :--- | :--- | :---------- |
| **errors** | [**ErrorResponse**](ErrorResponse.md) | Contains object of error list |

## Sample JSON

```json
{
  "Errors": {
    "Error": [
      {
        "Source": "network-access-services",
        "ReasonCode": "VALIDATION_ERROR",
        "Description": "card.accountNumber",
        "Recoverable": false,
        "Details": "must not be null"
      }
    ]
  }
}
```
