package batalla;

public class Goblin extends Enemigo {
    public Goblin(Output out) {
        super("Goblin", 60, 15, out);
    }

    @Override
    public void tomarTurno(Combatiente[] aliados, Combatiente[] enemigos) {
        if (rand.nextBoolean()) {
            enemigos[0].recibirDanio(ataque);
            out.show(nombre + " ataca causando " + ataque + " de daño.");
        } else {
            out.show(nombre + " usa evasión, esquivará el próximo ataque.");
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
        int danio = ataque + 5; // Ataque con veneno ligero
        objetivo.recibirDanio(danio);
        out.show(nombre + " lanza un ataque envenenado causando " + danio + " de daño.");
    }
}
