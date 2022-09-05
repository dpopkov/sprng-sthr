# sprng-sthr
Repo for learning Spring projects.

[Spring Reference](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

## Contents
* [2 - The Spring context - defining beans](#2---the-spring-context---defining-beans)
    * [Using the @Bean annotation to add beans into the Spring context](#using-the-bean-annotation-to-add-beans-into-the-spring-context)
    * [Using stereotype annotations to add beans to the Spring context](#using-stereotype-annotations-to-add-beans-to-the-spring-context)
    * [Programmatically adding beans to the Spring context](#programmatically-adding-beans-to-the-spring-context)
* [3 - The Spring context: Wiring beans](#3---the-spring-context-wiring-beans)
    * [Wiring the beans using a direct method call between the @Bean methods](#wiring-the-beans-using-a-direct-method-call-between-the-bean-methods)
    * [Wiring the beans using the @Bean annotated method's parameters](#wiring-the-beans-using-the-bean-annotated-methods-parameters)
    * [Using @Autowired to inject beans through constructor](#using-autowired-to-inject-beans-through-constructor)
    * [Choosing from multiple beans in the Spring context](#choosing-from-multiple-beans-in-the-spring-context)
* [4 - The Spring context: Using abstractions](#4---the-spring-context-using-abstractions)
    * [Using interfaces to define contracts](#using-interfaces-to-define-contracts)
    * [Using dependency injection with abstractions](#using-dependency-injection-with-abstractions)
* [6 - Using Aspects with Spring AOP](#6---using-aspects-with-spring-aop)
    * [Intercepting annotated methods](#intercepting-annotated-methods)
    * [The aspect execution chain](#the-aspect-execution-chain)
* [7 - Understanding Spring Boot and Spring MVC](#7---understanding-spring-boot-and-spring-mvc)
    * [Implementing a web app with Spring MVC](#implementing-a-web-app-with-spring-mvc)
* [8 - Implementing web apps with Spring Boot and Spring MVC](#8---implementing-web-apps-with-spring-boot-and-spring-mvc)
    * [Implementing web apps with a dynamic view using Thymeleaf template engine](#implementing-web-apps-with-a-dynamic-view-using-thymeleaf-template-engine)
    * [Getting data on the HTTP request](#getting-data-on-the-http-request)
* [9 - Using the Spring web scopes](#9---using-the-spring-web-scopes)
* [10 - Implementing REST services](#10---implementing-rest-services)
    * [Sending objects as a response body](#sending-objects-as-a-response-body)
    * [Setting the response status and headers](#setting-the-response-status-and-headers)
    * [Managing exceptions at the endpoint level](#managing-exceptions-at-the-endpoint-level)
    * [Using a request body to get data from the client](#using-a-request-body-to-get-data-from-the-client)
* [11 - Consuming REST endpoints](#11---consuming-rest-endpoints)
    * [Calling REST endpoints using Spring Cloud OpenFeign](#calling-rest-endpoints-using-spring-cloud-openfeign)
    * [Calling REST endpoints using RestTemplate](#calling-rest-endpoints-using-resttemplate)
* [12 - Using data sources in Spring apps](#12---using-data-sources-in-spring-apps)
    * [Using JdbcTemplate to work with persisted data](#using-jdbctemplate-to-work-with-persisted-data)
    * [Define the data source in the application properties file](#define-the-data-source-in-the-application-properties-file)
    * [Using a custom DataSource bean](#using-a-custom-datasource-bean)
* [13 - Using transactions in Spring apps](#13---using-transactions-in-spring-apps)
* [14 - Implementing data persistence with Spring Data](#14---implementing-data-persistence-with-spring-data)

## 2 - The Spring context - defining beans
* Project: [c02e01beans](c02e01beans)

### Using the @Bean annotation to add beans into the Spring context
1. Define a configuration class (annotated with `@Configuration`) for your project - [ProjectConfig](c02e01beans/src/main/java/learn/sprng/sthr/c02e01beans/ProjectConfig.java).
2. Add a method to the config class that returns the object instance and annotate it with `@Bean` annotation.
3. Make Spring use the configuration class defined in step 1 - [Main](c02e01beans/src/main/java/learn/sprng/sthr/c02e01beans/Main.java).

### Using stereotype annotations to add beans to the Spring context
* Project: [c02e07stereotype](c02e07stereotype)

1. Using the `@Component` annotation, mark the classes for which you want Spring to add an instance to its context.
2. Using `@ComponentScan` annotation over the configuration class, instruct Spring on where to find classes - [ProjectConfig](c02e07stereotype/src/main/java/learn/sprng/sthr/c02e07stereotype/ProjectConfig.java).

### Programmatically adding beans to the Spring context
* Project: [c02e08register](c02e08register)

1. Create the instance you want to add to the Spring context.
2. Call the `context.registerBean()` method to add the instance to the Spring context - [Main](c02e08register/src/main/java/learn/sprng/sthr/c02e08register/Main.java)

[TOC](#contents)

## 3 - The Spring context: Wiring beans
* Project: [c03e01wiring](c03e01wiring)

### Wiring the beans using a direct method call between the @Bean methods
* `person.setParrot(parrot());`
* [ProjectConfig.java](c03e01wiring/src/main/java/learn/sprng/sthr/c03e01wiring/ProjectConfig.java)

### Wiring the beans using the @Bean annotated method's parameters
Add a parameter to the method of the corresponding type of object, and rely on Spring
to provide a value through that parameter.
* `public Person person(Parrot parrot) {}`
* [ProjectConfig.java](c03e01wiring/src/main/java/learn/sprng/sthr/c03e01wiring/ProjectConfig.java)

### Using @Autowired to inject beans through constructor
* Define a constructor for the class and annotate it with `@Autowired` if you have more than one
* Project: [c03e02constructor](c03e02constructor)

### Choosing from multiple beans in the Spring context
* Project: [c03e10qualifier](c03e10qualifier)
* Explicitly select a specific bean using the `@Qualifier` annotation: [Person.java](c03e10qualifier/src/main/java/learn/sprng/sthr/c03e10qualifier/Person.java)

[TOC](#contents)

## 4 - The Spring context: Using abstractions

### Using interfaces to define contracts
* Project: [c04e01nospring](c04e01nospring)

### Using dependency injection with abstractions
* Project: [c04e02spring](c04e02spring)

[TOC](#contents)

## 6 - Using Aspects with Spring AOP
* Project: [c06e01aspects](c06e01aspects)

1. Enable the aspect mechanism in your Spring app by annotating the configuration class with the `@EnableAspectJAutoProxy`
annotation.
2. Create a new class, and annotate it with the `@Aspect` annotation. Using either `@Bean` or stereotype annotations, 
add a bean for this class in the Spring context.
3. Define a method to implement the aspect logic, and use an advice annotation to tell Spring when and what to intercept.
3. Implement the Aspect logic.

### Intercepting annotated methods
* Project: [c06e04annotation](c06e04annotation)

1. Define a custom annotation, and make it accessible at runtime.
2. Use AspectJ pointcut expression for the aspect method to intercept the methods annotated with the custom annotation.
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ToLog {
}
```
```java
@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(learn.sprng.sthr.c06e04annotation.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) {
        // code
    }
}
```

### The aspect execution chain
* To control the order in which aspects execute use annotation `@Order`
* Project: [c06e06order](c06e06order)
```java
@Component
@Aspect
@Order(100)
public class SecurityAspect {
    //...
}
```

[TOC](#contents)

## 7 - Understanding Spring Boot and Spring MVC

### Implementing a web app with Spring MVC
* Project: [c07e01boot](c07e01boot)

## 8 - Implementing web apps with Spring Boot and Spring MVC

### Implementing web apps with a dynamic view using Thymeleaf template engine
* Project: [c08e01mvc](c08e01mvc)

### Getting data on the HTTP request
* Request parameters: `@RequestParam`
* Path variables: `@GetMapping("/home/{value}")`

[TOC](#contents)

## 9 - Using the Spring web scopes
* Project: [c09e01scopes](c09e01scopes)

### Request scope
* Annotation `@RequestScope`

### Session scope
* Annotation `@SessionScope`

[TOC](#contents)

## 10 - Implementing REST services
* Project: [c10e01rest](c10e01rest)

### Sending objects as a response body
* Method annotation: `@ResponseBody`
* Class annotation: `@RestController`

### Setting the response status and headers
* Using `ResponseEntity`
```java
return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .header("Continent", "Asia")
        .header("Capital", "Beijing")
        .body(country);
```

### Managing exceptions at the endpoint level
* Use class annotation `@RestControllerAdvice`
* Use handler method annotation `@ExceptionHandler`
* You can add a parameter to the advice’s exception handler method of the type of the handled exception.
```java
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
        ErrorDetails details = new ErrorDetails();
        details.setMessage("Not enough money to make the payment");
        return ResponseEntity
                .badRequest()
                .body(details);
    }
}
```

[TOC](#contents)

### Using a request body to get data from the client
* Use parameter annotation `@RequestBody`
```java
public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails) {
    PaymentDetails details = paymentService.processPayment(paymentDetails);
    return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(details);
}
```
* Use curl for testing: `curl -v -X POST localhost:8080/payment -d '{"amount":100}' -H "Content-Type: application/json"`

[TOC](#contents)

## 11 - Consuming REST endpoints

* REST service project that exposes a payment service to consume: [c11e01payments](c11e01payments)

### Calling REST endpoints using Spring Cloud OpenFeign
To implement the REST endpoint call we need to define an interface and use annotations to instruct OpenFeign
on how to implement this interface.
* Project: [c11e02openfeign](c11e02openfeign)
* Create the proxy interface using the same annotations that expose REST endpoints (PostManning, RequestHeader, RequestBody):
```java
@FeignClient(name = "paymentsProxy",
             url = "${name.service.url}")
public interface PaymentsProxy {
    @PostMapping("/payment")
    Payment createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    );
}
```
* Use the `@EnableFeignClients` annotation on a configuration class to enable the OpenFeign functionality:
```java
@Configuration
@EnableFeignClients(basePackages = "learn.sprng.sthr.c11e02openfeign.proxy")
public class ProjectConfig {
}
```
* Inject and use the OpenFeign client through the interface:
```java
@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;
    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }
    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);
    }
}
```

[TOC](#contents)

### Calling REST endpoints using RestTemplate
* Project: [c11e03resttemplate](c11e03resttemplate)
* Define the HTTP headers by creating and configuring an `HttpHeaders` instance.
* Create an `HttpEntity` instance that represents the request data (headers and body).
* Send the HTTP call using the `exchange()` method and get the HTTP response.
```java
public Payment createPayment(Payment payment) {
    String uri = paymentsServiceUrl + "/payment";
    HttpHeaders headers = new HttpHeaders();
    headers.add("requestId", UUID.randomUUID().toString());
    HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);
    ResponseEntity<Payment> response = restTemplate.exchange(uri,
            HttpMethod.POST,
            httpEntity,
            Payment.class);
    return response.getBody();
}
```

[TOC](#contents)

## 12 - Using data sources in Spring apps

### Using JdbcTemplate to work with persisted data
* Project: [c12e01jdbctemplate](c12e01jdbctemplate)
* Use `update()` method for data mutation (insert, update, delete):
```java
public void save(Purchase purchase) {
    final String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";
    jdbcTemplate.update(sql,
            purchase.getProduct(),
            purchase.getPrice());
}
```
* Use `query()` method for select:
```java
public List<Purchase> findAll() {
    final RowMapper<Purchase> rowMapper = (resultSet, i) -> {
        Purchase p = new Purchase();
        p.setId(resultSet.getInt("id"));
        p.setProduct(resultSet.getString("product"));
        p.setPrice(resultSet.getBigDecimal("price"));
        return p;
    };
    return jdbcTemplate.query("SELECT id, product, price FROM purchase", rowMapper);
}
```

[TOC](#contents)

### Define the data source in the application properties file
* Configure Datasource: `spring.datasource.url=jdbc:postgresql://localhost:5432/postgres`
* Use environment variables DB_USERNAME and DB_PASSWORD:
```properties
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```
* Set initialization mode to "always" to run "schema.sql": `spring.sql.init.mode=always`

### Using a custom DataSource bean

Scenarios in which you need to define the bean:
* You need to use a specific DataSource implementation based on a condition you can only get at runtime.
* Your app connects to more than one database, so you have to create multiple data sources and distinguish them using qualifiers.
* You have to configure specific parameters of the DataSource object in certain conditions your app has only at runtime.
For example, depending on the environment where you start the app, you want to have more or fewer connections 
in the connection pool for performance optimization.
* Your app uses Spring framework but not Spring Boot.

```java
@Configuration
public class ProjectConfig {
    @Value("${custom.datasource.url}")
    private String datasourceUrl;
    @Value("${custom.datasource.username}")
    private String datasourceUsername;
    @Value("${custom.datasource.password}")
    private String datasourcePassword;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        dataSource.setConnectionTimeout(1000);
        return dataSource;
    }
}
``` 

[TOC](#contents)

## 13 - Using transactions in Spring apps
* Project: [c13e01transactional](c13e01transactional)
* Use method and class annotation `@Transactional` at use case (service) level.

## 14 - Implementing data persistence with Spring Data

### Using Spring Data JDBC
* Project: [c14e01springdatajdbc](c14e01springdatajdbc)
* Add dependency for `<artifactId>spring-boot-starter-data-jdbc</artifactId>`
* Use for extension `CrudRepository` or `PagingAndSortingRepository`
* Spring Data provides implementations
* Use query method relying on Spring Data translating
* Use SQL queries:
```java
@Query("SELECT * FROM account WHERE name = :name")
List<Account> findByName(String name);
```
```java
@Modifying
@Query("UPDATE account SET amount = :amount WHERE id = :id")
void changeAmount(Integer id, BigDecimal amount);
```

[TOC](#contents)
