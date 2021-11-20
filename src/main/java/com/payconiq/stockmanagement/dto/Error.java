package com.payconiq.stockmanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class Error {

    /**
     * The Errors.
     */
    List<ErrorAttributes> errors;
}
