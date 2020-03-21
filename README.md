# openwt
Spring boots test for OpenWT.

## Test requirements

The back-end is RESTFUL api with specific requirements :

Requirement 1

Create an CRUD endpoint for managing boat. A boat should have at least the following
attributes and appropriate validation:
• Name
• Description

Requirement 2

Implement the following security aspects.
• Authentication / Authorization (only authenticated user can access to the resources )

## How to deploy

First generate the target with maven package:

````
mvn package
````

Then you run docker build & push

````
docker build -t adrianospadoni/openwt:latest .
docker push adrianospadoni/openwt:latest
````

To deploy to production connect to the raspberry server and run the docker:

````
ssh user@ip.to.rasperry
docker stop $(docker ps -q --filter ancestor=adrianospadoni/openwt:latest)
docker run -p 8090:8090 -t adrianospadoni/openwt:latest
````


