package batalla;

// Orco Jefe con más vida y ataques extras
public class OrcoJefe extends Orco {
    public OrcoJefe(Output out) {
        super(out);
        this.nombre = "Orco Jefe";
        this.vida = 130;
        this.ataque = 30;
    }

    @Override
    public void tomarTurno(Combatiente[] aliados, Combatiente[] enemigos) {
        super.tomarTurno(aliados, enemigos);
        if (rand.nextInt(100) < 40) {
            enemigos[0].recibirDanio(10);
            out.show(nombre + " realiza un ataque extra de 10 de daño.");
        }
    }
}
