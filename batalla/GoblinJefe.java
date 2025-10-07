package batalla;

public class GoblinJefe extends Goblin {
    public GoblinJefe(Output out) {
        super(out);
        this.nombre = "Goblin Jefe";
        this.vida = 100;
        this.ataque = 25;
    }

    @Override
    public void tomarTurno(Combatiente[] aliados, Combatiente[] enemigos) {
        super.tomarTurno(aliados, enemigos);
        if (rand.nextInt(100) < 30) {
            this.vida += 10;
            out.show(nombre + " se cura 10 puntos de vida.");
        }
    }
}
