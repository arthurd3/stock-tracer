package com.arthur.stocktracer.client;

import com.arthur.stocktracer.dto.AlphaVantageResponse;
import com.arthur.stocktracer.dto.DailyStockResponse;
import com.arthur.stocktracer.dto.StockHistoryResponse;
import com.arthur.stocktracer.dto.StockOverviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockClient {

    private final WebClient webClient;

    @Value("${alpha.vantage.api.key}")
    private String apiKey;

    public AlphaVantageResponse getStockQuote(final String stockSymbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("function" , "GLOBAL_QUOTE")
                        .queryParam("symbol" , stockSymbol)
                        .queryParam("apikey" , apiKey)
                        .build())
                .retrieve()
                .bodyToMono(AlphaVantageResponse.class)
                .block();
    }

    public StockOverviewResponse getStockOverview(final String stockSymbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("function" , "OVERVIEW")
                        .queryParam("symbol" , stockSymbol)
                        .queryParam("apikey" , apiKey)
                        .build())
                .retrieve()
                .bodyToMono(StockOverviewResponse.class)
                .block();
    }

    public StockHistoryResponse getStockHistory(final String stockSymbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("function" , "TIME_SERIES_DAILY")
                        .queryParam("symbol" , stockSymbol)
                        .queryParam("apikey" , apiKey)
                        .build())
                .retrieve()
                .bodyToMono(StockHistoryResponse.class)
                .block();
    }
}
