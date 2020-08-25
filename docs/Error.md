# Error

## Properties <a name="properties"></a>

| Name | Type | Description |
| :--- | :--- | :---------- |
| **source** | **String** | The application that generated this error. Every error message that is generated and returned by the gateway will have this field equal to Gateway. |
| **reasonCode** | **String** | A unique constant identifying the error case encountered during processing. |
| **description** | **String** | Short description of the ReasonCode field. For the Mastercard Direct Services Access API specifically, the invalid field will be listed here. |
| **recoverable** | **Boolean** | Indicates whether this error will always be returned for this request, or retrying could change the outcome. |
| **details** | **String** | Where appropriate, indicates detailed information about data received and calculated during request processing, to help the user with diagnosing errors. |
