package Battleship;

import java.util.Random;

public class Battleship
{
    private final int N = 5;
    private final int BARCOS = 3;
    private final int DISPAROS_MAX = 12;

    private final Tablero tablero;
    private final Consola vista;

    private final Random rnd = new Random();
    private int disparosUsados = 0;

    public Battleship()
    {
        this.tablero = new Tablero(this.N);
        this.vista = new Consola();
    }



    

    public void jugar()
    {

        this.tablero.colocarBarcos(this.BARCOS, this.rnd);

        this.vista.mostrarBienvenida(this.N, this.BARCOS, this.DISPAROS_MAX);

        this.disparosUsados = 0;

        this.vista.dibujarTablero(this.tablero);
    }
}