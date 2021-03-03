package com.zemoso.aopdemo.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.slf4j.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.UUID;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookControllerTest {
    private MockMvc mockMvc;

    @Autowired
    BookController bookController;

    Logger logger = LoggerFactory.getLogger(BookControllerTest.class);

    @BeforeAll
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    @DisplayName("get all books test")
    void getBooks() throws Exception {
        mockMvc.perform(get("/books/list"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("add book test")
    void addBooks() throws Exception {
        String jsonString="{\"id\": \"9a8fdb46-7a97-11eb-9439-0242ac130002\", \"title\": \"social\", \"isbn\": \"789\", \"description\": \"social book\", \"no_pages\": 67} ";
        MvcResult mvcResult = mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonString))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    @DisplayName("Should delete a book")
    void testDeleteBook() {
        ResponseEntity<String> result= bookController.deleteBook(UUID.randomUUID());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    @DisplayName("Should update a book")
    void testUpdateBook() throws Exception {
        String jsonString="{\"id\": \"06fdc896-7bcf-11eb-9439-0242ac130004\", \"title\": \"current\"} ";
        MvcResult mvcResult = mockMvc.perform(put("/books")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonString))
                .andExpect(status().isCreated())
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();

        logger.info(response);
    }

}
