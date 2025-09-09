
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
public class Miembro {
    private String nombre;
    private String id;
    private String membresia;
    private Entrenador entrenador;
    private ArrayList<Rutina> rutinas;

    public Miembro(String nombre, String id, String membresia){
        this.nombre = nombre;
        this.id = id;
        this.membresia = membresia;
        this.rutinas = new ArrayList<>();
    }
    public void asignarRutina(Rutina r){
        rutinas.add(r);
        r.agregarMiembro(this);
    }
    public void asignarEntrenador(Entrenador e){
        this.entrenador = e;
        e.agregarMiembro(this);
    }
    public String getId() { return id; }
    public String getNombre () { return nombre;}
    public String getMembresia() { return membresia;}
    public Entrenador getEntrenador() { return entrenador;}
    public ArrayList<Rutina> getRutinas() { return rutinas;}
}
