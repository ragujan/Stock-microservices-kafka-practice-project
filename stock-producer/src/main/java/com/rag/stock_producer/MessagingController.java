package com.rag.stock_producer;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingController {
    private final KafkaSender kafkaSender;

    public MessagingController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }
    @GetMapping("/test")
    public String testMessage(@RequestParam("message") String message) {
        System.out.println("send message "+message);
        return "Message sent!";
    }
    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        System.out.println("send message "+message);
        kafkaSender.send("test-topic", message);
        return "Message sent!";
    }
}
