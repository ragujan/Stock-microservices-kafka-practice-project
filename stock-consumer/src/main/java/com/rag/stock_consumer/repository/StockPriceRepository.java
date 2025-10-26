package com.rag.stock_consumer.repository;

import com.rag.stock_consumer.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> { }