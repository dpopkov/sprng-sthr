# sprng-sthr
Repo for learning Spring projects.

[Spring Reference](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

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

## 4 - The Spring context: Using abstractions

### Using interfaces to define contracts
* Project: [c04e01nospring](c04e01nospring)

### Using dependency injection with abstractions
* Project: [c04e02spring](c04e02spring)

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

## 7 - Understanding Spring Boot and Spring MVC

### Implementing a web app with Spring MVC
* Project: [c07e01boot](c07e01boot)

## 8 - Implementing web apps with Spring Boot and Spring MVC

### Implementing web apps with a dynamic view using Thymeleaf template engine
* Project: [c08e01mvc](c08e01mvc)

### Getting data on the HTTP request
* Request parameters: `@RequestParam`
* Path variables: `@GetMapping("/home/{value}")`

## 9 - Using the Spring web scopes
* Project: [c09e01scopes](c09e01scopes)

### Request scope
* Annotation `@RequestScope`

### Session scope
* Annotation `@SessionScope`

## 10 - Implementing REST services
* Project: [c10e01rest](c10e01rest)

### Sending objects as a response body
* Method annotation: `@ResponseBody`
* Class annotation: `@RestController`

