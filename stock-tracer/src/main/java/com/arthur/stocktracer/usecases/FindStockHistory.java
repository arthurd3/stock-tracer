package com.arthur.stocktracer.usecases;

import com.arthur.stocktracer.client.StockClient;
import com.arthur.stocktracer.dto.DailyStockResponse;
import com.arthur.stocktracer.dto.StockHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindStockHistory {

    private final StockClient stockClient;

    @Autowired
    public FindStockHistory(final StockClient stockClient) {
        this.stockClient = stockClient;
    }

    public List<DailyStockResponse> getHistory(final String stockSymbol, final int days) {
         StockHistoryResponse historyResponse = stockClient.getStockHistory(stockSymbol);

         return historyResponse.timeSeries().entrySet().stream()
                 .limit(days)
                 .map(entry -> {
                     var date = entry.getKey();
                     var daily = entry.getValue();
                     return new DailyStockResponse(
                             date,
                             Double.parseDouble(daily.open()),
                             Double.parseDouble(daily.close()),
                             Double.parseDouble(daily.high()),
                             Double.parseDouble(daily.low()),
                             Long.parseLong(daily.volume())
                     );
                 }).collect(Collectors.toList());
    }
}
