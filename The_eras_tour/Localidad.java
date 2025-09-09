package The_eras_tour;

public class Localidad {
    private String nombre;
    private double precio;
    private int capacidadMaxima = 20;
    private int boletosVendidos = 0;

    public Localidad(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public int disponibles() {
        return capacidadMaxima - boletosVendidos;
    }

    public boolean hayEspacio(int cantidadDeseada) {
        return disponibles() >= cantidadDeseada;
    }

    public boolean puedePagar(double presupuesto, int cantidad) {
        return presupuesto >= cantidad * precio;
    }

    public int venderBoletos(int cantidad) {
        int aVender = Math.min(cantidad, disponibles());
        boletosVendidos += aVender;
        return aVender;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public String toString() {
        return nombre + " - Vendidos: " + boletosVendidos +
        ", Disponibles: " + disponibles();
    }
}

