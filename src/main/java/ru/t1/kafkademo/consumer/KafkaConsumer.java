package ru.t1.kafkademo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class KafkaConsumer {

    @Bean
    public Consumer<String> receive() {
        return message -> log.info("Received: {}", message);
    }

}
