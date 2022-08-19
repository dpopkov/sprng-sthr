package learn.sprng.sthr.c02e01beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Poppo");
        return p;
    }

    @Bean(name = "riki")
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Riki");
        return p;
    }

    @Bean("tiki")
    Parrot parrot3() {
        var p = new Parrot();
        p.setName("Tiki");
        return p;
    }

    @Bean
    @Primary
    String hello() {
        return "Hello";
    }

    @Bean
    String goodbye() {
        return "Goodbye";
    }

    @Bean
    Integer twenty() {
        return 20;
    }
}
