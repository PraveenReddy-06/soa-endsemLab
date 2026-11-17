package com.example.soaendsemlab.controller;

import com.example.soaendsemlab.SoaEndsemLabApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SoaEndsemLabApplication.class)
@AutoConfigureMockMvc
class AdditionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addTwoNumbers() throws Exception {
        mockMvc.perform(get("/msi/add/")
                        .param("a", "10")
                        .param("b", "20"))
                .andExpect(status().isOk())
                .andExpect(content().string("30"));
    }

    @Test
    void addNegativeNumbers() throws Exception {
        mockMvc.perform(get("/msi/add/")
                        .param("a", "-5")
                        .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("-3"));
    }
}
