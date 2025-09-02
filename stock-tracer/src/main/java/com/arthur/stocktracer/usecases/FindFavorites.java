package com.arthur.stocktracer.usecases;

import com.arthur.stocktracer.dto.StockResponse;
import com.arthur.stocktracer.entity.FavoriteStock;
import com.arthur.stocktracer.repository.FavoriteStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindFavorites {

    private final FindStock findStock;
    private final FavoriteStockRepository stockRepository;

    @Autowired
    public FindFavorites(FindStock findStock, final FavoriteStockRepository stockRepository) {
        this.findStock = findStock;
        this.stockRepository = stockRepository;
    }

    public List<StockResponse> getFavorites(){

        List<FavoriteStock> favorites = stockRepository.findAll();

        return favorites.stream()
                .map(fav -> findStock.getStockForSymbol(fav.getSymbol()))
                .collect(Collectors.toList());
    }
}
