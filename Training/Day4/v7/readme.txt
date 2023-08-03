This demonstration uses Openfeign, Eureka, Api-gateway, SpringCloud LoadBalancer, Resilience4J, Sleuth, Zipkin, Config Server

In MS architecture, there are a lot of MS. each one of them has their own configurations. Also, we need different configurations for different environments. 
Changing these confs by visiting application.properties file for that MS is practically impossible. Hence, we would like to keep these conf details at central location. and separate from each MS which can be managed by operations team. 

To do this, SpringCloud offers ConfigServer.
The idea is we are going to keep this conf info at one location centrally(Local File System or Git Repo)
By default, config server would search for git repo. 
Config Server would take the responsibility of reading the central configuration and exposing standard REST endpoints.
http://localhost:8888/application/default 


Steps to use Config Server
1. Create new Spring Boot project
2. Add appropriate dependencies.  (ConfigServer, Eureka Client)
3. Enable config server by annotating Application class with @EnableConfigServer
4. Add appropriate properties

Once Config Server is setup, we need to configure MSs so that they can pick values from Config server. 
To do this, each MS must act as client to config server. 

Steps to define config server client-
1. Add appropriate dependencies in each MS.
2. add appropriate  properties in application.properties file
3. 