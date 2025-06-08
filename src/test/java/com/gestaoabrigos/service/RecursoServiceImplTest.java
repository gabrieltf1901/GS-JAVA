// RecursoServiceImplTest.java
package com.gestaoabrigos.service;

import com.gestaoabrigos.dto.RecursoDto;
import com.gestaoabrigos.model.Recurso;
import com.gestaoabrigos.repository.RecursoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecursoServiceImplTest {
    @Mock RecursoRepository repository;
    @InjectMocks RecursoServiceImpl service;
    private Recurso sample;

    @BeforeEach
    void setUp() {
        sample = new Recurso();
        sample.setId(1L);
        sample.setNome("Agua");
        sample.setCategoria("AGUA");
        sample.setNivelCritico(10);
        sample.setUnidadeMedida("L");
    }

    @Test
    void findAll_ShouldReturnList() {
        when(repository.findAll()).thenReturn(List.of(sample));
        var list = service.findAll();
        assertEquals(1, list.size());
        verify(repository).findAll();
    }

    @Test
    void findById_NotFound_ShouldThrow() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.findById(1L));
    }
}