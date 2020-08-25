# CardAcceptor

## Properties <a name="properties"></a>

| Name | Type | Description | Notes |
| :----| :--- | :---------- | :---- |
| **merchantType** | string | Merchant type classification. Must be a 4 byte string. | Optional |
| **terminalId** | string | Uniquely identifies a terminal at the card acceptor location of acquiring institutions or merchant POS system. Max size of 8 bytes. | Optional |
| **merchantId** | string | Identifies the card acceptor that defines the point of the transaction in both local and interchange environments. Max size of 15 bytes. | Optional |
| **name** | string | Identifies the card acceptor that defines the point of the transaction in both local and interchange environments. | Optional |
| **location** | object | Details of the location of the card acceptor. See [**Location**](Location.md) attributes. | Optional |
| **acquirerId** | string | Identifies the card acceptor that defines the point of the transaction in both local and interchange environments. Max size of 6 bytes, must be a numeric string. | Optional |