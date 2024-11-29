package org.vasquez.appmockito.services;

import org.vasquez.appmockito.models.Examen;

public interface ExamenService {
    Examen findExamenPorNombre(String nombre);
}
