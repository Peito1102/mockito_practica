package org.vasquez.appmockito.services;

import org.vasquez.appmockito.models.Examen;
import org.vasquez.appmockito.repositories.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{
    private ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Examen findExamenPorNombre(String nombre) {
        Optional<Examen> examenOptional = examenRepository.findAll().stream().filter(
                n -> n.getNonbre().equals(nombre)).findFirst();
        Examen examen = null;
        if (examenOptional.isPresent()) {
            examen = examenOptional.orElseThrow();
        }
        return examen;
    }
}
