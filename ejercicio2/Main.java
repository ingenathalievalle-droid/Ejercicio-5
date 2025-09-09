package ejercicio2;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Salon> salones = new ArrayList<>();
        GestorEventos gestor = new GestorEventos();

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("--- Menú ---");
            System.out.println("1. Registrar salón");
            System.out.println("2. Registrar evento");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del salón: ");
                    String nombreSalon = scanner.nextLine();
                    System.out.print("Capacidad: ");
                    int capacidad = scanner.nextInt();
                    System.out.print("Precio por hora: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    salones.add(new Salon(nombreSalon, capacidad, precio));
                    System.out.println("Salón registrado correctamente.");
                    break;

                case 2:
                    if (salones.isEmpty()) {
                        System.out.println("Debe registrar al menos un salón primero.");
                        break;
                    }

                    System.out.print("Nombre del evento: ");
                    String nombreEvento = scanner.nextLine();

                    System.out.println("Seleccione salón:");
                    for (int i = 0; i < salones.size(); i++) {
                        System.out.println((i + 1) + ". " + salones.get(i).getInformacion());
                    }
                    int indice = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.print("Inicio (YYYY-MM-DDTHH:MM): ");
                    LocalDateTime inicio = LocalDateTime.parse(scanner.nextLine());
                    System.out.print("Fin (YYYY-MM-DDTHH:MM): ");
                    LocalDateTime fin = LocalDateTime.parse(scanner.nextLine());

                    Evento evento = new Evento(nombreEvento, salones.get(indice), inicio, fin);
                    boolean registrado = gestor.agregarEvento(evento);

                    if (registrado) {
                        System.out.println("Evento registrado:");
                        System.out.println(evento.getDetalle());
                    } else {
                        System.out.println("Conflicto de horario. No se pudo registrar el evento.");
                    }
                    break;

                case 3:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}