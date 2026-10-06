# Alm

## Properties <a name="properties"></a>

| Name | Type | Description                                                                                                                                                        | Notes |
| :--- | :--- |:-------------------------------------------------------------------------------------------------------------------------------------------------------------------| :---- |
| **credentialExclusionIndicator** | enum   | The Mastercard One Credential Exclusion Indicator allows an acquirer to provide additional information about the transaction, the acceptor, etc. not elsewhere provided, that is relevant to the way Mastercard processes the transaction. Possible values - [C, D, M] | Optional |
| **accountNumberIndicator** | string | Indicates the type of account number sent to the Issuer. Currently only one value is supported - <br> '1 - Mastercard One Credential Funding PAN'. Always send `"accountNumberIndicator": "1"`. | Optional |
| **AccountNumber**          | string | Contains Mastercard One Credential account number (Funding PAN) to the Issuer| Optional |
| **accountNumberExpiry**    | string | Contains Mastercard One Credential account number expiration date. Must be in 'YYYY-mm-dd' format. Example - `"accountNumberExpiry": "2028-12-31"`. | Optional |