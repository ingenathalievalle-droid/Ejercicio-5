package pokemon;

import java.util.*;

public class Juego {
    public void iniciar() {
        try (Scanner scanner = new Scanner(System.in)) {
            Habilidad h1 = new Habilidad("Furia", "ataque", 30, 50);
            Habilidad h2 = new Habilidad("Escudo", "defensa", 20, 40);
            Habilidad h3 = new Habilidad("Golpe Crítico", "daño", 25, 60);
            Habilidad h4 = new Habilidad("Carga", "ataque", 15, 70);
            Habilidad h5 = new Habilidad("Barrera", "defensa", 10, 80);
            Habilidad h6 = new Habilidad("Explosión", "daño", 35, 30);
            Habilidad h7 = new Habilidad("Rayo", "ataque", 20, 50);
            Habilidad h8 = new Habilidad("Muro", "defensa", 25, 50);

            Pokemon p1 = new Pokemon("Charmander", "fuego", 50, 30, h1);
            Pokemon p2 = new Pokemon("Squirtle", "agua", 40, 40, h2);
            Pokemon p3 = new Pokemon("Pikachu", "eléctrico", 45, 35, h3);
            Pokemon p4 = new Pokemon("Bulbasaur", "planta", 35, 45, h4);
            Pokemon p5 = new Pokemon("Growlithe", "fuego", 55, 25, h5);
            Pokemon p6 = new Pokemon("Psyduck", "agua", 38, 42, h6);
            Pokemon p7 = new Pokemon("Magnemite", "eléctrico", 48, 32, h7);
            Pokemon p8 = new Pokemon("Oddish", "planta", 36, 44, h8);

            List<Pokemon> equipo1 = Arrays.asList(p1, p2, p3, p4);
            List<Pokemon> equipo2 = Arrays.asList(p5, p6, p7, p8);

            Entrenador e1 = new Entrenador("Ash", equipo1);
            Entrenador e2 = new Entrenador("Misty", equipo2);

            Batalla batalla = new Batalla(e1, e2);

            for (int i = 0; i < 4; i++) {
                Pokemon poke1 = e1.elegirPokemon();
                Pokemon poke2 = e2.elegirPokemon();

                System.out.println("Ronda " + (i + 1));
                System.out.println(e1.getNombre() + " usará a " + poke1.getNombre() + ". ¿Deseas usar habilidad especial? (s/n)");
                boolean usarHabilidad1 = scanner.nextLine().trim().equalsIgnoreCase("s");

                System.out.println(e2.getNombre() + " usará a " + poke2.getNombre() + ". ¿Deseas usar habilidad especial? (s/n)");
                boolean usarHabilidad2 = scanner.nextLine().trim().equalsIgnoreCase("s");

                Ronda ronda = new Ronda(poke1, poke2, e1, e2, usarHabilidad1, usarHabilidad2);
                ronda.resolver();
                batalla.getRondas().add(ronda);
            }

            for (Ronda r : batalla.getRondas()) {
                System.out.println(r.getResumen());
            }
            System.out.println("Ganador final: " + batalla.getGanadorFinal());
            System.out.println(batalla.getEstadisticasFinales());
        }
    }
}