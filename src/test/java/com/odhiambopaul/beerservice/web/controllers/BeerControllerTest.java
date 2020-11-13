package com.odhiambopaul.beerservice.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odhiambopaul.beerservice.web.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
  @Autowired MockMvc mockMvc;

  @Autowired ObjectMapper objectMapper;

  @Test
  void getBeerById() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void saveNewBeer() throws Exception {
    BeerDTO beerDTO = BeerDTO.builder().build();
    String beerDTOJson = objectMapper.writeValueAsString(beerDTO);
    mockMvc
        .perform(post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON).content(beerDTOJson))
        .andExpect(status().isCreated());
  }

  @Test
  void updateBeer() throws Exception {
    BeerDTO beerDTO = BeerDTO.builder().build();
    String beerDTOJson = objectMapper.writeValueAsString(beerDTO);
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
}
