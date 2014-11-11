# Patent Search Sample Application
This sample application demonstrates the use of SpringBoot and Thymeleaf. These can be easily deployed in CloudFoundry and can demonstrate powerful features such as:

* Push Applications. 
* Scaling Application. 
* Service Binding Operations. 
* HA features. 

## Building the Application
Run the command `mvn package`

## Demo Features
### Pushing Applications
Run the command `cf push`.  
Notice that the `manifest.yml` file will be used for this. Furthermore, it will deploy the sample application with an "in-memory" database with "dummy" data.

### Scaling Applications
Run the command `cf scale -i 5 -m 1GB -f`. This will scale the app to 5 instances each with 1GB of memory. 

:bulb: It helps a lot when you are able to show "real-time" scaling operations using the "watch" command on a console. If you are doing this, I recommend setting `CF_COLORS=false`. 

### Bind Data Service
Running `cf bind-service uspto-patent-search patent-data-service` followed by `cf restage`, thus showing usage of the new data set in the newly bound "service".

:warning: To test using real data, it is __strongly__ recommended to build the "micro-service" project in the parent project. In particular, the "datagov-crawler" as it will load valid data into this data service.

### DevOps Use Case


References: 
1. https://github.com/cloudfoundry/cf-java-client/tree/master/cloudfoundry-maven-plugin 
2. https://github.com/albertoaflores/jenkins-vagrant-server 

