package ejercici5;

public class ProcesoUsuario extends Proceso {
    private int nivelInteractividad;

    public ProcesoUsuario(String nombre, int nivel) {
        super(nombre, TipoProcesos.INTERACTIVO);
        this.nivelInteractividad = Math.max(1, Math.min(5, nivel));
        setEstado(EstadoProceso.LISTO);
    }

    public int getNivelInteractividad() { return nivelInteractividad; }
    public void setNivelInteractividad(int nivel) { this.nivelInteractividad = Math.max(1, Math.min(5, nivel)); }

    @Override
    public String toString() {
        return super.toString() + ", Nivel: " + nivelInteractividad;
    }

    @Override
    public void ejecutar() {
        setEstado(EstadoProceso.EJECUTANDO);
        try { Thread.sleep(2500); } catch (InterruptedException e) {}
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        setEstado(EstadoProceso.TERMINADO);
    }
}
