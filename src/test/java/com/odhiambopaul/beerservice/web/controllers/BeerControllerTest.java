package com.odhiambopaul.beerservice.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odhiambopaul.beerservice.bootstrap.BeerLoader;
import com.odhiambopaul.beerservice.services.BeerService;
import com.odhiambopaul.beerservice.web.model.BeerDTO;
import com.odhiambopaul.beerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        given(beerService.getBeerById(any())).willReturn(getValidBeerDto());
        mockMvc
                .perform(
                        get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDTO beerDTO = getValidBeerDto();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);
        mockMvc
                .perform(post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON).content(beerDTOJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {
        BeerDTO beerDTO = getValidBeerDto();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);
        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());
        mockMvc
                .perform(
                        put("/api/v1/beer/" + UUID.randomUUID().toString())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(beerDTOJson))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteBeerById() throws Exception {
        mockMvc
                .perform(delete("/api/v1/beer/" + UUID.randomUUID().toString()))
                .andExpect(status().isNoContent());
    }

    BeerDTO getValidBeerDto() {
        return BeerDTO.builder()
                .beerName("Pilsnar")
                .upc(BeerLoader.BEER_1_UPC)
                .price(new BigDecimal("400"))
                .build();
    }
}
