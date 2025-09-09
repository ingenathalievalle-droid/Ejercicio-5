package ejercicio2;

public class Salon {
    private String nombre;
    private int capacidad;
    private double precioPorHora;

    public Salon(String nombre, int capacidad, double precioPorHora) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioPorHora = precioPorHora;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public String getInformacion() {
        return "Salón: " + nombre + ", Capacidad: " + capacidad + ", Precio por hora: Q" + precioPorHora;
    }
}