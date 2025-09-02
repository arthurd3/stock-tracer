package com.arthur.stocktracer.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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
}
