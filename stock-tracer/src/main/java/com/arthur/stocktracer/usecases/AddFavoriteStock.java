package com.arthur.stocktracer.usecases;

import com.arthur.stocktracer.client.StockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddFavoriteStock {

    private final StockClient stockClient;

    @Autowired
    public AddFavoriteStock(final StockClient stockClient) {
        this.stockClient = stockClient;
    }

    public FavoriteStock addFavorite(final String symbol){

    }


}
