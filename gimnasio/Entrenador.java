
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
public class Entrenador {
    private String nombre;
    private String id;
    private ArrayList<Miembro> miembros;

    public Entrenador(String nombre, String id){
        this.nombre = nombre;
        this.id= id;
        this.miembros = new ArrayList<> ();
    }
    public void agregarMiembro(Miembro m){
        miembros.add(m);
    }
    public int getCantidadAlumnos(){
        return miembros.size();
    }
    public String getNombre() { return nombre;}
    public String getId() { return id;}
    public ArrayList<Miembro> getMiembros() { return miembros;}
}
