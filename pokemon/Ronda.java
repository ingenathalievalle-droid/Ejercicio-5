package pokemon;

public class Ronda {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private boolean habilidadUsada1;
    private boolean habilidadUsada2;
    private boolean habilidadActivada1;
    private boolean habilidadActivada2;
    private Entrenador ganador;

    public Ronda(Pokemon p1, Pokemon p2, Entrenador e1, Entrenador e2, boolean usar1, boolean usar2) {
        this.pokemon1 = p1;
        this.pokemon2 = p2;
        this.entrenador1 = e1;
        this.entrenador2 = e2;
        this.habilidadUsada1 = usar1;
        this.habilidadUsada2 = usar2;
    }

    public void resolver() {
        if (habilidadUsada1) habilidadActivada1 = pokemon1.activarHabilidad();
        if (habilidadUsada2) habilidadActivada2 = pokemon2.activarHabilidad();
        int ataque1 = pokemon1.calcularAtaqueTotal(pokemon2, habilidadActivada1);
        int ataque2 = pokemon2.calcularAtaqueTotal(pokemon1, habilidadActivada2);
        if (ataque1 > ataque2) ganador = entrenador1;
        else if (ataque2 > ataque1) ganador = entrenador2;
        else ganador = null;
    }

    public Entrenador getGanador() {
        return ganador;
    }

    public String getResumen() {
        String g = (ganador == null) ? "Empate" : ganador.getNombre();
        return "Ronda: " + pokemon1.getNombre() + " vs " + pokemon2.getNombre() + " -> Ganador: " + g;
    }
}