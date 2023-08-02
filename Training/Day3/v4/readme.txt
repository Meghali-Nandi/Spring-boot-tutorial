This demonstration uses Openfeign, eureka server

Hardcoding url in feign client is a bad design choice as it tightly couples to one particular instance of the MS. 
Which means scaling up/down wont work. 
In MS architecture, it is very common to spin up multiple instances of a MS if needed and spin down if the need is over and hence we cannot keep track of port numbers of all the instances running on. 
To solve this problem, we have a design pattern ServiceDiscovery
- The idea is each MS registers itself with ServiceDiscovery with some unique name
- The client MS now can just use the logical name as it is registered with DiscoveryService to connect to that MS. 
- One of the most popular and respected ServiceDiscovery is Eureka from Netflix.


Steps to use Eureka server-
- Create a new SpringBoot project.
- Add appropriate dependency. - (Eureka Server)
- Enable Eureka server by annotating Application class with @EnableEurekaServer
- Chnage the port to 8761 (not mandate but recommended)

To test Eureka service running with - http://localhost:8761

Note- By default, Eureka client register themselves with unknown name.
Steps for eureka clients-
- Add appropriate dependencies - (eureka-dicovery-client)
- Add a property in application.properties to give appropriate name to each MS. 
- Add a property to application.properties to specify url of Eureka server
- Annotate application class with @EnableEurekaClient (This is optional step but recommended for better readability)


It is very common to spin up multiple instances of multiple MS and to spin down also. Hence it is practically impossible to keep track of the port numbers and change them manually by visiting application.properties file. 

To dynamically assign the unused ports, we have to follow steps given below-
- In application.properties of each MS, write server.port=0
By default, every instance has one ID associated with it while registering with eureka. We need to make sure the ID is unique for every instance. To do that, we have to add the following properties in application.properties file-
	eureka.instance.instance-id=${spring.application.name}:${random.value}


_____________________________________________________________________________________



API-gateway-

This demonstration uses OpenFeign, Eureka, Api gateway
Dynamically assigning ports are good for scaling up and scaling down, but while accessing from client we must give 
- a constant fixed url

To exactly solve this problem, we use api gateway

Api gateway is used to route request from clients to microservices
Also microservices communication should be routed via api gateway.
We will be just exposing port and ip of api gateway to client application.
If we want to run common code for all MS, we will be writing that in Api gateway.(logging, authorization, authentication)
Api gateway can also be used as load balancer.

Steps for api gateway
1. Create a new springboot project
2. Add appropriate dependencies(eureka discovery client, gateway)
3. add application.properties
