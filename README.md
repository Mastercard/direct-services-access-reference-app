# Reference Implementation for Mastercard Direct Services Access

[![](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/Mastercard/direct-services-access-reference/blob/master/LICENSE)

## Table of Contents
- [Overview](#overview)
  * [Compatibility](#compatibility)
  * [References](#references)
- [Usage](#usage)
  * [Prerequisites](#prerequisites)
  * [Configuration](#configuration)
  * [Integrating with OpenAPI Generator](#integrating-with-openapi-generator)
  * [Build and Execute](#build-and-execute)
- [Use Cases](#use-cases)
- [API Reference](#api-reference)
  * [Request Examples](#request-examples)
  * [Recommendation](#recommendation)
- [Support](#support)
- [License](#license)

## Overview <a name="overview"></a>
This is a reference application to demonstrate how the Mastercard Direct Services Access API can be used for the supported operations. Please see here for details on the API: [Mastercard Developers](https://developer.mastercard.com/direct-service/documentation/).
This application illustrates connecting to the Mastercard Direct Services Access API. To call these APIs, the consumer key and .p12 files are required from your [Mastercard Developers](https://developer.mastercard.com/dashboard) project.

### Compatibility <a name="compatibility"></a>
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later

### References <a name="references"></a>
* [Mastercard’s OAuth Signer library](https://github.com/Mastercard/oauth1-signer-java)
* [Using OAuth 1.0a to Access Mastercard APIs](https://developer.mastercard.com/platform/documentation/using-oauth-1a-to-access-mastercard-apis/)

## Usage <a name="usage"></a>
### Prerequisites <a name="prerequisites"></a>
* [Mastercard Developers Account](https://developer.mastercard.com/dashboard) with access to the Mastercard Direct Services Access API
* A text editor or IDE
* [Spring Boot 2.2+](https://spring.io/projects/spring-boot)
* [Apache Maven 3.3+](https://maven.apache.org/download.cgi)
* Set up the `JAVA_HOME` environment variable to match the location of your Java installation.

### Configuration <a name="configuration"></a>
* Create an account at [Mastercard Developers](https://developer.mastercard.com/account/sign-up).  
* Create a new project and add `Direct Service API` API to your project.   
* Configure project and download signing key. It will download the zip file.  
* Select `.p12` files from zip and copy it to `src/main/resources` in the project folder.
* Open `${project.basedir}/src/main/resources/application.properties` and configure below parameters.
    
    >**mastercard.api.base-path=https://sandbox.api.mastercard.com/direct-service-api/services**, it's a static field and will be used as a host to make API calls.
    
    **Below properties will be required for authentication of API calls.**
    
    >**mastercard.api.key-file=**, this refers to .p12 file found in the signing key. Please place .p12 file at src\main\resources in the project folder and add classpath for .p12 file.
    
    >**mastercard.api.consumer-key=**, this refers to your consumer key. Copy it from "Keys" section on your project page in [Mastercard Developers](https://developer.mastercard.com/dashboard)
      
    >**mastercard.api.keystore-alias=keyalias**, this is the default value of key alias. If it is modified, use the updated one from keys section in [Mastercard Developers](https://developer.mastercard.com/dashboard).
    
    >**mastercard.api.keystore-password=keystorepassword**, this is the default value of key alias. If it is modified, use the updated one from keys section in [Mastercard Developers](https://developer.mastercard.com/dashboard).

### Integrating with OpenAPI Generator <a name="integrating-with-openapi-generator"></a>
[OpenAPI Generator](https://github.com/OpenAPITools/openapi-generator) generates API client libraries from [OpenAPI Specs](https://github.com/OAI/OpenAPI-Specification). 
It provides generators and library templates for supporting multiple languages and frameworks.

See also:
* [OpenAPI Generator (maven Plugin)](https://mvnrepository.com/artifact/org.openapitools/openapi-generator-maven-plugin)
* [OpenAPI Generator (executable)](https://mvnrepository.com/artifact/org.openapitools/openapi-generator-cli)
* [CONFIG OPTIONS for java](https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/java.md)

#### OpenAPI Generator Plugin Configuration
```xml
<!-- https://mvnrepository.com/artifact/org.openapitools/openapi-generator-maven-plugin -->
<plugin>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-generator-maven-plugin</artifactId>
    <version>${openapi-generator.version}</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <inputSpec>${project.basedir}/src/main/resources/direct-service-api-swagger.yaml</inputSpec>
                <generatorName>java</generatorName>
                <library>okhttp-gson</library>
                <generateApiTests>false</generateApiTests>
                <generateModelTests>false</generateModelTests>
                <configOptions>
                    <sourceFolder>src/gen/java/main</sourceFolder>
                    <dateLibrary>java8</dateLibrary>
                </configOptions>
            </configuration>
        </execution>
    </executions>
</plugin>
```

#### Generating The API Client Sources
Now that you have all the dependencies you need, you can generate the sources. To do this, use one of the following two methods:

`Using IDE`
* **Method 1**<br/>
  In IntelliJ IDEA, open the Maven window **(View > Tool Windows > Maven)**. Click the icons `Reimport All Maven Projects` and `Generate Sources and Update Folders for All Projects`

* **Method 2**<br/>
  In the same menu, navigate to the commands **({Project name} > Lifecycle)**, select `clean` and `compile` then click the icon `Run Maven Build`. 

`Using Terminal`
* Navigate to the root directory of the project within a terminal window and execute `mvn clean compile` command.

### Build and Execute <a name="build-and-execute"></a>
Once you’ve added the correct properties, we can build the application. We can do this by navigating to the project’s base directory from the terminal and running the following command:

`mvn clean install`

When the project builds successfully you can then run the following command to start the project:

`java -jar target/direct-services-access-reference-1.0.0.jar`

## Use Cases <a name="use-cases"></a>
> Case 1: [ALL FIELDS/COMBINED](https://developer.mastercard.com/direct-service/documentation/parameters/allfields/)
  - User performs an API request with a combination of fields from different use cases below to execute multiple use cases simultaneously.
  - Example: User makes an in-person contactless payment (which requires fields from IN-PERSON use case), which also has fraud services performed (which requires fields from FRAUD SERVICES ORIGINAL use case).
  - Refer to model classes for field level information.

    | URL | Method | Request | Response |
    | :-- | :----- | :------ | :------- |
    | `/services` | POST | [AllFieldsRequest](docs/AllFieldsRequest.md) | [AllFieldsResponse](docs/AllFieldsResponse.md) |
  
> Case 2: [E-COMMERCE](https://developer.mastercard.com/direct-service/documentation/parameters/ecommerce/)
  - An E-Commerce request performs a Mastercard Digital Enablement Service (MDES) detokenization and crypto validation service for cardholders using digital devices for E-commerce purchases.
  - User performs an API request for a transaction using a digital token online, not in person.
  - Refer to model classes for field level information.
  
    | URL | Method | Request | Response |
    | :-- | :----- | :------ | :------- |
    | `/services` | POST | [ECommerceRequest](docs/ECommerceRequest.md) | [ECommerceResponse](docs/ECommerceResponse.md) |
    
> Case 3: [IN-PERSON](https://developer.mastercard.com/direct-service/documentation/parameters/inperson/)
  - An In-Person request performs a Mastercard Digital Enablement Service (MDES) detokenization and crypto validation service for cardholders using digital devices for in-store purchases via Contactless and Dynamic Magnetic Stripe payment methods. 
  - User performs an API request for a transaction using a digital token in person.
  - Refer to model classes for field level information.
    
    | URL | Method | Request | Response |
    | :-- | :----- | :------ | :------- |
    | `/services` | POST | [InPersonRequest](docs/InPersonRequest.md) | [InPersonResponse](docs/InPersonResponse.md) |

> Case 4: [REVERSAL](https://developer.mastercard.com/direct-service/documentation/parameters/reversal/)
  - A Reversal request supports the reversal of a Mastercard Digital Enablement Service (MDES) Original transaction purchase made via E-commerce or In-Person DSA API request.
  - User performs an API request for a reversal of an API request previously made.
  - Refer to model classes for field level information.
    
    | URL | Method | Request | Response |
    | :-- | :----- | :------ | :------- |
    | `/services` | POST | [ReversalRequest](docs/ReversalRequest.md) | [ReversalResponse](docs/ReversalResponse.md) |
    
> Case 5: [ACQUIRER ADVICE](https://developer.mastercard.com/direct-service/documentation/parameters/acquireradvice/)
  - An Acquirer Advice request supports Acquirer generated advice to Mastercard when a Mastercard Digital Enablement Service (MDES) purchase transaction is declined by an Issuer.
  - User performs an API request to gather advice about a previous authorization that was made.
  - Refer to model classes for field level information.

    | URL | Method | Request | Response |
    | :-- | :----- | :------ | :------- |
    | `/services` | POST | [AcquirerAdviceRequest](docs/AcquirerAdviceRequest.md) | [AcquirerAdviceResponse](docs/AcquirerAdviceResponse.md) |

> Case 6: [TRANSACTION HISTORY ADVICE](https://developer.mastercard.com/direct-service/documentation/parameters/transactionhistoryadvice/)
  - A Transaction History Advice request allows a customer to provide transaction advice for the Transaction Details Service (TDS) after transaction processing. The TDS manages the interactions between Mastercard, the Wallet Provider, and the cardholder’s device for the registration, notification, and delivery of transaction details.
  - User performs an API request to gather advice about a previous transaction that was made.
  - Refer to model classes for field level information.
        
    | URL | Method | Request | Response |
    | :-- | :----- | :------ | :------- |
    | `/services` | POST | [TransactionHistoryAdviceRequest](docs/TransactionHistoryAdviceRequest.md) | [TransactionHistoryAdviceResponse](docs/TransactionHistoryAdviceResponse.md) |

> Case 7: [FRAUD SERVICES ORIGINAL](https://developer.mastercard.com/direct-service/documentation/parameters/fraudservicesoriginal/)
  - A Fraud Services Original request supports the Mastercard Safety and Security Services “Fraud Service Safety Net, Fraud Rules Manage, Decision Intelligence, and Consumer Controls” and provides fraud scoring.
  - User performs an API request to request Mastercard fraud services to be performed for a particular transaction.
  - Refer to model classes for field level information.
        
    | URL | Method | Request | Response |
    | :-- | :----- | :------ | :------- |
    | `/services` | POST | [FraudServicesOriginalRequest](docs/FraudServicesOriginalRequest.md) | [FraudServicesOriginalResponse](docs/FraudServicesOriginalResponse.md) |

> Case 8: [FRAUD SERVICES ADVICE](https://developer.mastercard.com/direct-service/documentation/parameters/fraudservicesadvice/)
  - A Fraud Services Advice request supports customer generated advice to Mastercard when an original transaction is declined by an Issuer.
  - User performs an API request to gather advice about a previous fraud services original request (use case above) that was made.
  - Refer to model classes for field level information.
          
    | URL | Method | Request | Response |
    | :-- | :----- | :------ | :------- |
    | `/services` | POST | [FraudServicesAdviceRequest](docs/FraudServicesAdviceRequest.md) | [FraudServicesAdviceResponse](docs/FraudServicesAdviceResponse.md) |
  
> Case 9: [ERROR HANDLING](https://developer.mastercard.com/direct-service/documentation/code-and-formats/#error-structure)
  - An operation can fail for various reasons like formatting, field length exceeds, etc.
  - This use case just shows one of the example of such failures.
  - For the complete list of application specific error codes, refer to [Code And Formats](https://developer.mastercard.com/direct-service/documentation/code-and-formats/).
  - Also refer to model class [Errors](docs/Errors.md) for the field level information.    
    
## API Reference <a name="api-reference"></a>
To develop a client application that consumes a RESTful Direct Services Access API with Spring Boot, refer to the [API Reference](https://developer.mastercard.com/direct-service/documentation/api-reference/) page.

### Request Examples <a name="request-examples"></a>
To learn which fields are required for each use case request, refer to the documentation below.

| API Request Type | Endpoint | HTTP Method | Description |
| :-- | :------- | :---------- | :---------- |
| [All Fields/Combined](https://developer.mastercard.com/direct-service/documentation/parameters/allfields/) | `/services` | POST | User performs an API request with a combination of fields from different use cases below to execute multiple use cases simultaneously. |
| [E-Commerce](https://developer.mastercard.com/direct-service/documentation/parameters/ecommerce/) | `/services` | POST | Mastercard Digital Enablement Service (MDES) detokenization and crypto validation service for cardholders using digital device for an E-commerce purchase. |
| [In-Person](https://developer.mastercard.com/direct-service/documentation/parameters/inperson/) | `/services` | POST | An In-Person request performs a Mastercard Digital Enablement Service (MDES) detokenization and crypto validation service for cardholders using digital devices for in-store purchases via Contactless and Dynamic Magnetic Stripe payment methods. |
| [Reversal](https://developer.mastercard.com/direct-service/documentation/parameters/reversal/) | `/services` | POST | A Reversal request supports the reversal of a Mastercard Digital Enablement Service (MDES) Original transaction purchase made via E-commerce or In-Person DSA API request. |
| [Acquirer Advice](https://developer.mastercard.com/direct-service/documentation/parameters/acquireradvice/) | `/services` | POST | An Acquirer Advice request supports Acquirer generated advice to Mastercard when a Mastercard Digital Enablement Service (MDES) purchase transaction is declined by an Issuer. |
| [Transaction History Advice](https://developer.mastercard.com/direct-service/documentation/parameters/transactionhistoryadvice/) | `/services` | POST | A Transaction History Advice request allows a customer to provide transaction advice for the Transaction Details Service (TDS) after transaction processing. The TDS manages the interactions between Mastercard, the Wallet Provider, and the cardholder’s device for the registration, notification, and delivery of transaction details. |
| [Fraud Services Original](https://developer.mastercard.com/direct-service/documentation/parameters/fraudservicesoriginal/) | `/services` | POST | A Fraud Services Original request supports the Mastercard Safety and Security Services “Fraud Service Safety Net, Fraud Rules Manage, Decision Intelligence, and Consumer Controls” and provides fraud scoring. |
| [Fraud Services Advice](https://developer.mastercard.com/direct-service/documentation/parameters/fraudservicesadvice/) | `/services` | POST | A Fraud Services Advice request supports customer generated advice to Mastercard when an original transaction is declined by an Issuer. | 

You can change the default input passed to APIs, modify values in following files:
* `com.mastercard.developer.example.DirectServicesExample.java`

### Recommendation <a name="recommendation"></a>
It is recommended to create an instance of `ApiClient` per thread in a multi-threaded environment to avoid any potential issues.

## Support <a name="support"></a>
If you would like further information, please send an email to apisupport@mastercard.com.

## License <a name="license"></a>
Copyright 2020 Mastercard
 
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at:
 
       http://www.apache.org/licenses/LICENSE-2.0
 
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
