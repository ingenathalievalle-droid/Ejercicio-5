package batalla;

import items.Pocion;
import java.util.ArrayList;
import java.util.List;

public class Jugador extends Combatiente {
    public static final String ROL_GUERRERO = "Guerrero";
    private List<Pocion> items;
    private String rol;

    public Jugador(String nombre, String rol, Output out) {
        super(nombre, 
              rol.equals(ROL_GUERRERO) ? 150 : 100,  // vida máxima
              rol.equals(ROL_GUERRERO) ? 20 : 15,    // ataque
              out);
        
        this.rol = rol;
        this.items = new ArrayList<>();
        inicializarItems();
    }

    public Jugador(String nombre, Object object, Output out) {
        super(nombre, 100, 15, out);
        this.rol = "Desconocido";
        this.items = new ArrayList<>();
        inicializarItems();
    }

    private void inicializarItems() {
        if (rol.equals(ROL_GUERRERO)) {
            items.add(new Pocion());
        } else {
            items.add(new Pocion());
            items.add(new Pocion());
        }
    }

    public void usarItem(int indice, Combatiente objetivo) {
        if (indice >= 0 && indice < items.size()) {
            Pocion item = items.get(indice);
            item.usar(objetivo);
            items.remove(indice);
        }
    }

    void atacar(Combatiente enemigo) {
        if (enemigo.estaVivo()) {
            int danio = getAtaque();
            enemigo.recibirDanio(danio);
            System.out.println(getNombre() + " ataca a " + enemigo.getNombre() + " causando " + danio + " de daño!");
        }
    }

    @Override
    public int getAtaque() {
        return ataque;
    }

    @Override
    public void mensajeInicial() {
        System.out.println("¡" + getNombre() + " el " + rol + " ha entrado en batalla!");
    }

    @Override
    public void mensajeFinal(boolean gano) {
        if (gano) {
            System.out.println("¡" + getNombre() + " el " + rol + " ha ganado la batalla!");
        } else {
            System.out.println(getNombre() + " el " + rol + " ha sido derrotado...");
        }
    }

    @Override
    public void tomarTurno(Combatiente[] aliados, Combatiente[] enemigos) {
        if (getVida() < 50) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) instanceof Pocion) {
                    usarItem(i, this);
                    return;
                }
            }
        }

        Combatiente objetivo = null;
        int menorVida = Integer.MAX_VALUE;
        
        for (Combatiente enemigo : enemigos) {
            if (enemigo.estaVivo() && enemigo.getVida() < menorVida) {
                objetivo = enemigo;
                menorVida = enemigo.getVida();
            }
        }

        if (objetivo != null) {
            atacar(objetivo);
        }
    }

    public void boostAtaque(int cantidad) {
        setAtaque(getAtaque() + cantidad);
    }

    @Override
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
    public void curar(int cantidad) {
        setVida(Math.min(getVida() + cantidad, 150)); // usar vida máxima real si quieres
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }

    public List<Pocion> getItems() {
        return items;
    }

    public String getRol() {
        return rol;
    }
}