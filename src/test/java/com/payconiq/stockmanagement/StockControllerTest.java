package com.payconiq.stockmanagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payconiq.stockmanagement.excpetionhandling.StockDetailsGenericException;
import com.payconiq.stockmanagement.service.StockServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static com.payconiq.stockmanagement.utils.StockManagementTestUtils.stockUpdateDtoTest;
import static com.payconiq.stockmanagement.utils.StockManagementTestUtils.unUpdatedStock;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
public class StockControllerTest {

    private MockMvc mockMvc;

    @Mock private StockServiceImpl stockServiceMock;

    @InjectMocks
    private ObjectMapper objectMapper;

    private StockController stockController;

    @BeforeEach
    void  setStockController()
    {
        this.stockController = new StockController(stockServiceMock);
        this.mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
    }

    @Test
    void shouldReturn200Ok_whenGetListOfStocks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/stocks"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn404NotFound_whenNoStockFound() {
        when(stockServiceMock.getStockById(1l)).thenThrow(new StockDetailsGenericException("No stock details found"));
        assertThrows(NestedServletException.class, () -> mockMvc.perform(MockMvcRequestBuilders.get("/api/stocks/1"))
                .andExpect(status().is4xxClientError()));
    }

    @Test
    void shouldReturn201Created_whenCreateStock() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/stocks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(unUpdatedStock)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void shouldReturn200Ok_whenUpdateStock() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/stocks/1")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(stockUpdateDtoTest)))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    void shouldReturn200Ok_whenDeleteStock() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/stocks/1"))
                .andExpect(status().is2xxSuccessful());

    }
}
