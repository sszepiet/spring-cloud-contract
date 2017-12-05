package pl.sii.eu.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import pl.sii.eu.producer.service.CurrentTimeService;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    @Profile("!validation-test")
    public CurrentTimeService currentTimeService() {
        return ZonedDateTime::now;
    }

    @Bean
    @Profile("validation-test")
    public CurrentTimeService currentTimeServiceForValidationTest() {
        return () -> ZonedDateTime.of(2017, 12, 4, 20, 51, 34, 0, ZoneId.of("UTC"));
    }
}
