# Camel based implementation of the _sap_ API

## API Description ##
A brand new API with no content.  Go nuts!

### Building

    mvn clean package

### Running Locally

    mvn spring-boot:run

Getting the API docs:

    curl http://localhost:8080/openapi.json

## Running on OpenShift

    mvn oc:deploy

You can expose the service externally using the following command:

    oc expose svc sap

And then you can access it's OpenAPI docs hosted by the service at:

    curl -s http://$(oc get route sap --template={{.spec.host}})/openapi.json

