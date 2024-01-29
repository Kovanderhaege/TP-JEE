package junia.lab05.data.config;

import junia.lab05.core.config.CoreConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CoreConfig.class)
public class DataConfig {
}
