This demonstration uses Openfeign, Eureka, Api-gateway, SpringCloud LoadBalancer, Resilience4J, Sleuth, Zipkin, Config Server, SpringCloudBus

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


Making any change to any configuration to the Central repo wont be picked up dynamically by MSs. In order to those canges to reflect,  MS needs to restart. 
This is impractical. Hence we want changes to be picked up dynamically. To so this we have to follow below steps. 
1. Add actuator dependency in MS. 
2. Expose refresh endpoint using application.properties. 
3. Annotate the class which is using this propoerty with @RefreshScope.
4. Hit post request to http://localhost:<port of MS>/actuator/refresh or http://localhost/order-service/actuator/refresh

In the above approach, changes would be picked up dynamically only by one specific MS for which we are hitting refresh endpoint. 
It is possible that there are conf changes for multiple MS. In order to pick up those changes by all the MS, we have to hit post request to refresh endpoint for all the MSs individually. 
To solve this problem, SpringCloud offers SpringCloudBus. 
The idea is with just one endpoint, we should be able to update configuration changes to all the MSs at once. 

SpringCloudBus links MSs which are distributed with a message broker. This is done to broadcast conf changes. 

Steps-
1. Download and install message broker.(RabbitMQ)
2. ./rabbitmq-plugins enable rabbitmq_management
./rabbitmq-server start
http://localhost:15672 - guest/guest

3. Add Actuator dependency in SpringCloud config server. 
4. Add SpringCloudStarter Bus AMQP dependency in config server and each of the MSs.
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-bus-amqp</artifactId>
		</dependency>

5. Add properties for rabbitMQin the properies file in config server and each of the MSs (Writing this property is optional if we are going for default confs)
6. xpose busrefresh endpoint using application.properties (config-server)
management.endpoints.web.exposure.include=busrefresh

7. Hit the post request to http://localhost/config-server/actuator/busrefresh