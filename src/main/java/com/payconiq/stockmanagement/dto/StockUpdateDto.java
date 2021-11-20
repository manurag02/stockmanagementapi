package com.payconiq.stockmanagement.dto;

import com.payconiq.stockmanagement.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockUpdateDto {

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
    private BigDecimal currentPrice;

    @Size(min = 3,max = 3)
    @NotBlank
    private String currencyCode;
}
