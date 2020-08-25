# Authentication

## Properties <a name="properties"></a>

| Name | Type | Description | Notes |
| :--- | :--- | :---------- | :---- |
| **securityProtocol** | integer | Security Protocol. Must be between 0-9. | Optional |
| **cardholderAuthentication** | integer | Cardholder Authentication. Must be between 0-9.| Optional |
| **ucafCollectionIndicator** | integer | Universal cardholder authentication field (UCAF) collection indicator. Must be between 0-9. | Optional |
| **avsResponseCode** | string | Address Verification Service Response contains the AVS verification response code in the Authorization Request Response/0110 message. Possible values - [A, N, R, S, U, W, X, Y, Z, B, C, D, F, G, I, M, P]| Optional |
| **cvcResponseCode** | string | CVC Response Code | Optional |