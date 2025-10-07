package ejercici5;

import java.util.ArrayList;
import java.util.List;

public class GestorProcesos {
    private List<IProceso> lista;
    private int nextPid = 1;

    public GestorProcesos() {
        this.lista = new ArrayList<>();
    }

    public void agregarProceso(IProceso proceso) {
        if (proceso.getPid() == 0) {
            ((Proceso) proceso).setPid(generarPid());
        }
        lista.add(proceso);
        proceso.setEstado(EstadoProceso.LISTO);
    }

    private int generarPid() {
        return nextPid++;
    }

    public List<IProceso> listarProcesos() {
        return lista;
    }

    public void ejecutarTodos() {
        for (IProceso p : lista) {
            if (p.getEstado() == EstadoProceso.LISTO || p.getEstado() == EstadoProceso.EJECUTANDO) {
                p.ejecutar();
            }
        }
    }

    public boolean eliminarPorPid(int pid) {
        return lista.removeIf(p -> p.getPid() == pid);
    }

    public boolean cambiarEstadoProceso(int pid, EstadoProceso nuevoEstado) {
        for (IProceso p : lista) {
            if (p.getPid() == pid) {
                p.setEstado(nuevoEstado);
                return true;
            }
        }
        return false;
    }
}
