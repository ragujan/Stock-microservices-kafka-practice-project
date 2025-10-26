package com.rag.stock_consumer.service;

import com.rag.stock_consumer.model.StockPrice;
import com.rag.stock_consumer.repository.StockPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StockPriceConsumerService {
    private final StockPriceRepository repository;

    @KafkaListener(topics = "${app.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        System.out.println("📩 Received from Kafka: " + message);

        String[] parts = message.split(":");
        String symbol = parts[0];
        double price = Double.parseDouble(parts[1]);

        StockPrice stockPrice = new StockPrice();
        stockPrice.setPrice(price);
        stockPrice.setSymbol(symbol);
        stockPrice.setTimestamp(LocalDateTime.now());
        repository.save(stockPrice);
        System.out.println("💾 Saved to DB: " + stockPrice);

    }
}