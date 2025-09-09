package The_eras_tour;

public class Ticket {
    private int ticketID;
    private int a, b; 

    public Ticket(int ticketID) {
        this.ticketID = ticketID;
    }

    public void generarRango() {
        this.a = (int)(Math.random() * 15000) + 1;
        this.b = (int)(Math.random() * 15000) + 1;
    }

    public boolean esValido() {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return ticketID >= min && ticketID <= max;
    }
}
    
