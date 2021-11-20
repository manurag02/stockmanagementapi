package com.payconiq.stockmanagement.utils;

import com.payconiq.stockmanagement.dto.StockUpdateDto;
import com.payconiq.stockmanagement.model.Stock;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@UtilityClass
public final class StockManagementTestUtils {

    public static Pageable testPage = PageRequest.of(0,10);
    public static List<Stock> listOfStocks = new ArrayList<>();
    public static StockUpdateDto stockUpdateDtoTest = StockUpdateDto.builder().build();
    public static Stock findByIdExpectedStock = Stock.builder().name("afdf").currentPrice(new BigDecimal(10)).currencyCode("EUR").build();
    public static Stock unUpdatedStock = Stock.builder().name("afdf").build();
    public static Page<Stock> stockListEmptyExpected = new Page<Stock>() {
        @Override
        public int getTotalPages() {
            return 0;
        }

        @Override
        public long getTotalElements() {
            return 0;
        }

        @Override
        public <U> Page<U> map(Function<? super Stock, ? extends U> converter) {
            return null;
        }

        @Override
        public int getNumber() {
            return 0;
        }

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public int getNumberOfElements() {
            return 0;
        }

        @Override
        public List<Stock> getContent() {
            return null;
        }

        @Override
        public boolean hasContent() {
            return false;
        }

        @Override
        public Sort getSort() {
            return null;
        }

        @Override
        public boolean isFirst() {
            return false;
        }

        @Override
        public boolean isLast() {
            return false;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Pageable nextPageable() {
            return null;
        }

        @Override
        public Pageable previousPageable() {
            return null;
        }

        @Override
        public Iterator<Stock> iterator() {
            return null;
        }
    }  ;
    public static Page<Stock> stockListPagedExpected = new Page<Stock>() {
        @Override
        public int getTotalPages() {
            return 0;
        }

        @Override
        public long getTotalElements() {
            return 0;
        }

        @Override
        public <U> Page<U> map(Function<? super Stock, ? extends U> converter) {
            return null;
        }

        @Override
        public int getNumber() {
            return 0;
        }

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public int getNumberOfElements() {
            return 0;
        }

        @Override
        public List<Stock> getContent() {
            return listOfStocks;
        }

        @Override
        public boolean hasContent() {
            return true;
        }

        @Override
        public Sort getSort() {
            return null;
        }

        @Override
        public boolean isFirst() {
            return false;
        }

        @Override
        public boolean isLast() {
            return false;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Pageable nextPageable() {
            return null;
        }

        @Override
        public Pageable previousPageable() {
            return null;
        }

        @Override
        public Iterator<Stock> iterator() {
            return null;
        }
    }  ;


//    static {
//        listOfStocks.add(new Stock());
//        listOfStocks.add(new Stock());
//        listOfStocks.add(new Stock());
//        listOfStocks.add(new Stock());
//        listOfStocks.add(new Stock());
//        listOfStocks.add(new Stock());
//        listOfStocks.add(new Stock());
//        listOfStocks.add(new Stock());
//        listOfStocks.add(new Stock());
//        listOfStocks.add(new Stock());
//    }
}
