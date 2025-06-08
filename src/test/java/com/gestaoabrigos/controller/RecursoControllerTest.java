// RecursoControllerTest.java
package com.gestaoabrigos.controller;

import com.gestaoabrigos.service.RecursoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecursoController.class)
class RecursoControllerTest {
    @Autowired MockMvc mvc;
    @SpyBean RecursoService service;

    @Test
    void list_ShouldDisplayResources() throws Exception {
        mvc.perform(get("/recursos"))
                .andExpect(status().isOk())
                .andExpect(view().name("recursos/list"))
                .andExpect(model().attributeExists("recursos"));
    }
}
