package pokemon;

public class Pokemon {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private Habilidad habilidad;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, Habilidad habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean activarHabilidad() {
        return habilidad.seActiva();
    }

    public int calcularAtaqueTotal(Pokemon oponente, boolean habilidadActiva) {
        int total = ataque;
        int bonus = getVentajaTipo(oponente.tipo);
        total += bonus;
        if (habilidadActiva) {
            if (habilidad.getTipoEfecto().equals("ataque")) total += habilidad.getValor();
            else if (habilidad.getTipoEfecto().equals("defensa")) total += defensa + habilidad.getValor();
            else if (habilidad.getTipoEfecto().equals("daño")) total += habilidad.getValor();
        } else {
            total += defensa;
        }
        return total;
    }

    private int getVentajaTipo(String tipoOponente) {
        if (tipo.equals("fuego") && tipoOponente.equals("planta")) return 20;
        if (tipo.equals("agua") && tipoOponente.equals("fuego")) return 20;
        if (tipo.equals("planta") && tipoOponente.equals("agua")) return 20;
        if (tipo.equals("eléctrico") && tipoOponente.equals("agua")) return 20;
        if (tipo.equals("fuego") && tipoOponente.equals("agua")) return -10;
        if (tipo.equals("agua") && tipoOponente.equals("planta")) return -10;
        if (tipo.equals("planta") && tipoOponente.equals("fuego")) return -10;
        if (tipo.equals("agua") && tipoOponente.equals("eléctrico")) return -10;
        return 0;
    }
}