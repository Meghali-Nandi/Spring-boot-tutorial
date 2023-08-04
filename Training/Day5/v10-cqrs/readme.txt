CQRS - Command Query Responsibility Segregation.

The idea is very simple. We should divide our application into two parts -
1. Command - responsible for altering the state of an object
2. Query - responsible for retrieving the state of an object.

The idea is to have 2 independent separate applications with 2 independent separate databases. One which is finetuned for write operations and the second one for optimising the read operations. 
For eg - coupon-command-service, coupon-query-service
---------------

Command-
Command is combination of intent (what we want to be done) as well as the information required to do that action based on the intent. 

Naming convention for command is - 
verb in imperative mode followed by entity we are dealing with followed by "command" -> Eg. CreateCouponCommand, RegisterCouponCommand,TransferCouponCommand


-------------------

Query-
Query express the desire of information. 

Naming convention-
Verb followed by entity we are dealing with followed by "query" -> Eg - FindCouponQuery


-----------------------

Axon framework-
It is used to simplify event-driven MSs based on CQRS. 
it can be used with SpringBoot by adding one dependnecy.

Steps to use Axon-
1. Download Axon server 
2. Run it
3. Add appropriate dependency (axon-springboot-starter) and google-guava (from internet maven dependency)

Aggregated Object -
This object is responsible for raising the event 
Aggregate object also provides command handler.


Event is an object that describes something has happened or occured in the application. Source of event is aggregate. 
Convention for event is - entity name + verb in past tense form  + "event" -> Eg-CouponCreatedEvent

