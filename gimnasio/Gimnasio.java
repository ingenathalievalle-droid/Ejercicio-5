/*
 * Nathalie Valle
 * Carné: 251290
 * Carrera: Ingeniería en Ciencia de los Datos
 * Curso: CC2008 – Introducción a la Programación Orientada a Objetos
 * Semestre II, 2025
 * Descripción: Clase que representa a un miembro del gimnasio y sus rutinas y entrenador asignado.
 */
package gimnasio;

import java.util.ArrayList;

public class Gimnasio {
    private ArrayList<Miembro> miembros;
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Rutina> rutinas;

    public Gimnasio() {
        miembros = new ArrayList<>();
        entrenadores = new ArrayList<>();
        rutinas = new ArrayList<>();
    }
    public void agregarMiembro(Miembro m) {
        miembros.add(m);
    }
    public void agregarEntrenador(Entrenador e) {
        entrenadores.add(e);
    }
    public void agregarRutina(Rutina r) {
        rutinas.add(r);
    }
    public Rutina rutinaMasPopular() {
        Rutina popular = null;
        int max = -1;
        for (Rutina r : rutinas) {
            if (r.getCantidadPracticantes() > max) {
                max = r.getCantidadPracticantes();
                popular = r;
            }
        }
        return popular;
    }
    public Entrenador entrenadorConMasAlumnos() {
        Entrenador top = null;
        int max = -1;
        for (Entrenador e : entrenadores) {
            if (e.getCantidadAlumnos() > max) {
                max = e.getCantidadAlumnos();
                top = e;
            }
        }
        return top;
    }
    public int rutinasActivas() {
        int count = 0;
        for (Rutina r : rutinas) {
            if (r.isActiva()) count++;
        }
        return count;
    }
    public ArrayList<Miembro> getMiembros() { return miembros; }
    public ArrayList<Rutina> getRutinas() { return rutinas; }
    public ArrayList<Entrenador> getEntrenadores() { return entrenadores; }
}
