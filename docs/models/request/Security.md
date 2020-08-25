# Security

## Properties <a name="properties"></a>

| Name | Type | Description | Notes |
| :--- | :--- | :---------- | :---- |
| **chipData** | string | Integrated Circuit Card [ICC] System-Related Data. Base-64 encoded string. Max size of 255 bytes. | Optional |
| **magStripeTrack1Data** | string | Track 1 data. Max size of 76 bytes. | Optional |
| **magStripeTrack2Data** | string | Track 2 data. Max size of 37 bytes. | Optional |
| **universalCardholderAuthenticationField** | string | Universal cardholder authentication field (UCAF). Must be a 1-32 byte string. | Optional |
| **pinBlock** | string | The cardholder's unique PIN. Base-64 encoded string. Max size of 8 bytes. | Optional |
| **pinBlockFormat** | string | Type of PIN block format used. Possible values - [ANSI_1 (01), ISO_FORMAT_0 (10), ISO_FORMAT_1 (11)] | Optional |
| **pinKeyIndex** | integer | Indicates the specific PIN key to be used when more than one key is available in a PIN key set. Must be between 1-9999. | Optional |
| **digitalPayment** | object | Details of the Digital Payment data. See [**DigitalPayment**](DigitalPayment.md) attributes| Optional |