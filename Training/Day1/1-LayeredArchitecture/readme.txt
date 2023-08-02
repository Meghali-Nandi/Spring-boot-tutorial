Layered architecture is the most common architecture
The idea is divide the application into fferent components with similar functionalitiesAnd these are rther grouped under same name
as a result, each layer performs a specific functionality


Eg- service, DAO, GUI

Every object in spring container is called a bean.
Once the bean container is ready, we can ask for the specific bean type using the getBean method


Steps to use Spring-

1. Add appropriate jars
2. Create config classes for specific modules

Though initially spring was written for dependency injection, with time it has evolved and added many features. But to use these features, we have to do configurations.
And these cofigs can be time consuming, error prone and repeatitive. 
To solve this problem, spring team has come up with Spring Boot which takes care of automatic configs whenever possible. 

In order to register classes as Spring bean, you must annotate it with Sterotype annotations based on the role they are performing.

@Repository - this annotation is used on top of DAO classes. Hence they are also named as repository classes.



Spring data JPA-
1. Add dependency
2. write appropriate application properties
3. annotate JPA class with appropriate JPA annotation
4. Write an interface. Extend this interface from JPA reporistory interface.


Spring data JPA gives built-in interface like JPA repository which we need to extend in our own interface
This interface gives us built-in methods for CRUD operations.
We dont have to write implementation to this interface. 
