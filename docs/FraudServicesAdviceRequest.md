# FraudServicesAdviceRequest

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Request](docs/models/DirectServiceRequest.md) page.

The sample below provides the specific fields required by the fraud services advice use case.

## Sample JSON

```json
{
  "serviceType": "ADVICE",
  "clientTransactionId": "12345",
	"customer": {
	    "id": "567899"
	},
	"card": {
		"accountNumber": "5400000000000000",
		"validationCode": "567",
		"token": {
      "type": "C"
    },		
		"country": "840"     
	},
	"transaction": {
		"transactionType": "00",
		"fromAccountType": "00",
		"toAccountType": "00",
		"purpose": "00",
		"category": "T",
		"adviceReasonCode": "201",
		"amount": "000000050000",
		"currency": "840",
		"settlementAmount": "000000050000",
    "billingAmount": "000000050000",
    "promotionCode": "GREECE"
	},
	"terminal": {
		"panEntryMode": "CONTACTLESS_MAGNETIC_STRIPE",
		"pinEntryMode": "0",
		"attendance": 0,
		"location": 0,
		"cardholderPresence": 0,
		"cardPresence": 0,
		"cardCaptureCapabilities": 0,
		"transactionSecurity": 0,
		"cardholderActivated": 4,
		"cardDataInputCapability": 2,
		"authorizationLifeCycle": 0,
		"country": "840",
		"postalCode": "63026"
	},
	"cardAcceptor":{
			"merchantType": "5499",
			"terminalID": "ID12345",
			"acquirerID":"123456",
			"merchantID":"CD1234",
			"name": "walmart",
      "location": {
        "city": "O'Fallon",
        "state": "MO",
        "country": "USA"
      }
	},
	"security": {
		"magStripeTrack2Data": "9456963027849254982D8739279"
	},
	"authentication": {
		"cvcResponseCode": "M"
	},
	"original": {
    "mastercardReferenceId": "123456789",
		"authorizationCode": "123456",
		"responseCode": "00",
    "messageType": "0110",
    "services": [
      {
        "code": "50",
        "result": "C"
      },
      {
        "code": "51",
        "result": "V",
        "issuerAuthenticationData": "AQheCgcLCwcBCF4KBwsLBw==",
        "atcInfo": "0008800042G"
      }
    ]
	}
}
```
