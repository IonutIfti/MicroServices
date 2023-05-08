package com.ii.microservices.beerservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ii.microservices.beerservice.models.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeers() throws Exception {
        mockMvc.perform(get("/api/v1/beer/beers")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void getBeer() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createBeer() throws Exception {

        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(post("/api/v1/beer/createBeer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDTOJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {
        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(post("/api/v1/beer/createBeer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDTOJson))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteBeer() {
    }
}