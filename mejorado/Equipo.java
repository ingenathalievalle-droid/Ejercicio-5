package mejorado;
public class Equipo {
    String nombre;
    int puesto, esquinas,ganados,perdidos;
    int tiros, goles, amarillas, rojas, faltas;

    public Equipo(String nombre)
    {
        this.nombre= nombre;
        this.puesto=0;
        this.amarillas=0;
        this.goles=0;


    }
    public Equipo(String nombre, int puesto, int goles)
    {
        this.nombre = nombre;
        this.puesto=puesto;
        this.goles=goles;
    }

    public int getgoles()
    {
        return this.goles;
    }
    public void anotar()
    {

        this.goles++;
    }

    public void quitarGol()
    {
        this.goles--;
    }
    public String toString()
    {
        return this.nombre + "\n" + "Puesto: " + this.puesto + "\n" + "Goles: " + this.goles;
    }
    public void setgoles(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setgoles'");
    }
}
