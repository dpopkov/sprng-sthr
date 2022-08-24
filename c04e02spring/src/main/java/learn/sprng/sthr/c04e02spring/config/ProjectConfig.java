package learn.sprng.sthr.c04e02spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "learn.sprng.sthr.c04e02spring.repositories",
        "learn.sprng.sthr.c04e02spring.services"})
public class ProjectConfig {
}
