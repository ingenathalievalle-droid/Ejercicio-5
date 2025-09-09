package The_eras_tour;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Cliente cliente = null;

            // Se crean las tres localidades con nombre y precio definidos
            Localidad[] localidades = {
                new Localidad("Localidad 1", 100.0),
                new Localidad("Localidad 5", 500.0),
                new Localidad("Localidad 10", 1000.0)
            };

            while (true) {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Nuevo comprador");
                System.out.println("2. Solicitud de boletos");
                System.out.println("3. Ver disponibilidad total");
                System.out.println("4. Ver disponibilidad por localidad");
                System.out.println("5. Reporte de caja");
                System.out.println("6. Salir");
                System.out.print("Elige una opción: ");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Cantidad de boletos deseados: ");
                        int cantidad = sc.nextInt();
                        System.out.print("Presupuesto disponible: ");
                        double presupuesto = sc.nextDouble();
                        sc.nextLine();

                        cliente = new Cliente(nombre, email, cantidad, presupuesto);
                        cliente.generarTicketID();
                        System.out.println("Cliente registrado con éxito.");
                        System.out.println(cliente);
                        break;

                    case 2:
                        if (cliente == null) {
                            System.out.println("Primero se debe registrar un comprador.");
                            break;
                        }

                        Ticket ticket = new Ticket(cliente.getTicketID());
                        ticket.generarRango();

                        if (!ticket.esValido()) {
                            System.out.println("El ticket no fue seleccionado. Intenta de nuevo.");
                            break;
                        }

                        
                        Localidad loc = localidades[new Random().nextInt(localidades.length)];
                        System.out.println("Localidad asignada: " + loc.getNombre());

                        if (!loc.hayEspacio(1)) {
                            System.out.println("La localidad ya está llena.");
                            break;
                        }

                        int maxBoletos = Math.min(loc.disponibles(), cliente.getCantidadBoletos());
                        if (!loc.puedePagar(cliente.getPresupuesto(), maxBoletos)) {
                            System.out.println("No tienes suficiente presupuesto para esta localidad.");
                            break;
                        }

                        int vendidos = loc.venderBoletos(maxBoletos);
                        System.out.println("Se vendieron " + vendidos + " boletos. ¡Diviertete mucho, gracias por tu compra!");
                        cliente = null;
                        break;

                    case 3:
                        System.out.println("--- Disponibilidad total ---");
                        for (Localidad l : localidades)
                            System.out.println(l);
                        break;

                    case 4:
                        System.out.print("Ingresa el número de localidad (1, 5 o 10): ");
                        String entrada = sc.nextLine();
                        String buscada = "Localidad " + entrada;
                        boolean encontrada = false;
                        for (Localidad l : localidades) {
                            if (l.getNombre().equals(buscada)) {
                                System.out.println(l);
                                encontrada = true;
                            }
                        }
                        if (!encontrada) System.out.println("Localidad no encontrada.");
                        break;

                    case 5:
                        double total = 0;
                        for (Localidad l : localidades)
                            total += l.getBoletosVendidos() * l.getPrecio();
                        System.out.println("Total generado en caja: $" + total);
                        break;

                    case 6:
                        System.out.println("Gracias por usar el sistema. ¡Bye!");
                        return;

                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }
    }
}