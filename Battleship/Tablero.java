package Battleship;

import java.util.Random;

public class Tablero
{
    private final int n;
    private final Celda[][] celdas;
    private int barcosTotales;

    public Tablero(int n)
    {
        this.n = n;
        this.celdas = new Celda[n][n];
        this.barcosTotales = 0;

        this.initTablero();
    }

    private void initTablero()
    {
        for (int i = 0; i < this.n; i++)
        {
            for (int j = 0; j < this.n; j++)
            {
                this.celdas[i][j] = new Celda();
            }
        }
    }

    public int getN()
    {
        return this.n;
    }

    public Celda getCelda(int i, int j)
    {
        return this.celdas[i][j];
    }

    public int getBarcosTotales()
    {
        return this.barcosTotales;
    }
    public void colocarBarcos(int cantidad, Random rnd)
    {
        int colocados = 0;

        while (colocados < cantidad)
        {
            int i = rnd.nextInt(this.n);
            int j = rnd.nextInt(this.n);

            if (!this.celdas[i][j].tieneBarco())
            {
                this.celdas[i][j].ponerBarco();
                colocados++;
            }
        }

        this.barcosTotales = cantidad;
    }

    public boolean disparar(int i, int j)
    {

    }

    public boolean yaDisparada(int i, int j)
    {

    }

    public int barcosHundidos()
    {

    }

    public boolean todosHundidos()
    {

    }
}