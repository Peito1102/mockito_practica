package org.vasquez.appmockito.repositories;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.vasquez.appmockito.models.Examen;
import org.vasquez.appmockito.services.ExamenService;
import org.vasquez.appmockito.services.ExamenServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExamenRepositoryImplTest {

    @Test
    void findAll() {
        ExamenRepository repository = mock(ExamenRepositoryOtro.class);
        ExamenService service = new ExamenServiceImpl(repository);
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
        ExamenRepository repository = mock(ExamenRepositoryOtro.class);
        ExamenService service = new ExamenServiceImpl(repository);
        List<Examen> datos = Collections.emptyList();
        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");

        assertTrue(examen.isPresent());
        assertEquals(5L,examen.orElseThrow().getId());
        assertEquals("Matemáticas",examen.orElseThrow().getNonbre());
    }
}