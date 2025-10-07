package ejercici5;
public class ProcesoIO extends Proceso {
    private String dispositivo;

    public ProcesoIO(String nombre, String dispositivo) {
        super(nombre, TipoProcesos.IO);
        this.dispositivo = dispositivo != null ? dispositivo : "Desconocido";
        setEstado(EstadoProceso.LISTO);
    }

    @Override
    public void ejecutar() {
        setEstado(EstadoProceso.BLOQUEADO);
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        setEstado(EstadoProceso.EJECUTANDO);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        setEstado(EstadoProceso.TERMINADO);
    }

    @Override
    public String toString() {
        return super.toString() + ", Dispositivo: " + dispositivo;
    }
}
