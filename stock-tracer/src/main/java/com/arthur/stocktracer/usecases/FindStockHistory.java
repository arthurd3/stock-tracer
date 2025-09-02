package com.arthur.stocktracer.usecases;

import com.arthur.stocktracer.client.StockClient;
import com.arthur.stocktracer.dto.DailyStockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindStockHistory {

    private final StockClient stockClient;

    @Autowired
    public FindStockHistory(final StockClient stockClient) {
        this.stockClient = stockClient;
    }

    public List<DailyStockResponse> getHistory(final String stockSymbol, final int days) {
        return stockClient.getStockHistory();
    }
}
