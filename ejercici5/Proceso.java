package ejercici5;

import java.util.Objects;

public abstract class Proceso implements IProceso {
    private int pid;
    private String nombre;
    private EstadoProceso estado;
    private int prioridad;
    private TipoProcesos tipo;

    public Proceso(int pid, String nombre, TipoProcesos tipo) {
        this.pid = pid;
        this.nombre = nombre;
        this.estado = EstadoProceso.NUEVO;
        this.prioridad = 5;
        this.tipo = tipo;
    }

    public Proceso(String nombre, TipoProcesos tipo) {
        this(0, nombre, tipo);
    }

    @Override
    public int getPid() { return pid; }
    public void setPid(int pid) { this.pid = pid; }
    @Override
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    @Override
    public EstadoProceso getEstado() { return estado; }
    @Override
    public void setEstado(EstadoProceso estado) { this.estado = estado; }
    public int getPrioridad() { return prioridad; }
    public void setPrioridad(int prioridad) { this.prioridad = Math.max(1, Math.min(10, prioridad)); }
    public TipoProcesos gTipoProcesos() { return tipo; }

    @Override
    public abstract void ejecutar();

    @Override
    public String toString() {
        return String.format("[%s] PID: %d, Nombre: %s, Estado: %s, Prioridad: %d",
                tipo, pid, nombre, estado, prioridad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Proceso proceso = (Proceso) obj;
        return pid == proceso.pid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid);
    }
}
