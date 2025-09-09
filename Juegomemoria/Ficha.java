/*
 * Autor: Nathalie Valle
 * Carné: 251290
 * Carrera: Ingeniería en Ciencia de los Datos
 * Curso: CC2008 – Programación Orientada a Objetos
 * Semestre II, 2025
 * Descripción: Clase que representa una ficha del juego de memoria, con su símbolo, estado de visibilidad y emparejamiento.
 /* */
package Juegomemoria;

public class Ficha {
    private String simbolo;
    private boolean visible;
    private boolean emparejada;

    public Ficha(String simbolo) {
        this.simbolo = simbolo;
        this.visible = false;
        this.emparejada = false;
    }
    public void revelar() {
        this.visible = true;
    }
    public void ocultar() {
        if (!emparejada) this.visible = false;
    }
    public void emparejar() {
        this.emparejada = true;
        this.visible = true;
    }
    public boolean estaEmparejada() {
        return emparejada;
    }
    public boolean esIgual(Ficha otra) {
        return this.simbolo.equals(otra.simbolo);
    }
    public String getSimbolo() {
        return visible ? simbolo : "❓";
    }
}