package ee.bcs.valiit.trikad;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@ImportResource({"classpath*:applicationContext.xml"})
@EnableWebSecurity
public class XMLConfiguration {
}

