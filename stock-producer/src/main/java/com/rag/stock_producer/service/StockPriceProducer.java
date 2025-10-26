package com.rag.stock_producer.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockPriceProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;
    public StockPriceProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${app.kafka.topic.name}")
    private String topicName;

    public void sendStockPrice(String symbol, double price){
        String message = symbol + ":" + price;
        kafkaTemplate.send(topicName, message);
        System.out.println("Sent to Kafka: " + message);
    }


}
