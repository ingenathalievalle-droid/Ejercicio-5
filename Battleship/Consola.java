package Battleship;

import java.util.Scanner;

public class Consola
{
    public final Scanner sc;

    public Consola()
    {
        this.sc = new Scanner(System.in);

    }
    public void mostrarBienvenida(int n, int barcos, int disparosMax) {
        print(" === 🚢 BATLESHIP 💣 ===");
        println("Tableros: " + n + "x" + n);
        println("Filas A - " + (char) ('A') + " - " + (char) ('A' + n - 1) + " y Columnas 0 - " + (n-1));
        println("Barcos a hundir: " + barcos);
        println("Comandos: \n\t Coordenada (E1) \n\t Salir (exit) \n\t Reiniciar (reset)");
    }

    public void dibujarTablero(Tablero t)
    {
        int n = t.getN();
        print("   ");

        for(int i = 0; i <= n; i++)
        {
            print(i + " ");
        }
        println("");

        for (int i = 0; i < n; i++)
        {

            print((char) ('A' + i) + "  " );
            for (int j = 0; j < n; j++)
            {
                print(t.getCelda(i, j) + " ");
            }

            println("");
        }

        println("");
    }

    public void print(String s)
    {
        System.out.print(s);
    }


    public void println(String s)
    {
        System.out.println(s);

    }    
}