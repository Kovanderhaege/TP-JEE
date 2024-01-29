package junia.lab05.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "junia.lab05.core.dao")
@EntityScan(basePackages = "junia.lab05.core.entity")
@ComponentScan(basePackages = "junia.lab05.core.service")
public class CoreConfig {
}

