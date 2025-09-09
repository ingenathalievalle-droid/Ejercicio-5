/*
 * Nathalie Valle
 * Carné: 251290
 * Carrera: Ingeniería en Ciencia de los Datos
 * Curso: CC2008 – Introducción a la Programación Orientada a Objetos
 * Semestre II, 2025
 * Descripción: Clase que representa a un miembro del gimnasio y sus rutinas y entrenador asignado.
 */
package gimnasio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gimnasio gimnasio = new Gimnasio();
        crearDatosIniciales(gimnasio);
        mostrarMenu(gimnasio);
    }
    public static void crearDatosIniciales(Gimnasio g) {
        Entrenador e1 = new Entrenador("Carlos", "E001");
        Entrenador e2 = new Entrenador("Ana", "E002");

        Miembro m1 = new Miembro("Luis", "M001", "Mensual");
        Miembro m2 = new Miembro("Sofía", "M002", "Anual");

        Rutina r1 = new Rutina("Cardio", "R001", "Ejercicios de resistencia", true);
        Rutina r2 = new Rutina("Fuerza", "R002", "Pesas y tonificación", false);

        m1.asignarEntrenador(e1);
        m2.asignarEntrenador(e2);

        m1.asignarRutina(r1);
        m2.asignarRutina(r1);
        m2.asignarRutina(r2);

        g.agregarEntrenador(e1);
        g.agregarEntrenador(e2);
        g.agregarMiembro(m1);
        g.agregarMiembro(m2);
        g.agregarRutina(r1);
        g.agregarRutina(r2);
    }

    public static void mostrarMenu(Gimnasio g) {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;

            do {
                System.out.println("\n--- MENÚ GIMNASIO ---");
                System.out.println("1. Ver rutina más popular");
                System.out.println("2. Ver entrenador con más alumnos");
                System.out.println("3. Ver número de rutinas activas");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        Rutina popular = g.rutinaMasPopular();
                        System.out.println("Rutina más popular: " + popular.getNombre() + " con " + popular.getCantidadPracticantes() + " practicantes.");
                        break;
                    case 2:
                        Entrenador top = g.entrenadorConMasAlumnos();
                        System.out.println("Entrenador con más alumnos: " + top.getNombre() + " con " + top.getCantidadAlumnos() + " alumnos.");
                        break;
                    case 3:
                        System.out.println("Rutinas activas: " + g.rutinasActivas());
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } while (opcion != 4);
        }
    }
}