package com.payconiq.stockmanagement;

import com.payconiq.stockmanagement.dto.StockUpdateDto;
import com.payconiq.stockmanagement.model.Stock;
import com.payconiq.stockmanagement.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Stock controller
 *
 */
@RestController
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    /**
     * Get stock list by page number and page size (default 0,10)
     * @param pageNo - Page to be viewed
     * @param pageSize - Page size of the page to be viewed
     * @return the response entity with List of Stocks.
     */
    @GetMapping("/api/stocks")
    public ResponseEntity<List<Stock>> getAllStocks(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") @Valid Integer pageSize
    ) {
        var stocks = stockService.getAllStocks(pageNo,pageSize);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/api/stocks/{stockId}")
    public ResponseEntity<Stock> getStockById(
            @PathVariable("stockId") Long stockId
    ) {
        Stock stock = stockService.getStockById(stockId);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    /**
     * Create stock entity.
     * @param stock - stock to be created
     * @return the response entity with the created stock.
     */
    @PostMapping(value = "/api/stocks", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stock> createStock(
           @RequestBody Stock stock) {
        return new ResponseEntity<>(stockService.createStock(stock),
                HttpStatus.CREATED);
    }

    @PatchMapping("/api/stocks/{stockId}")
    public ResponseEntity<Stock> updateStockPriceById(
            @PathVariable Long stockId,
            @RequestBody StockUpdateDto stockPrice)
    {
       var stockUpdateResponse =  stockService.updateStockPrice(stockId,stockPrice);
        return new ResponseEntity<>(stockUpdateResponse,
                HttpStatus.OK);
    }

    @DeleteMapping("/api/stocks/{stockId}")
    public ResponseEntity<String> deleteStock(@PathVariable Long stockId)
    {
        var result = stockService.deleteStockById(stockId);
        return new ResponseEntity<>(result, HttpStatus.OK );
    }

}