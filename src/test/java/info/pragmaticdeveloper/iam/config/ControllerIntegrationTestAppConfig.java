package info.pragmaticdeveloper.iam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "info.pragmaticdeveloper.iam",
        lazyInit = true)
public class ControllerIntegrationTestAppConfig {
}
