package batalla;

import java.util.LinkedList;
import java.util.Queue;

public class Batalla {
    private Jugador jugador;
    private Combatiente[] enemigos;
    private Output out;
    private Queue<String> registro = new LinkedList<>();

    public Batalla(Jugador jugador, Combatiente[] enemigos, Output out) {
        this.jugador = jugador;
        this.enemigos = enemigos;
        this.out = out;
    }

    public void iniciar() {
        jugador.mensajeInicial();
        for (Combatiente e : enemigos) e.mensajeInicial();

        while (jugador.estaVivo() && quedanEnemigos()) {
            mostrarEstado();

            jugador.tomarTurno(new Combatiente[]{jugador}, enemigos);
            registrar("Jugador tomó su turno");

            for (Combatiente e : enemigos) {
                if (e.estaVivo()) {
                    e.tomarTurno(enemigos, new Combatiente[]{jugador});
                    registrar(e.getNombre() + " actuó");
                }
            }
        }

        jugador.mensajeFinal(jugador.estaVivo());
        for (Combatiente e : enemigos)
            e.mensajeFinal(e.estaVivo());
    }

    private void mostrarEstado() {
        out.show("\n--- Estado ---");
        out.show("Jugador: " + jugador.getNombre() + " (vida: " + jugador.getVida() + ")");
        for (Combatiente e : enemigos)
            out.show(e.getNombre() + " (vida: " + e.getVida() + ")");
        out.show("Últimas acciones: " + registro);
    }

    private boolean quedanEnemigos() {
        for (Combatiente e : enemigos)
            if (e.estaVivo()) return true;
        return false;
    }

    private void registrar(String accion) {
        if (registro.size() == 3) registro.poll();
        registro.add(accion);
    }
}
