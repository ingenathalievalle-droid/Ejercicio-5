/*
 * Autor: Nathalie Valle
 * Carné: 251290
 * Carrera: Ingeniería en Ciencia de los Datos
 * Curso: CC2008 – Programación Orientada a Objetos
 * Semestre II, 2025
 * Descripción: Clase que representa una ficha del juego de memoria, con su símbolo, estado de visibilidad y emparejamiento.
 /* */
package Juegomemoria;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean jugarDeNuevo = true;
        while (jugarDeNuevo) {
            List<String> simbolos = generarSimbolos();

            System.out.println("Bienvenido al juego de Memorama");
            System.out.print("Ingrese nombre del Jugador 1: ");
            Jugador j1 = new Jugador(sc.nextLine());
            System.out.print("Ingrese nombre del Jugador 2: ");
            Jugador j2 = new Jugador(sc.nextLine());

            int filas = 0, columnas = 0;
            while (true) {
                try {
                    System.out.print("Ingrese número de filas del tablero (máx 14): ");
                    filas = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingrese número de columnas del tablero (máx 14): ");
                    columnas = Integer.parseInt(sc.nextLine());
                    if ((filas * columnas) % 2 != 0) {
                        System.out.println("El número total de casillas debe ser par.");
                        continue;
                    }
                    if (filas > 14 || columnas > 14) {
                        System.out.println("El tamaño máximo permitido es 14x14.");
                        continue;
                    }
                    if ((filas * columnas) / 2 > simbolos.size()) {
                        System.out.println("No hay suficientes símbolos únicos para este tamaño.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                }
            }

            Tablero tablero = new Tablero(filas, columnas, simbolos);
            JuegoMemoria juego = new JuegoMemoria(j1, j2, tablero);

            // Ciclo principal del juego
            while (!juego.juegoTerminado()) {
                System.out.println("\nTurno de: " + juego.getTurnoActual().getNombre());
                System.out.println(juego.obtenerVistaTablero());

                int[] coords1 = leerCoordenadas(sc, filas, columnas, "Primera ficha");
                int[] coords2 = leerCoordenadas(sc, filas, columnas, "Segunda ficha");

                // Revelar las dos fichas seleccionadas
                juego.getTablero().obtenerFicha(coords1[0], coords1[1]).revelar();
                juego.getTablero().obtenerFicha(coords2[0], coords2[1]).revelar();
                System.out.println("Tablero después de levantar las fichas:");
                System.out.println(juego.obtenerVistaTablero());
                System.out.print("Presiona Enter para continuar...");
                sc.nextLine();

                boolean esPar = juego.procesarTurno(coords1[0], coords1[1], coords2[0], coords2[1]);
                if (esPar) {
                    System.out.println("¡Par encontrado! " + juego.getTurnoActual().getNombre() + " gana un punto.");
                } else {
                    System.out.println("No hubo coincidencia. Turno para el siguiente jugador.");
                    juego.ocultarSiNoPar(coords1[0], coords1[1], coords2[0], coords2[1]);
                }
            }

            // Resultado final
            System.out.println("\nJuego terminado.");
            System.out.println(juego.obtenerVistaTablero());
            System.out.println(juego.obtenerPuntajes());
            System.out.println(juego.determinarGanador());

            // Preguntar si desea jugar de nuevo
            System.out.print("¿Desea jugar otra partida? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            jugarDeNuevo = respuesta.equals("s") || respuesta.equals("si");
        }
        System.out.println("¡Gracias por jugar!");
    }

    private static int[] leerCoordenadas(Scanner sc, int filas, int columnas, String mensaje) {
        int f, c;
        do {
                System.out.print(mensaje + " - fila (0 a " + (filas - 1) + "): ");
            f = sc.nextInt();
                System.out.print(mensaje + " - columna (0 a " + (columnas - 1) + "): ");
            c = sc.nextInt();
        } while (f < 0 || f >= filas || c < 0 || c >= columnas);
        return new int[]{f, c};
    }

    private static List<String> generarSimbolos() {
        List<String> lista = new ArrayList<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) lista.add(String.valueOf(ch));
        for (char ch = 'a'; ch <= 'z'; ch++) lista.add(String.valueOf(ch));
        for (int i = 0; i < 100; i++) lista.add("🔹" + i);
        return lista;
    }
}