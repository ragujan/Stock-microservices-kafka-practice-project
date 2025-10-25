package com.rag.stock_producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    private final StockPriceProducer producer;

    public StockController(StockPriceProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/send")
    public String sendStockPrice(@RequestParam(name = "symbol") String symbol, @RequestParam(name = "price") double price) {
        producer.sendStockPrice(symbol, price);
        return "✅ Sent stock update for " + symbol + " at price " + price;
    }
}