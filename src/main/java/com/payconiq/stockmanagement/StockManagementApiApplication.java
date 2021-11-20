package com.payconiq.stockmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.payconiq.stockmanagement"})
public class StockManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockManagementApiApplication.class, args);
	}

}
