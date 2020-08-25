# Terminal

## Properties <a name="properties"></a>

| Name | Type | Description | Notes |
| :--- | :--- | :---------- | :---- |
| **panEntryMode** | string | Pan entry mode. Possible values - [CONTACTLESS_M_CHIP (07), ECOMMERCE_DSRP (09), CREDENTIAL_ON_FILE (10), ECOMMERCE (81), MAGNETIC_STRIPE (90), CONTACTLESS_MAGNETIC_STRIPE (91)] | Optional |
| **pinEntryMode** | string | Pin entry mode. | Optional |
| **attendance** | integer | Indicates if the card acceptor is attending the terminal. | Optional |
| **location** | integer | Indicates the terminal location. | Optional |
| **cardholderPresence** | integer | Indicates whether the cardholder is present at the point of service and explains the condition if the cardholder is not present. | Optional |
| **cardPresence** | integer | Indicates if the card is present at the point of service. | Optional |
| **cardCaptureCapabilities** | integer | Indicates whether the terminal has card capture capabilities. | Optional |
| **transactionSecurity** | integer | Indicates the card acceptor’s confidence in the transaction security level. | Optional |
| **cardholderActivated** | integer | Indicates the type of cardholder activated terminal used by the cardholder to initiate the transaction. | Optional |
| **cardDataInputCapability** | integer | Indicates the set of methods supported by the terminal for the input of account number, card, or mobile device data. | Optional |
| **authorizationLifeCycle** | integer | Indicates the number of days a preauthorization will stay in effect. | Optional |
| **country** | string | Indicates the country of the point of sale location (not the acquirer location) using ISO 3166 specified numeric codes. Must be a 3-digit numeric string. | Optional |
| **postalCode** | string | Indicates the geographic code of the POS (merchant) location (not the acquirer’s location). Must be a 1-10 byte alphanumeric string. | Optional |