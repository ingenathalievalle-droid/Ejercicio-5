package ejercicio2;

import java.util.ArrayList;

public class GestorEventos {
    private ArrayList<Evento> eventos;

    public GestorEventos() {
        eventos = new ArrayList<>();
    }

    public boolean agregarEvento(Evento nuevo) {
        for (Evento e : eventos) {
            if (e.getSalon().getNombre().equals(nuevo.getSalon().getNombre())) {
                boolean conflicto = !(nuevo.getFin().isBefore(e.getInicio()) || nuevo.getInicio().isAfter(e.getFin()));
                if (conflicto) {
                    return false;
                }
            }
        }
        eventos.add(nuevo);
        return true;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
}