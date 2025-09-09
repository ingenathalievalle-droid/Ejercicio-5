package The_eras_tour;

public class Cliente {
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuesto;
    private int ticketID;
    
    public Cliente(String nombre, 
    String email,
    int cantidadBoletos,
    double presupuesto){
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos =cantidadBoletos;
        this.presupuesto = presupuesto;
        this.ticketID = 0;
    }

    public void generarTicketID() {
        this.ticketID = (int) (Math.random()*15000) +1;
    }

    public int getTicketID() {
        return ticketID;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nEmail: " + email +
        "\nBoletos deseados: " + cantidadBoletos +
        "\nPresupuesto: $" + presupuesto +
        "\nTicket ID: " + ticketID;
    }

}

