// AbrigoControllerTest.java
package com.gestaoabrigos.controller;

import com.gestaoabrigos.service.AbrigoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AbrigoController.class)
class AbrigoControllerTest {
    @Autowired MockMvc mvc;
    @com.gestaoabrigos.controller.SpyBean
    AbrigoService service;

    @Test
    void list_ShouldReturnViewAndModel() throws Exception {
        mvc.perform(get("/abrigos"))
                .andExpect(status().isOk())
                .andExpect(view().name("abrigos/list"))
                .andExpect(model().attributeExists("abrigos"));
        verify(service).findAll();
    }
}