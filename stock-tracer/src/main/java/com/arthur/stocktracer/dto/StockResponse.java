package com.arthur.stocktracer.dto;

import lombok.Builder;

@Builder
public record StockResponse(
    String symbol,
    double price,
    String lastUpdate
){}

