// AbrigoServiceImplTest.java
package com.gestaoabrigos.service;

import com.gestaoabrigos.dto.AbrigoDto;
import com.gestaoabrigos.model.Abrigo;
import com.gestaoabrigos.repository.AbrigoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AbrigoServiceImplTest {

    @Mock
    private AbrigoRepository repository;

    @InjectMocks
    private AbrigoServiceImpl service;

    private Abrigo sample;

    @BeforeEach
    void setUp() {
        sample = new Abrigo();
        sample.setId(1L);
        sample.setNome("Teste");
        sample.setEndereco("Endereco X");
        sample.setLatitude(BigDecimal.ZERO);
        sample.setLongitude(BigDecimal.ZERO);
        sample.setCapacidadeTotal(10);
        sample.setStatus("ABERTO");
    }

    @Test
    void findAll_ShouldReturnListOfDtos() {
        when(repository.findAll()).thenReturn(List.of(sample));
        List<AbrigoDto> dtos = service.findAll();
        assertEquals(1, dtos.size());
        verify(repository).findAll();
    }

    @Test
    void findById_ExistingId_ShouldReturnDto() {
        when(repository.findById(1L)).thenReturn(Optional.of(sample));
        AbrigoDto dto = service.findById(1L);
        assertNotNull(dto);
        assertEquals("Teste", dto.getNome());
    }

    @Test
    void create_ShouldSaveAndReturnDto() {
        when(repository.save(any(Abrigo.class))).thenReturn(sample);
        AbrigoDto in = new AbrigoDto();
        in.setNome("Teste"); in.setEndereco("E"); in.setLatitude(BigDecimal.ZERO);
        in.setLongitude(BigDecimal.ZERO); in.setCapacidadeTotal(5); in.setStatus("ABERTO");
        AbrigoDto saved = service.create(in);
        assertNotNull(saved.getId());
        verify(repository).save(any(Abrigo.class));
    }

    @Test
    void delete_ShouldInvokeRepository() {
        doNothing().when(repository).deleteById(1L);
        service.delete(1L);
        verify(repository).deleteById(1L);
    }
}
