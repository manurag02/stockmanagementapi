package com.payconiq.stockmanagement.service;

import com.payconiq.stockmanagement.dto.StockUpdateDto;
import com.payconiq.stockmanagement.model.Stock;

import java.util.List;

public interface StockService {

    List<Stock> getAllStocks(Integer pageNo, Integer pageSize);

    Stock getStockById(Long id);

    Stock createStock(Stock stock);

    Stock updateStockPrice(Long stockId, StockUpdateDto stockPrice);

    String deleteStockById(Long stockId);
}
