package pokemon;

import java.util.*;

public class Habilidad {
    private String tipoEfecto;
    private int valor;
    private int probabilidad;

    public Habilidad(String nombre, String tipoEfecto, int valor, int probabilidad) {
        this.tipoEfecto = tipoEfecto;
        this.valor = valor;
        this.probabilidad = probabilidad;
    }

    public boolean seActiva() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        return chance < probabilidad;
    }

    public String getTipoEfecto() {
        return tipoEfecto;
    }

    public int getValor() {
        return valor;
    }
}