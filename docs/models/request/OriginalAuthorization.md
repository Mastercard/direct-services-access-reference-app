# OriginalAuthorization

## Properties <a name="properties"></a>

| Name | Type | Description | Notes |
| :--- | :--- | :---------- | :---- |
| **mastercardReferenceId** | string | Mastercard Banknet reference number. Must be 6-9 digit alpha numeric string. | Optional |
| **transaction** | object | Details of the transaction in the request. See [**Transaction**](Transaction.md) attributes. | Optional |
| **authorizationCode** | string | Authorization code. Max size of 6 bytes. | Optional |
| **responseCode** | string | Original transaction's response code. Must be a 2-digit numeric string. | Optional |
| **messageType** | string | Message type. Valid values are 0110, 0120, 0210, 0220, 0400, 0420. | Optional |
| **services** | array | List of services performed. See [**Service**](../common/Service.md) attributes. | Optional |
| **securityServices** | array | List of security services performed. See [**Service**](../common/Service.md) attributes. | Optional |