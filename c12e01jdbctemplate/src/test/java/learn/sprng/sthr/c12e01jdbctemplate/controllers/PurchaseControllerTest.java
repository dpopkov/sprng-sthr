package learn.sprng.sthr.c12e01jdbctemplate.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.sprng.sthr.c12e01jdbctemplate.model.Purchase;
import learn.sprng.sthr.c12e01jdbctemplate.repositories.PurchaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PurchaseControllerTest {
    private static final String PRODUCT = "Spring in Action";

    @Autowired
    private MockMvc mockMvc; // The warning 'Could not autowire' can be ignored here.
    @MockBean
    private PurchaseRepository purchaseRepository;
    @Captor
    private ArgumentCaptor<Purchase> captor;
    private Purchase purchase;
    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        purchase = new Purchase();
        purchase.setProduct(PRODUCT);
        purchase.setPrice(BigDecimal.ONE);
        mapper = new ObjectMapper();
    }

    @Test
    void savePurchase() throws Exception {
        String expectedContent = mapper.writeValueAsString(purchase);
        mockMvc.perform(post("/purchase")
                .contentType(MediaType.APPLICATION_JSON)
                .content(expectedContent)
        ).andExpect(status().isOk());

        then(purchaseRepository).should().save(captor.capture());
        assertEquals(PRODUCT, captor.getValue().getProduct());
    }

    @Test
    void findAllPurchases() throws Exception {
        List<Purchase> purchases = List.of(purchase);
        given(purchaseRepository.findAll()).willReturn(purchases);

        String expectedJson = mapper.writeValueAsString(purchases);
        mockMvc.perform(get("/purchase"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

        then(purchaseRepository).should().findAll();
    }
}
