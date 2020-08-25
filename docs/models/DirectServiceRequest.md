# DirectServiceRequest

## Properties <a name="properties"></a>

| Name | Type | Description | Notes |
| :--- | :--- | :---------- | :---- |
| **serviceType** | string | Type of message for this transaction. This is typically used to determine ISO message type. Possible values - [ORIGINAL, REVERSAL, ADVICE] | **Required** |
| **clientTransactionId** | string | Private use data that a customer may want to include in a message. Max limit of 200 characters. | Optional |
| **customer** | object | Details of the customer requesting the service. See [**Customer**](request/Customer.md) attributes. | **Required** |
| **card** | object | Details of the card used in the transaction. See [**Card**](request/Card.md) attributes. | **Required** |
| **transaction** | object | Details of the transaction in the request. See [**Transaction**](request/Transaction.md) attributes. | Optional |
| **terminal** | object | Details of the terminal. See [**Terminal**](request/Terminal.md) attributes. | Optional |
| **cardAcceptor** | object | Details of the card acceptor. See [**CardAcceptor**](request/CardAcceptor.md) attributes. | Optional |
| **security** | object | Details of security related values. See [**Security**](request/Security.md) attributes. | Optional |
| **authentication** | object | Details of the ecommerce transaction indicators. See [**Authentication**](request/Authentication.md) attributes. | Optional |
| **original** | object | Details of the original transaction to be reversed. See [**OriginalAuthorization**](request/OriginalAuthorization.md) attributes. | Optional |
