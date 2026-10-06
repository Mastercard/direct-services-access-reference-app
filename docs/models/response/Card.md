# Card

## Properties <a name="properties"></a>

| Name | Type | Description                                                                                                                                                                                     | Notes |
| :--- | :--- |:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| :---- |
| **accountNumber** | string | Funding/Real account number.                                                                                                                                                                    |
| **token** | object | Details of the tokenized card for the response. See [**Token**](Token.md) attributes.                                                                                                           |
| **paymentAccountReference** | string | Payment account reference.                                                                                                                                                                      |
| **pinServiceCode** | string | Pin Validation. Possible values - [PIN_DROPPED ("PD"), PIN_VERIFIED ("PV"), PIN_TRANSLATED ("TV"), PIN_NOT_VERIFIED ("PI"), PIN_NOT_TRANSLATE ("TI")]                                           |
| **cvcResponseCode** | string | CVC Response. Possible values - [M, N, P, S, U]                                                                                                                                                 |
| **alm**                     | object | Details of the accont level management of the card response. See [**Alm**](Alm.md) attributes.                                                                                                  | Optional     |
| **product**                 | string | Contains (Financial Network Code) identifies the specific program or service (for example, the financial network, financial program, or card program) with which the transaction is associated. |