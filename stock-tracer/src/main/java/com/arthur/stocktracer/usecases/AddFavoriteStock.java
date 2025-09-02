package com.arthur.stocktracer.usecases;

import com.arthur.stocktracer.client.StockClient;
import com.arthur.stocktracer.entity.FavoriteStock;
import com.arthur.stocktracer.exception.FavoriteAlreadyExistsException;
import com.arthur.stocktracer.repository.FavoriteStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddFavoriteStock {

    private final StockClient stockClient;
    private final FavoriteStockRepository favoriteStockRepository;


    @Autowired
    public AddFavoriteStock(final StockClient stockClient, FavoriteStockRepository favoriteStockRepository) {
        this.stockClient = stockClient;
        this.favoriteStockRepository = favoriteStockRepository;
    }

    @Transactional
    public FavoriteStock addFavorite(final String symbol){

        if(favoriteStockRepository.existsBySymbol(symbol)){
            throw new FavoriteAlreadyExistsException(symbol);
        }

        FavoriteStock favoriteStock = FavoriteStock.builder()
                .symbol(symbol)
                .build();

        return favoriteStockRepository.save(favoriteStock);
    }


}
