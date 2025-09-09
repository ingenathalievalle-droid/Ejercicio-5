import java.util.Random;

public class Tablero {
    private final int n;
    private final Celda[][] celdas;
    private int barcosTotales;

    public Tablero(int n) {
        this.n = n;
        this.celdas = new Celda[n][n];
        this.barcosTotales = 0;
        this.initTablero();
    }

    private void  initTablero(){
        for(int i=0 ; i<this.n; i++){
            for(int j=0; i<this.n; j++){
                this.celdas[i][j] = new Celda();
            }
        }
    }
    public int getN(){
    return this.n;
    }
    public Celda getCelda(int i , int j) {
        return this.celdas[i][j];
    }
    public int getBarcosTotales(){
        return this.barcosTotales;
    }

    public void ponerBarco(int cantidad, Random rnd){
    }
    public boolean disparar (int i, int j){
        return false;
    }
    public void yaDisparo(int i, int j){
    }
    public void barcosHundidos(){
    }
    public void todosHundidos(){
    }
}

