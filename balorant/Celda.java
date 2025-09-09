public class Celda {
    private boolean tieneBarco;
    private boolean disparado;

    public Celda() {
        this.tieneBarco = false;
        this.disparado = false;
    }
    
    public boolean tieneBarco(){
        return this.tieneBarco;
    }
    public boolean estaDisparado(){
        return this.disparado;
    }
    public void ponerBarco(){
        this.tieneBarco = true;
    }
    public void disparar(){
        this.disparado = true;
    }
    @Override
    public String toString(){
        if(this.disparado){
            return ".";
        } else {
            return this.tieneBarco ? "X" : "O";
        }
    }
}
