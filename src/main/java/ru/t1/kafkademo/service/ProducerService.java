package ru.t1.kafkademo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {

    private final StreamBridge streamBridge;
    private static final List<String> FRUITS = List.of("apple", "banana", "pear", "orange", "grape");
    private final Random random = new Random();

    public void sendRandomFruit() {
        String fruit = FRUITS.get(random.nextInt(FRUITS.size()));
        send(fruit);
    }

    public void send(String message) {
        streamBridge.send("send-out-0", message);
        log.info("Sent message: {}", message);
    }
}