# Transaction

## Properties <a name="properties"></a>

| Name | Type | Description | Notes |
| :--- | :--- | :---------- | :---- |
| **transactionType** | string | Cardholder Transaction Type Code. It describes the specific transaction type. Must be a 2-digit numeric string. | Optional |
| **fromAccountType** | string | Cardholder “From Account” Type Code describes the cardholder account type affected for cardholder account debits and inquiries and the “from account” type for cardholder account transfer transactions. Must be a 2-digit numeric string. | Optional |
| **toAccountType** | string | Cardholder “To Account” Type Code describes the cardholder account type affected for cardholder account credits and the “to account” type for cardholder account transfer transactions. | Optional |
| **purpose** | integer | Transaction purpose code. | Optional |
| **typeIdentifier** | string | Indicates the type of additional transaction purpose. 1-3 byte string. | Optional |
| **amount** | integer | Transaction amount. Must not be a negative amount, and must not be greater than 9999999999999999. | Optional |
| **currency** | string | ISO 4217 3-digit currency code. Must be a 3-digit numeric string. | Optional |
| **submittedOn** | string | Time the transaction was submitted. ISO8601 date and time string. Must be in 'yyyy-MM-dd'T'HH:mm:ss' format. | Optional |
| **settlementAmount** | integer | Settlement amount. Must not be a negative amount, and must not be greater than 9999999999999999. | Optional |
| **settlementCurrency** | string | ISO 4217 3-digit currency code. Must be a 3-digit numeric string. | Optional |
| **billingAmount** | integer | Billing amount. Must not be a negative amount, and must not be greater than 9999999999999999. | Optional |
| **billingCurrency** | string | ISO 4217 3-digit currency code. Must be a 3-digit numeric string. | Optional |
| **billingConversionRate** | string | Conversion rate. 8-digit numeric string. | Optional |
| **settlementDate** | string | Settlement date of transaction. ISO8601 date string. | Optional |
| **category** | string | Transaction category. Max size limit of 1 byte. | Optional |
| **adviceReasonCode** | string | Transaction advice reason code. 3-digit numeric string. | Optional |
| **promotionCode** | string | Transaction promotion code. Max size limit of 6 bytes, alpha-numeric string. | Optional |
| **cardholderVerificationMethod** | string | Transaction cardholder Verification Method. Max size limit of 1 byte, alpha string. | Optional |