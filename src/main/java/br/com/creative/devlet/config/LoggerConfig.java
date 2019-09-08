package br.com.creative.devlet.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static java.util.Optional.of;
import static org.slf4j.LoggerFactory.getLogger;

@Configuration
public class LoggerConfig {
    @Bean
    public Logger logger(InjectionPoint ip) {

        try {
            return getLogger(of(ip.getMember())
                    .map(o -> o.getDeclaringClass())
                    .orElseThrow(IllegalArgumentException::new));
        }
        catch (Exception e) {
            System.err.printf("slf4j autowired Exception occured : %s%n", e.getMessage());
            throw e;
        }
    }
}
