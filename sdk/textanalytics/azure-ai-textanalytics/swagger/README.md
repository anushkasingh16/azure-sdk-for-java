# Azure Cognitive Service - Text Analytics for Java

> see https://aka.ms/autorest

### Setup
```ps
Fork and clone https://github.com/Azure/autorest.java 
git checkout main
git submodule update --init --recursive
mvn package -Dlocal
npm install
npm install -g autorest
```

### Generation
```ps
cd <swagger-folder>
autorest
```

### Code generation settings
``` yaml
use: '@autorest/java@4.1.2'
input-file: https://raw.githubusercontent.com/Azure/azure-rest-api-specs/cognitiveservices-Language-2022-04-01-preview/specification/cognitiveservices/data-plane/Language/preview/2022-04-01-preview/textanalytics.json
java: true
output-folder: ..\
generate-client-as-impl: true
namespace: com.azure.ai.textanalytics
generate-client-interfaces: false
sync-methods: none
license-header: MICROSOFT_MIT_SMALL
add-context-parameter: true
models-subpackage: implementation.models
custom-types-subpackage: models
context-client-method-parameter: true
service-interface-as-public: true
generic-response-type: true
```
