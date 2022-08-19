# sprng-sthr
Repo for learning Spring projects.

[Spring Reference](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

## The Spring context - defining beans
* [c02e01beans](c02e01beans)

### Using the @Bean annotation to add beans into the Spring context
1. Define a configuration class (annotated with `@Configuration`) for your project.
2. Add a method to the config class that returns the object instance and annotate it with `@Bean` annotation.
3. Make Spring use the configuration class defined in step 1.
