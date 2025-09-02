package com.arthur.stocktracer.service;

import com.arthur.stocktracer.client.StockClient;
import com.arthur.stocktracer.dto.StockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockClient stockClient;

    @Autowired
    public StockService(final StockClient stockClient) {
        this.stockClient = stockClient;
    }


    public StockResponse getStockForSymbol(final String stockSymbol) {
        stockClient.getStockQuote(stockSymbol);

        return new StockResponse();
    }
}
