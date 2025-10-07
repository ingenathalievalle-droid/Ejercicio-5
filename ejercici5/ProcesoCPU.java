package ejercici5;

public class ProcesoCPU extends Proceso {
    private double intensidadCalculo;

    public ProcesoCPU(String nombre, double intensidad) {
        super(nombre, TipoProcesos.CPU);
        this.intensidadCalculo = Math.max(0.0, Math.min(1.0, intensidad));
        setEstado(EstadoProceso.LISTO);
    }

    @Override
    public void ejecutar() {
        setEstado(EstadoProceso.EJECUTANDO);
        for (int i = 0; i < 3; i++) {
            try { Thread.sleep((long)(1000 * intensidadCalculo)); } catch (InterruptedException e) {}
        }
        setEstado(EstadoProceso.TERMINADO);
    }

    @Override
    public String toString() {
        return super.toString() + ", Intensidad: " + intensidadCalculo;
    }
}
