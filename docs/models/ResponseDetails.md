# ResponseDetails

## Properties <a name="properties"></a>

| Name | Type | Description |
| :--- | :--- | :---------- |
| **responseCode** | string | Response code. |
| **clientTransactionId** | string | Private use data that a customer may want to include in a message. |
| **mastercardReferenceId** | string | Mastercard Banknet reference number. |
| **transaction** | object | Transaction details for the response. See [**Transaction**](response/Transaction.md) attributes. |
| **card** | object | Details of the detokenized card. See [**Card**](response/Card.md) attributes. |
| **security** | object | Security response details. See [**Security**](response/Security.md) attributes. |
| **wallet** | object | Details of the wallet. See [**Wallet**](common/Wallet.md) attributes. |
| **services** | array | List of services performed. See [**Service**](common/Service.md) attributes. |
| **securityServices** | array | List of security services performed. [**Service**](common/Service.md) attributes. |
| **authentication** | object | Response details of the ecommerce indicators. See [**Authentication**](response/Authentication.md) attributes. |