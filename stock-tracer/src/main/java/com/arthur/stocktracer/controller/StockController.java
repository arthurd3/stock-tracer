package com.arthur.stocktracer.controller;

import com.arthur.stocktracer.dto.DailyStockResponse;
import com.arthur.stocktracer.dto.FavoriteStockRequest;
import com.arthur.stocktracer.dto.StockOverviewResponse;
import com.arthur.stocktracer.dto.StockResponse;
import com.arthur.stocktracer.entity.FavoriteStock;
import com.arthur.stocktracer.usecases.AddFavoriteStock;
import com.arthur.stocktracer.usecases.FindStock;
import com.arthur.stocktracer.usecases.FindStockHistory;
import com.arthur.stocktracer.usecases.FindStockOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final FindStock findStock;
    private final FindStockOverview findStockOverview;
    private final FindStockHistory findStockHistory;
    private final AddFavoriteStock addFavoriteStock;

    @Autowired
    public StockController(final FindStock findStock, final FindStockOverview findStockOverview, FindStockHistory findStockHistory, AddFavoriteStock addFavoriteStock) {
        this.findStock = findStock;
        this.findStockOverview = findStockOverview;
        this.findStockHistory = findStockHistory;
        this.addFavoriteStock = addFavoriteStock;
    }

    @GetMapping("/{stockSymbol}")
    public StockResponse getStock(@PathVariable String stockSymbol){
        return findStock.getStockForSymbol(stockSymbol.toUpperCase());
    }

    @GetMapping("/{stockSymbol}/overview")
    public StockOverviewResponse getStockOverview(@PathVariable String stockSymbol){
        return findStockOverview.getStockOverviewForSymbol(stockSymbol.toUpperCase());
    }

    @GetMapping("/{stockSymbol}/history")
    public List<DailyStockResponse> getStockHistory(
            @PathVariable String stockSymbol,
            @RequestParam(defaultValue = "30") int days
    ){
        return findStockHistory.getHistory(stockSymbol.toUpperCase() , days);
    }

    @PostMapping("/favorites")
    public ResponseEntity<FavoriteStock> saveFavoriteStock(@RequestBody FavoriteStockRequest favoriteStock){
        final FavoriteStock saved = addFavoriteStock.addFavorite(favoriteStock.getSymbol());
        return ResponseEntity.ok(saved);
    }



}
