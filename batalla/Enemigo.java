package batalla;

import java.util.Random;

public abstract class Enemigo extends Combatiente {
    protected Random rand = new Random();

    public Enemigo(String nombre, int vida, int ataque, Output out) {
        super(nombre, vida, ataque, out);
    }

    @Override
    public void mensajeInicial() {
        getOutput().show(getNombre() + " aparece listo para luchar.");
    }

    protected abstract Output getOutput();

    @Override
    public void mensajeFinal(boolean gano) {
        if (gano) {
            getOutput().show(getNombre() + " ríe victorioso.");
        } else {
            getOutput().show(getNombre() + " ha sido derrotado.");
        }
    }

    @Override
    public void tomarTurno(Combatiente[] aliados, Combatiente[] enemigos) {
        // Probabilidad de usar habilidad especial (30%)
        if (rand.nextDouble() < 0.3) {
            usarHabilidadEspecial(enemigos[0]);
            getOutput().show(getNombre() + " usa su habilidad especial!");
            return;
        }

        // Ataque normal
        if (enemigos.length > 0 && enemigos[0].estaVivo()) {
            atacar(enemigos[0]);
        }
    }

    protected void atacar(Combatiente objetivo) {
        if (objetivo.estaVivo()) {
            int daño = getAtaque();
            objetivo.recibirDanio(daño);
            getOutput().show(getNombre() + " ataca a " + objetivo.getNombre() + 
                           " causando " + daño + " de daño!");
        }
    }

    // Método abstracto que deben implementar las subclases
    protected abstract void usarHabilidadEspecial(Combatiente objetivo);

    // Métodos heredados de Combatiente que podrían ser útiles
    @Override
    public boolean estaVivo() {
        return getVida() > 0;
    }

    @Override
    public void recibirDanio(int cantidad) {
        setVida(Math.max(0, getVida() - cantidad));
    }

    @Override
    public void curar(int cantidad) {
        setVida(Math.min(getVida(), getVida() + cantidad));
    }
}
