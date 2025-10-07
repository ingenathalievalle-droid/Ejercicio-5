package batalla;

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Principal {
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();
    private static List<String> ultimasAcciones = new ArrayList<>();

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        mostrarIntro();
        
        Jugador jugador = crearJugador(out);
        Combatiente[] enemigos = generarEnemigos(out);
        
        Batalla batalla = new Batalla(jugador, enemigos, out) {
            @Override
            public void iniciar() {
                mostrarIntroduccionBatalla(jugador, enemigos);
                
                while (!terminoBatalla(jugador, enemigos)) {
                    mostrarEstado(jugador, enemigos);
                    procesarTurnoJugador(jugador, enemigos);
                    if (!terminoBatalla(jugador, enemigos)) {
                        procesarTurnoEnemigos(jugador, enemigos);
                    }
                }
                
                mostrarResultadoBatalla(jugador, enemigos);
            }
        };
        
        batalla.iniciar();
    }

    private static void mostrarIntro() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║        BIENVENIDO A LA BATALLA        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("\n¡Prepárate para la aventura!\n");
    }

    private static void mostrarIntroduccionBatalla(Jugador jugador, Combatiente[] enemigos) {
        jugador.mensajeInicial();
        for (Combatiente enemigo : enemigos) {
            enemigo.mensajeInicial();
        }
        System.out.println("\n¡La batalla comienza!\n");
    }

    private static Jugador crearJugador(Output out) {
        System.out.println("Ingresa tu nombre de guerrero:");
        String nombre = sc.nextLine();
        
        System.out.println("\nElige tu rol:");
        System.out.println("1. Guerrero  - Alta vida y ataque, pocos items");
        System.out.println("2. Explorador - Vida y ataque balanceados, muchos items");
        
        int rol = 0;
        while (rol != 1 && rol != 2) {
            rol = sc.nextInt();
            if (rol != 1 && rol != 2) {
                System.out.println("Opción inválida. Elige 1 o 2.");
            }
        }
        
        return new Jugador(nombre, rol == 1 ? "Guerrero" : "Explorador", out);
    }

    private static Combatiente[] generarEnemigos(Output out) {
        int cantidad = 1 + rand.nextInt(3);
        Combatiente[] enemigos = new Combatiente[cantidad];
        
        for (int i = 0; i < cantidad; i++) {
            boolean esJefe = rand.nextDouble() < 0.3; // 30% probabilidad de jefe
            if (rand.nextBoolean()) {
                enemigos[i] = esJefe ? new OrcoJefe(out) : new Orco(out);
            } else {
                enemigos[i] = esJefe ? new GoblinJefe(out) : new Goblin(out);
            }
        }
        
        return enemigos;
    }

    private static void mostrarEstado(Jugador jugador, Combatiente[] enemigos) {
        System.out.println("\n╔═══════ ESTADO DE BATALLA ═══════╗");
        System.out.println("Jugador: " + jugador.getNombre() + 
                         " (HP: " + jugador.getVida() + "/" + jugador.getVida() + ")");
        
        System.out.println("\nEnemigos:");
        for (Combatiente enemigo : enemigos) {
            if (enemigo.estaVivo()) {
                System.out.println("- " + enemigo.getNombre() + 
                                 " (HP: " + enemigo.getVida() + "/" + enemigo.getVida() + ")");
            }
        }

        mostrarUltimasAcciones();
    }

    private static void mostrarUltimasAcciones() {
        System.out.println("\nÚltimas acciones:");
        for (int i = Math.max(0, ultimasAcciones.size() - 3); i < ultimasAcciones.size(); i++) {
            System.out.println("- " + ultimasAcciones.get(i));
        }
    }

    private static void procesarTurnoJugador(Jugador jugador, Combatiente[] enemigos) {
        System.out.println("\n╔═══════ TU TURNO ═══════╗");
        System.out.println("1. Atacar");
        System.out.println("2. Usar Item");
        System.out.println("3. Ver Estado Detallado");
        System.out.println("4. Pasar Turno");
        
        switch (sc.nextInt()) {
            case 1 -> procesarAtaque(jugador, enemigos);
            case 2 -> procesarUsoItem(jugador);
            case 3 -> mostrarEstadoDetallado(jugador, enemigos);
            case 4 -> {
                System.out.println(jugador.getNombre() + " pasa su turno...");
                ultimasAcciones.add(jugador.getNombre() + " pasó su turno");
            }
            default -> System.out.println("Opción inválida, pierdes el turno.");
        }
    }

    private static Object procesarUsoItem(Jugador jugador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'procesarUsoItem'");
    }

    private static void procesarAtaque(Jugador jugador, Combatiente[] enemigos) {
        System.out.println("\n¿A quién quieres atacar?");
        for (int i = 0; i < enemigos.length; i++) {
            if (enemigos[i].estaVivo()) {
                System.out.printf("%d. %s (HP: %d)\n", 
                    i + 1, 
                    enemigos[i].getNombre(), 
                    enemigos[i].getVida());
            }
        }
        
        int objetivo = sc.nextInt() - 1;
        if (objetivo >= 0 && objetivo < enemigos.length && enemigos[objetivo].estaVivo()) {
            jugador.atacar(enemigos[objetivo]);
            ultimasAcciones.add(jugador.getNombre() + " atacó a " + enemigos[objetivo].getNombre());
        }
    }

    // Remove duplicate and misplaced code block. The correct implementation should be inside the procesarUsoItem method.

    private static void mostrarEstadoDetallado(Jugador jugador, Combatiente[] enemigos) {
        System.out.println("\n╔═══════ ESTADO DETALLADO ═══════╗");
        System.out.println("JUGADOR:");
        System.out.println("- Nombre: " + jugador.getNombre());
        System.out.println("- Rol: " + jugador.getRol());
        System.out.println("- Vida: " + jugador.getVida() + "/" + jugador.getVida());
        System.out.println("- Ataque: " + jugador.getAtaque());
        System.out.println("- Items: " + jugador.getItems().size());

        System.out.println("\nENEMIGOS:");
        for (Combatiente enemigo : enemigos) {
            if (enemigo.estaVivo()) {
                System.out.println("\n" + enemigo.getNombre());
                System.out.println("- Vida: " + enemigo.getVida() + "/" + enemigo.getVida());
                System.out.println("- Ataque: " + enemigo.getAtaque());
            }
        }
    }

    private static void mostrarResultadoBatalla(Jugador jugador, Combatiente[] enemigos) {
        System.out.println("\n╔═══════ FIN DE LA BATALLA ═══════╗");
        boolean victoria = jugador.estaVivo();
        
        if (victoria) {
            System.out.println("¡Victoria! Has derrotado a todos los enemigos.");
        } else {
            System.out.println("Derrota... Has caído en batalla.");
        }
        
        jugador.mensajeFinal(victoria);
    }

    private static void procesarTurnoEnemigos(Jugador jugador, Combatiente[] enemigos) {
        for (Combatiente enemigo : enemigos) {
            if (enemigo.estaVivo()) {
                System.out.println("\n╔═══════ TURNO ENEMIGO ═══════╗");
                enemigo.tomarTurno(enemigos, new Combatiente[]{jugador});
                ultimasAcciones.add(enemigo.getNombre() + " tomó su turno");
            }
        }
    }

    private static boolean terminoBatalla(Jugador jugador, Combatiente[] enemigos) {
        return !jugador.estaVivo() || todosEnemigosDerrotados(enemigos);
    }

    private static boolean todosEnemigosDerrotados(Combatiente[] enemigos) {
        for (Combatiente enemigo : enemigos) {
            if (enemigo.estaVivo()) {
                return false;
            }
        }
        return true;
    }
}