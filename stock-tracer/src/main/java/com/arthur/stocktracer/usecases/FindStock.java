package com.arthur.stocktracer.usecases;

import com.arthur.stocktracer.client.StockClient;
import com.arthur.stocktracer.dto.AlphaVantageResponse;
import com.arthur.stocktracer.dto.StockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindStock {

    private final StockClient stockClient;

    @Autowired
    public FindStock(final StockClient stockClient) {
        this.stockClient = stockClient;
    }

    public StockResponse getStockForSymbol(final String stockSymbol) {
        final AlphaVantageResponse alphaResponse = stockClient.getStockQuote(stockSymbol);

        return StockResponse.builder()
                .symbol(alphaResponse.globalQuote().symbol())
                .price(Double.parseDouble(alphaResponse.globalQuote().price()))
                .lastUpdate(alphaResponse.globalQuote().lastTradingDay())
                .build();
    }
}
