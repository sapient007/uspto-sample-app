This is a sample app using SpringBoot and Thymeleaf. By default, the sample app uses a basic "in-memory"
database (h2) for prototyping purposes.

## Pre-Requisites 
Create a data service named `patent-data-service` (to use a relational database)

# Demo Steps
This sample application is aimed at demostrating:
* Push Applications
* Scaling Application
* Service Binding Operations

## Pushing Applications
Run the command `cf push`

## Scaling Applications
Run the command `cf scale -i 5 -m 1GB -f`. This will scale the app to 5 instances each with 1GB of memory.

## Bind Data Service
Running `cf bind-service uspto-patent-search patent-data-service` followed by `cf restage`, thus showing usage of the new data set.
