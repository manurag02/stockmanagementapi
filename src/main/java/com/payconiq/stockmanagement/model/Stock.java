package com.payconiq.stockmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "stocks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder(toBuilder = true)
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Stock Name should not be blank")
    private String name;

    @Column(name = "currentPrice")
    @NotNull
    private BigDecimal currentPrice;

    @Column(name = "currencyCode")
    @Size(min = 3,max = 3,message = "Please use 3 Letter currency code")
    @NotBlank
    private String currencyCode;

    @Column(name = "CreatedDate", updatable=false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "ModifiedDate")
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

}

