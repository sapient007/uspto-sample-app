uspto-sample-app
================

This is a sample application using Spring Boot. It demonstrates the use of "MicroServices". It works very well when deployed in CloudFoundry.

## Deployment Steps:

* Create a data service named `patent-data` in CloudFoundry.
* Build both projects independently using `mvn clean package`. This should create both jar and war files needed. 
* Run `cf push` from the root directory. The `manifest.yml` contains all info needed.

Notice that because these projects are built using SpringBoot, you can import them into STS and run them locally as well.

