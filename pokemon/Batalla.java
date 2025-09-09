package pokemon;

import java.util.*;

public class Batalla {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int rondasGanadas1 = 0;
    private int rondasGanadas2 = 0;
    private List<Ronda> rondas = new ArrayList<>();

    public Batalla(Entrenador e1, Entrenador e2) {
        this.entrenador1 = e1;
        this.entrenador2 = e2;
    }

    public void iniciarBatalla() {
        // lógica movida a Juego
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public String getGanadorFinal() {
        if (rondasGanadas1 > rondasGanadas2) return entrenador1.getNombre();
        else if (rondasGanadas2 > rondasGanadas1) return entrenador2.getNombre();
        else return "Empate";
    }

    public String getEstadisticasFinales() {
        int total = rondas.size();
        double porcentaje1 = (rondasGanadas1 * 100.0) / total;
        double porcentaje2 = (rondasGanadas2 * 100.0) / total;
        return "Estadísticas:\n" +
               entrenador1.getNombre() + ": " + rondasGanadas1 + " rondas ganadas (" + String.format("%.2f", porcentaje1) + "%)\n" +
               entrenador2.getNombre() + ": " + rondasGanadas2 + " rondas ganadas (" + String.format("%.2f", porcentaje2) + "%)";
    }

    public void registrarGanador(Entrenador ganador) {
        if (ganador == entrenador1) rondasGanadas1++;
        else if (ganador == entrenador2) rondasGanadas2++;
    }
}