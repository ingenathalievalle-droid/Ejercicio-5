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
public class Rutina {
    private String id;
    private boolean activa;
    private ArrayList<Miembro> miembros;
    private String nombre;

    public Rutina(String nombre, String id, String descripcion, boolean activa){
        this.nombre = nombre;
        this.id = id;
        this.activa = activa;
        this.miembros = new ArrayList<>();
    }
    public void agregarMiembro(Miembro m){
        miembros.add(m);
    }
    public int getCantidadPracticantes(){
        return miembros.size();
    }
    public boolean isActiva() { return activa;}
    public String getNombre() { return nombre;}
    public String getId() { return id;}
    public ArrayList<Miembro> getMiembros() { return miembros;}
    
}
