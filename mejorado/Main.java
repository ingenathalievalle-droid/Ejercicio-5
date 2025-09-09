package mejorado;
public class Main 
{
    public static void main(String[] args)
    {
        Torneo palatino = new Torneo();
        Equipo t1=new Equipo("barcelona");
        Equipo t2 =new Equipo("atletico de madrid");
        Equipo t3=new Equipo("Real Madrid");
        Equipo t4=new Equipo("Real Madrid");
        Equipo t5=new Equipo("Real Madrid");
        Equipo t6=new Equipo("Real Madrid");

        palatino.addEquipo(t1);
        palatino.addEquipo(t2);
        palatino.addEquipo(t3);
        palatino.addEquipo(t4);
        palatino.addEquipo(t5);
        palatino.addEquipo(t6);

        System.out.println(palatino.getResumen());
    }
}
