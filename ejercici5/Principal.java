package ejercici5;

import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        GestorProcesos gestor = new GestorProcesos();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Simulador de SO - Polimorfismo en Procesos");

        int opcion;
        do {
            mostrarMenu();
            opcion = solicitarEntero(scanner, "Selecciona una opción: ");
            procesarOpcion(scanner, opcion, gestor);
        } while (opcion != 0);

        System.out.println("Procesos gestionados: " + gestor.listarProcesos().size());
        System.out.println("¡Gracias por usar el simulador!");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar Proceso CPU");
        System.out.println("2. Agregar Proceso I/O");
        System.out.println("3. Agregar Daemon");
        System.out.println("4. Agregar Proceso Interactivo");
        System.out.println("5. Listar Procesos");
        System.out.println("6. Ejecutar Todos los Procesos");
        System.out.println("7. Eliminar Proceso por PID");
        System.out.println("8. Cambiar Estado de Proceso");
        System.out.println("0. Salir");
    }

    private static void procesarOpcion(Scanner scanner, int opcion, GestorProcesos gestor) {
        switch (opcion) {
            case 1: agregarCPU(scanner, gestor); break;
            case 2: agregarIO(scanner, gestor); break;
            case 3: agregarDaemon(scanner, gestor); break;
            case 4: agregarInteractivo(scanner, gestor); break;
            case 5: listarProcesos(gestor); break;
            case 6: ejecutarTodos(gestor); break;
            case 7: eliminarPorPid(scanner, gestor); break;
            case 8: cambiarEstado(scanner, gestor); break;
            case 0: System.out.println("Saliendo del simulador..."); break;
            default: System.out.println("Opción inválida."); break;
        }
    }

    private static String solicitarEntrada(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private static int solicitarEntero(Scanner scanner, String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                valor = Integer.parseInt(solicitarEntrada(scanner, mensaje));
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número entero válido.");
            }
        }
        return valor;
    }

    private static double solicitarDouble(Scanner scanner, String mensaje) {
        double valor = 0.0;
        boolean valido = false;
        while (!valido) {
            try {
                valor = Double.parseDouble(solicitarEntrada(scanner, mensaje));
                if (valor >= 0.0 && valor <= 1.0) {
                    valido = true;
                } else {
                    System.out.println("Error: Valor debe estar entre 0.0 y 1.0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número decimal válido.");
            }
        }
        return valor;
    }

    private static void agregarCPU(Scanner scanner, GestorProcesos gestor) {
        String nombre = solicitarEntrada(scanner, "Ingresa nombre del Proceso CPU: ");
        double intensidad = solicitarDouble(scanner, "Ingresa intensidad (0.0-1.0): ");
        gestor.agregarProceso(new ProcesoCPU(nombre, intensidad));
        System.out.println("Proceso CPU agregado.");
    }

    private static void agregarIO(Scanner scanner, GestorProcesos gestor) {
        String nombre = solicitarEntrada(scanner, "Ingresa nombre del Proceso I/O: ");
        String dispositivo = solicitarEntrada(scanner, "Ingresa dispositivo: ");
        gestor.agregarProceso(new ProcesoIO(nombre, dispositivo));
        System.out.println("Proceso I/O agregado.");
    }

    private static void agregarDaemon(Scanner scanner, GestorProcesos gestor) {
        String nombre = solicitarEntrada(scanner, "Ingresa nombre del Daemon: ");
        String servicio = solicitarEntrada(scanner, "Ingresa servicio: ");
        gestor.agregarProceso(new Daemon(nombre, servicio));
        System.out.println("Daemon agregado.");
    }

    private static void agregarInteractivo(Scanner scanner, GestorProcesos gestor) {
        String nombre = solicitarEntrada(scanner, "Ingresa nombre del Proceso Interactivo: ");
        int nivel = solicitarEntero(scanner, "Ingresa nivel de interactividad (1-5): ");
        gestor.agregarProceso(new ProcesoInteractivo(nombre, nivel));
        System.out.println("Proceso Interactivo agregado.");
    }

    private static void listarProcesos(GestorProcesos gestor) {
        List<IProceso> procesos = gestor.listarProcesos();
        if (procesos.isEmpty()) {
            System.out.println("No hay procesos.");
        } else {
            System.out.println("--- Lista de Procesos ---");
            procesos.forEach(System.out::println);
        }
    }

    private static void ejecutarTodos(GestorProcesos gestor) {
        gestor.ejecutarTodos();
        System.out.println("Todos los procesos ejecutados.");
    }

    private static void eliminarPorPid(Scanner scanner, GestorProcesos gestor) {
        int pid = solicitarEntero(scanner, "Ingresa PID a eliminar: ");
        if (gestor.eliminarPorPid(pid)) {
            System.out.println("Proceso eliminado.");
        } else {
            System.out.println("PID no encontrado.");
        }
    }

    private static void cambiarEstado(Scanner scanner, GestorProcesos gestor) {
        int pid = solicitarEntero(scanner, "Ingresa PID: ");
        System.out.println("Estados: 0=NUEVO, 1=LISTO, 2=EJECUTANDO, 3=BLOQUEADO, 4=TERMINADO");
        int opcion = solicitarEntero(scanner, "Selecciona estado: ");
        if (opcion >= 0 && opcion <= 4) {
            gestor.cambiarEstadoProceso(pid, EstadoProceso.values()[opcion]);
            System.out.println("Estado cambiado.");
        } else {
            System.out.println("Opción inválida.");
        }
    }
}