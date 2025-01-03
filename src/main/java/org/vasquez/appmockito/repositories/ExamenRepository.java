package org.vasquez.appmockito.repositories;

import org.vasquez.appmockito.models.Examen;

import java.util.List;

public interface ExamenRepository {
    Examen guardar(Examen examen);
    List<Examen> findAll();

}
