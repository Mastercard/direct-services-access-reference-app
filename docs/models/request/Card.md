# Card

## Properties <a name="properties"></a>

| Name | Type | Description | Notes |
| :--- | :--- | :---------- | :---- |
| **accountNumber** | string | Primary account number. Must be a 12-19-digit numeric string. | **Required** |
| **expiry** | string | Card expiration date. Must be in YYYY-MM, MM/YYYY, or MM/YY format. | Optional |
| **validationCode** | string | CVC2. Must be a 3-4-digit numeric string. | Optional |
| **sequenceNumber** | integer | Sequence number. Must be between 000-999. | Optional |
| **country** | string | Primary account number country code.This is code is used to identify the country where card issuer is located. Country codes are ISO 3166 specified numeric codes. | Optional |
| **token** | object | Details of the tokenized card for the request. See [**Token**](Token.md) attributes. | Optional |