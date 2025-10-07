package batalla;

public class Pocion extends Item {
    public Pocion() { 
        super("Poción"); 
    }

    @Override
    public void usar(Jugador jugador, Combatiente[] enemigos, Output out) {
        jugador.curar(30);
        out.show("El jugador usó una Poción.");
    }
}
