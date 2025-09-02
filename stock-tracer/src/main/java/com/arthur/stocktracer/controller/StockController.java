package com.arthur.stocktracer.controller;

import com.arthur.stocktracer.dto.StockResponse;
import com.arthur.stocktracer.usecases.FindStock;
import com.arthur.stocktracer.usecases.FindStockOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final FindStock findStock;
    private final FindStockOverview findStockOverview;

    @Autowired
    public StockController(final FindStock findStock, final FindStockOverview findStockOverview) {
        this.findStock = findStock;
        this.findStockOverview = findStockOverview;
    }

    @GetMapping("/{stockSymbol}")
    public StockResponse getStock(@PathVariable String stockSymbol){
        return findStock.getStockForSymbol(stockSymbol.toUpperCase());
    }

    @GetMapping("/{stockSymbol}/overview")
    public StockOverviewResponse getStockOverview(@PathVariable String stockSymbol){
        return findStockOverview.getStockOverviewForSymbol(stockSymbol.toUpperCase());
    }

}
