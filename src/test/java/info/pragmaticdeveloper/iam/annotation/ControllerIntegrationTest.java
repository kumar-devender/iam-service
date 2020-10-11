package info.pragmaticdeveloper.iam.annotation;

import info.pragmaticdeveloper.iam.config.ControllerIntegrationTestAppConfig;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.flywaydb.test.annotation.FlywayTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = ControllerIntegrationTestAppConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FlywayTest
@AutoConfigureEmbeddedDatabase
@ActiveProfiles(profiles = "integration-test")
public @interface ControllerIntegrationTest {
}
