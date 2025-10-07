package batalla;

public class Orco extends Enemigo {
    public Orco(Output out) {
        super("Orco", 80, 20, out);
    }

    @Override
    public void tomarTurno(Combatiente[] aliados, Combatiente[] enemigos) {
        if (enemigos[0].estaVivo()) {
            enemigos[0].recibirDanio(ataque);
            out.show(nombre + " golpea brutalmente causando " + ataque + " de daño.");
        }
    }

    @Override
    protected int getAtaque() {
        return ataque;
    }

    @Override
    protected void setAtaque(int i) {
        this.ataque = i;
    }

    @Override
    protected void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    protected Output getOutput() {
        return out;
    }

    @Override
    protected void usarHabilidadEspecial(Combatiente objetivo) {
        int danio = ataque * 2; // Ataque especial doble
        objetivo.recibirDanio(danio);
        out.show(nombre + " desata un golpe especial causando " + danio + " de daño!");
    }
}
