package org.vasquez.appmockito.models;

import java.util.ArrayList;
import java.util.List;

public class Examen {
    private Long id;
    private String nonbre;
    private List<String> preguntas;

    public Examen(Long id, String nonbre) {
        this.id = id;
        this.nonbre = nonbre;
        this.preguntas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNonbre() {
        return nonbre;
    }

    public void setNonbre(String nonbre) {
        this.nonbre = nonbre;
    }

    public List<String> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<String> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "id=" + id +
                ", nonbre='" + nonbre + '\'' +
                ", preguntas=" + preguntas +
                '}';
    }
}
