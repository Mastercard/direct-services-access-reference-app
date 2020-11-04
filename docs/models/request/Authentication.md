# Authentication

## Properties <a name="properties"></a>

| Name | Type | Description | Notes |
| :--- | :--- | :---------- | :---- |
| **securityProtocol** | integer | Security Protocol. Must be between 0-9. Must be present if using cardholderAuthentication and ucafCollectionIndicator fields in the authentication request object. | Optional |
| **cardholderAuthentication** | integer | Cardholder Authentication. Must be between 0-9. Must be present if using securityProtocol and ucafCollectionIndicator fields in the authentication request object. | Optional |
| **ucafCollectionIndicator** | integer | Universal cardholder authentication field (UCAF) collection indicator. Must be between 0-9. Must be present if using securityProtocol and cardholderAuthentication fields in the authentication request object. | Optional |
| **avsResponseCode** | string | Address Verification Service Response contains the AVS verification response code in the Authorization Request Response/0110 message. Possible values - [A, N, R, S, U, W, X, Y, Z, B, C, D, F, G, I, M, P] | Optional |
| **cvcResponseCode** | string | CVC Response Code. Possible values - [E, M, N, P, S, U, Y]. | Optional |