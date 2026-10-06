# FraudServicesOriginalResponse

## Properties <a name="properties"></a>
All properties for the request object are listed in the [Direct Service Response](docs/models/DirectServiceResponse.md) page.

The sample below provides the specific fields required by the fraud services original use case.

## Sample JSON

```json
{
  "response":{
    "responseCode":"12",
    "clientTransactionId":"12345",
    "mastercardReferenceId":"0SBSAN",
    "card":{
      "accountNumber":"5400000000000000"
    },
    "security":{
      "pinBlock":"MTIzNDU2Nzg=",
      "digitalPayment":{
        "merchantId":"d3d3Lm1hY3lzLmNvbQ=="
      }
    },
    "authentication":{
      "securityProtocol":1,
      "cardholderAuthentication":2,
      "ucafCollectionIndicator":3
    }
  },
  "request":{
    "serviceType":"ORIGINAL",
    "clientTransactionId":"12345",
    "customer":{
      "id":"567899"
    },
    "card":{
      "accountNumber":"5400000000000000",
      "expiry":"2020-12",
      "validationCode":"567",
      "sequenceNumber":"891",
      "country":"840"
    },
    "transaction":{
      "transactionType":"00",
      "fromAccountType":"00",
      "toAccountType":"00"
    },
    "terminal":{
      "panEntryMode":"CONTACTLESS_MAGNETIC_STRIPE",
      "pinEntryMode":"0"
    },
    "cardAcceptor":{
      "merchantType":"5499"
    },
    "security":{
      "chipData":"AQJeCgULCwcOA18KBQsEBwNfCgULBAc=",
      "universalCardholderAuthenticationField":"aduX3UYzkZWYd_JQ1FbXcaBa",
      "pinBlock":"MTIzNDU2Nzg=",
      "pinBlockFormat":"ISO_FORMAT_0",
      "pinKeyIndex":1234,
      "digitalPayment":{
        "cryptogram":"AQJeCgULCwcOA18KBQsEBwNfCgULBAc=",
        "merchantId":"d3d3Lm1hY3lzLmNvbQ=="
      }
    },
    "authentication":{
      "securityProtocol":1,
      "cardholderAuthentication":2,
      "ucafCollectionIndicator":3,
      "avsResponseCode":"A"
    }
  }
}
```
