This demonstration uses Openfeign, Secured Eureka, Api-gateway, SpringCloud LoadBalancer, Resilience4J, Sleuth, Zipkin, Config Server, SpringCloudBus

Eureka is very imp and essential application in the MS architecture. Hence we have to take care of the following 2 things. 
1. Security of Eureka. - The idea is each MS trying to register itself must authenticate with Eureka first. If authentication is successful, then only Eureka allows the MS to register with itself. 



Steps to do this-
- Add the security dependency in eureka application - SpringSecurity
- Add appropriate username and password
- Write configuration class
- Each MS must be passing username and password while connecting to eureka. 

2. To avoid single point of failure - We must have cluster of Eureka servers.  
