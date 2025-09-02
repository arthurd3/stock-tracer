package com.arthur.stocktracer.usecases;

import com.arthur.stocktracer.client.StockClient;
import org.springframework.stereotype.Service;

@Service
public class FindStockOverview {

    private final StockClient stockClient;

    public FindStockOverview(StockClient stockClient) {
        this.stockClient = stockClient;
    }


    public StockOverviewResponse getStockOverviewForSymbol(final String symbol){
        return stockClient.getStockOverview(symbol);
    }
}
