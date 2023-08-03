This demonstration uses Openfeign, Eureka, Api-gateway, SpringCloud LoadBalancer, Resilience4J, Sleuth, Zipkin

Because MS architecture is distributed, tracing a specific request would be a challenge. 
In order to keep track of distributed tracing, SpringCloud offers Sleuth.
The idea is each request has a specific ID across all the MS and within a MS and by default Sleuth logs that on console with these 2 IDs and application name.

Steps to use Sleuth -
1. Add appropriate dependency in each of the MS along with api-gateway.


 [order-service,ad34305e0af746d5,ee01c777ca53e373]  // service name, trace ID, span ID

 [coupon-service,ad34305e0af746d5,fb59fca1a82b74d6] // service name, trace ID, span ID

Trace ID is unique across all MS for each request.
Span ID is unique for each request within that MS. 
Sleuth is doing this.


These logs are generated and we want to consolidate them and show them at a central location in GUI form. To exactly do this, we have Zipkin. 

Steps to use Zipkin-
1. Download Zipkin server
2. Run Zipkin server

http://localhost:9411/zipkin/

3. Add appropriate dependency in each of the MS and api-gateway 
4. Add property to specify Zipkin Server URL in each MS. If we are going with defaults, writing this property is optional.
	 spring.zipkin.base-url=http://localhost:9411/
	

       
