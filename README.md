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
[ProjectConfig.java](c03e01wiring/src/main/java/learn/sprng/sthr/c03e01wiring/ProjectConfig.java)
