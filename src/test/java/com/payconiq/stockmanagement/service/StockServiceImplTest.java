package com.payconiq.stockmanagement.service;

import com.payconiq.stockmanagement.excpetionhandling.StockDetailsGenericException;
import com.payconiq.stockmanagement.repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.payconiq.stockmanagement.utils.StockManagementTestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {

    @Mock private StockRepository repository;

    private StockServiceImpl stockService;

    @BeforeEach
    void setup()
    {
        this.stockService = new StockServiceImpl(repository);
    }

    @Test
    public void shouldThrowStockDetailsGenericException_whenNoDataFound()
    {
        when(repository.findAll(testPage)).thenReturn(stockListEmptyExpected);
        assertThrows(StockDetailsGenericException.class, () -> stockService.getAllStocks(0,10));
    }

    @Test
    public void shouldReturnPageOfElements_whenGetAllStock_byPageNo_andPageSize()
    {
        when(repository.findAll(testPage)).thenReturn(stockListPagedExpected);
        var actualResult = stockService.getAllStocks(0,10);
        assertEquals(actualResult.size(),stockListEmptyExpected.getSize());

    }

    @Test
    public void shouldReturnStock_whenSearchById()
    {
        when(repository.findById(1L)).thenReturn(java.util.Optional.ofNullable(findByIdExpectedStock));
        var actualResult = stockService.getStockById(1l);
        assertEquals(findByIdExpectedStock,actualResult);
    }

    @Test
    public void shouldCreateStock_andReturnStock()
    {
        when(repository.save(findByIdExpectedStock)).thenReturn(findByIdExpectedStock);
        var actualResult = stockService.createStock(findByIdExpectedStock);
        assertEquals(findByIdExpectedStock,actualResult);
    }

    @Test
    public void shouldUpdateStockPrice_whenStockExists()
    {
        when(repository.findById(1l)).thenReturn(Optional.ofNullable(unUpdatedStock));
        when(repository.save(unUpdatedStock)).thenReturn(findByIdExpectedStock);
        var actualResult = stockService.updateStockPrice(1l,stockUpdateDtoTest);
        assertEquals(actualResult,findByIdExpectedStock);
    }

    @Test
    public void shouldDeleteStock_whenStockExists()
    {
        when(repository.findById(1l)).thenReturn(Optional.ofNullable(unUpdatedStock));
        var actualResult = stockService.deleteStockById(1l);
        assertEquals(actualResult,"Deleted");

    }
}
