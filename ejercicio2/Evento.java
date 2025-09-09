package ejercicio2;

import java.time.LocalDateTime;
import java.time.Duration;

public class Evento {
    private String nombre;
    private Salon salon;
    private LocalDateTime inicio;
    private LocalDateTime fin;

    public Evento(String nombre, Salon salon, LocalDateTime inicio, LocalDateTime fin) {
        this.nombre = nombre;
        this.salon = salon;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getNombre() {
        return nombre;
    }

    public Salon getSalon() {
        return salon;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public double calcularCosto() {
        long horas = Duration.between(inicio, fin).toHours();
        return horas * salon.getPrecioPorHora();
    }

    public String getDetalle() {
        return "Evento: " + nombre +
               "Salón: " + salon.getNombre() +
               "Inicio: " + inicio +
               "Fin: " + fin +
               "Costo total: Q" + calcularCosto();
    }
}
