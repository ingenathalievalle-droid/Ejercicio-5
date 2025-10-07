package batalla;

// Clase abstracta para ítems
public abstract class Item {
    protected String nombre;

    public Item(String nombre) { 
        this.nombre = nombre; 
    }

    public String getNombre() { 
        return nombre; 
    }

    // Cada ítem debe implementar este método
    public abstract void usar(Jugador jugador, Combatiente[] enemigos, Output out);
}
