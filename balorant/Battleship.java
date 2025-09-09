import java.util.Random;

public class Battleship {

    private static final Vista vista = new Vista();
    public final int N=5;
    private final int BARCOS =3;
    private final int DISPAROS_MAX = 12;

    private final Tablero tablero;
    private final Consola consola;

    private final Random rnd = new Random();
    private int disparosUsados = 0;

    public Battleship(){
        this.tablero = new Tablero(this.N);
        this.consola = new Consola();

    }

    /**
     * 
     */
    public void jugar(){
        Battleship.vista.dibujarTablero(this.tablero);
    }
    }
    

