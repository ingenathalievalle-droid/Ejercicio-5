package ejercici5;

public interface IProceso {
    void ejecutar();
    int getPid();
    String getNombre();
    EstadoProceso getEstado();
    void setEstado(EstadoProceso nuevoEstado);
}
