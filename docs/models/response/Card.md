# Card

## Properties <a name="properties"></a>

| Name | Type | Description |
| :--- | :--- | :---------- |
| **accountNumber** | string | Funding/Real account number. |
| **token** | object | Details of the tokenized card for the response. See [**Token**](Token.md) attributes. |
| **paymentAccountReference** | string | Payment account reference. |
| **pinServiceCode** | string | Pin Validation. Possible values - [PIN_DROPPED ("PD"), PIN_VERIFIED ("PV"), PIN_TRANSLATED ("TV"), PIN_NOT_VERIFIED ("PI"), PIN_NOT_TRANSLATE ("TI")] |
| **cvcResponseCode** | string | CVC Response. Possible values - [M, N, P, S, U] |