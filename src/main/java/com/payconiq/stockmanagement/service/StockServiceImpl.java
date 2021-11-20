package com.payconiq.stockmanagement.service;

import com.payconiq.stockmanagement.dto.StockUpdateDto;
import com.payconiq.stockmanagement.excpetionhandling.StockDetailsGenericException;
import com.payconiq.stockmanagement.model.Stock;
import com.payconiq.stockmanagement.repository.StockRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private StockRepository repository;

    public StockServiceImpl(StockRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Stock> getAllStocks(Integer pageNo, Integer pageSize) {
        Pageable page = PageRequest.of(pageNo,pageSize);
        Page<Stock> stockList = repository.findAll(page);

          if(!stockList.hasContent())
          {
              throw new StockDetailsGenericException("No stock details found");
          }

        return stockList.getContent();
    }

    @Override
    public Stock getStockById(Long id) {

    Stock stock = repository.findById(id).orElseThrow(() -> new StockDetailsGenericException("No stock found for the given id"));
        return stock;
    }

    @Override
    public Stock createStock(Stock stock) {
       Stock newStock = repository.save(stock);
        return newStock;
    }

    @Override
    public Stock updateStockPrice(Long stockId, StockUpdateDto stockPrice) {

        Stock stock = repository.findById(stockId).orElseThrow(() -> new StockDetailsGenericException("No stock found for the given id"));
        stock.setCurrentPrice(stockPrice.getCurrentPrice());
        stock.setCurrencyCode(stockPrice.getCurrencyCode());
        Stock updatedStock = repository.save(stock);
        return updatedStock;
    }

    @Override
    public String deleteStockById(Long stockId) {
        Stock stock = repository.findById(stockId).orElseThrow(() -> new StockDetailsGenericException("No stock found for the given id"));
          repository.delete(stock);
          return "Deleted";
    }
}
