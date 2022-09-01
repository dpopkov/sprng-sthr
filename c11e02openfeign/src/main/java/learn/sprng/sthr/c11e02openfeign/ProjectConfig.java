package learn.sprng.sthr.c11e02openfeign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "learn.sprng.sthr.c11e02openfeign.proxy")
public class ProjectConfig {
}
