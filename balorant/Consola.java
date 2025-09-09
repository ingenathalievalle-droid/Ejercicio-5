
import java.util.Scanner;

public class Consola {
    public final Scanner sc;

    public Consola (){
        this.sc = new Scanner(System.in);
    }

    public void dibujarTablero(Tablero t){
        int n = t.getN();
        print("   ");
        for (int j=0; j<n; j++){
            String i = null;
            print(i +  " ");
        }

        println("");
        for (int i=0; i<n; i++){
            print((char)('A' + i) + " ");
            for (int j=0; j<n; j++){
                print(t.getCelda(i, j) + " ");
            }
            println("");
        }
        println("");
    }
    public void print(String s){
        System.out.print(s);
    }
    public void println(String t){
        System.out.println(t);
    }
    
}
