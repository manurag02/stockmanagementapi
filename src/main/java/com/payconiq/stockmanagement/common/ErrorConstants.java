package com.payconiq.stockmanagement.common;

import com.payconiq.stockmanagement.dto.ErrorAttributes;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("constants.error")
public class ErrorConstants {

    private ErrorAttributes stockDetailNotFoundException;
    private ErrorAttributes constraintViolationException;
//    private ErrorAttributes invalidPitIndexException;
//    private ErrorAttributes wrongGameStatusException;
//    private ErrorAttributes gameOverException;
}
