package com.rag.stock_producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class StockPriceGenerator {

    private final KafkaSender kafkaSender;
    private final Random random = new Random();
    private final List<String> stocks = List.of("AAPL", "GOOG", "TSLA", "MSFT");
    @Value("${app.kafka.topic.name}")
    private String topicName;
    public StockPriceGenerator(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @Scheduled(fixedRate = 3000)
    public void generatePrices() {
        String symbol = stocks.get(random.nextInt(stocks.size()));
        double price = 100 + random.nextDouble() * 1000;
        String message = symbol + ":" + String.format("%.2f", price);
        kafkaSender.send(topicName, message);
        System.out.println("📈 Sent: " + message);
    }
}