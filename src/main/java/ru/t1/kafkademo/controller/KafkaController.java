package ru.t1.kafkademo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.kafkademo.service.ProducerService;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final ProducerService producerService;

    @PostMapping("/send")
    public String send(@RequestParam(required = false) String message) {
        if (!StringUtils.hasText(message)) {
            producerService.sendRandomFruit();
            return "Отправлено случайное сообщение";
        } else {
            producerService.send(message);
            return "Отправлено сообщение: " + message;
        }
    }

}
