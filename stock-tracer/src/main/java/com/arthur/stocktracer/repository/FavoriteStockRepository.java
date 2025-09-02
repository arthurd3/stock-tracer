package com.arthur.stocktracer.repository;

import com.arthur.stocktracer.entity.FavoriteStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteStockRepository extends JpaRepository<FavoriteStock, Long> {

    boolean existsBySymbol(final String symbol);
    
}
