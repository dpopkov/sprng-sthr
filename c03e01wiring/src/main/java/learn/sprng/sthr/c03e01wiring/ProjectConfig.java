package learn.sprng.sthr.c03e01wiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Sparrow");
        return p;
    }

    @Bean
    public Person person() {
        Person p = new Person();
        p.setName("James");
        p.setParrot(parrot());
        return p;
    }
}
