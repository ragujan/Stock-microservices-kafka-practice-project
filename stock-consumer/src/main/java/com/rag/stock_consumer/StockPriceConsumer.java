package com.rag.stock_consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockPriceConsumer {

    @KafkaListener(topics = "${app.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        System.out.println("📩 Received from Kafka: " + message);
    }
}