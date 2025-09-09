package pokemon;

import java.util.*;

public class Entrenador {
    private String nombre;
    private List<Pokemon> equipo;
    private List<Pokemon> pokemonUsados = new ArrayList<>();

    public Entrenador(String nombre, List<Pokemon> equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon elegirPokemon() {
        for (Pokemon p : equipo) {
            if (!pokemonUsados.contains(p)) {
                pokemonUsados.add(p);
                return p;
            }
        }
        return equipo.get(0);
    }
}