package batalla;

public class Bomba extends Item {
    public Bomba() { 
        super("Bomba"); 
    }

    @Override
    public void usar(Jugador jugador, Combatiente[] enemigos, Output out) {
        for (Combatiente e : enemigos) {
            if (e.estaVivo()) {
                e.recibirDanio(20);
                out.show("Bomba explotó causando 20 de daño a " + e.getNombre());
            }
        }
    }
}
