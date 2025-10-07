package batalla;

public class Elixir extends Item {
    public Elixir() { 
        super("Elixir"); 
    }

    @Override
    public void usar(Jugador jugador, Combatiente[] enemigos, Output out) {
        jugador.boostAtaque(10);
        out.show("El jugador usó un Elixir. ¡Ataque aumentado en 10!");
    }
}

