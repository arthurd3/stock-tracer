package com.arthur.stocktracer.usecases;

import com.arthur.stocktracer.client.StockClient;
import com.arthur.stocktracer.dto.StockOverviewResponse;
import org.springframework.stereotype.Service;

@Service
public class FindStockOverview {

    private final StockClient stockClient;

    public FindStockOverview(StockClient stockClient) {
        this.stockClient = stockClient;
    }

    public StockOverviewResponse getStockOverviewForSymbol(final String stockSymbol){
        return stockClient.getStockOverview(stockSymbol);
    }
}
