package batalla;

// Clase abstracta base para jugador y enemigos
public abstract class Combatiente {
    protected String nombre;
    public int vida;
    private int vidaMaxima;
    public int ataque;
    protected Output out;

    public Combatiente(String nombre, int vidaMaxima, int ataque, Output out) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.ataque = ataque;
        this.out = out;
    }
    
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public boolean estaVivo() { return vida > 0; }

    public void recibirDanio(int dmg) {
        vida -= dmg;
        if (vida < 0) vida = 0;
    }

    // Métodos abstractos
    public abstract void mensajeInicial();
    public abstract void mensajeFinal(boolean gano);
    public abstract void tomarTurno(Combatiente[] aliados, Combatiente[] enemigos);

    protected abstract int getAtaque();

    protected abstract void setAtaque(int i);

    protected abstract void setVida(int min);

    public void curar(int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'curar'");
    }
}
