package ejercici5;

public class Daemon extends Proceso {
    private String servicio;

    public Daemon(String nombre, String servicio) {
        super(nombre, TipoProcesos.DAEMON);
        this.servicio = servicio != null ? servicio : "Desconocido";
        setEstado(EstadoProceso.LISTO);
    }

    @Override
    public void ejecutar() {
        setEstado(EstadoProceso.EJECUTANDO);
        for (int i = 0; i < 2; i++) {
            try { Thread.sleep(1500); } catch (InterruptedException e) {}
        }
        setEstado(EstadoProceso.TERMINADO);
    }

    @Override
    public String toString() {
        return super.toString() + ", Servicio: " + servicio;
    }
}
