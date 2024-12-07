package org.vasquez.appmockito.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.vasquez.appmockito.models.Examen;
import org.vasquez.appmockito.services.ExamenService;
import org.vasquez.appmockito.services.ExamenServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExamenRepositoryImplTest {
    ExamenRepository repository;
    ExamenService service;
    PreguntaRepository preguntaRepository;

    @BeforeEach
    void setUp() {
        repository = mock(ExamenRepositoryOtro.class);
        preguntaRepository = mock(PreguntaRepository.class);
        service = new ExamenServiceImpl(repository,preguntaRepository);
    }

    @Test
    void findAll() {

        List<Examen> datos = Arrays.asList(new Examen(5L,"Matemáticas"),
                new Examen(6L,"Lenguaje"),
                new Examen(7L,"Historia"));
        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");

        assertTrue(examen.isPresent());
        assertEquals(5L,examen.orElseThrow().getId());
        assertEquals("Matemáticas",examen.orElseThrow().getNonbre());
    }

    @Test
    void findExamenPorNombreListaVacia() {
        List<Examen> datos = Collections.emptyList();
        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");

        assertFalse(examen.isPresent());
    }


}