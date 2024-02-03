public class Soldado {
    private String nombre;
    private int nAtaque;
    private int nDefensa;
    private int nVida;
    private int vidaActual;
    private String estado;
    private boolean vivo;
    private int fila;
    private int columna;
    private String bandera;

    public Soldado(String name, int atk, int def, int hp, int nro) {
        this.nombre = name;
        this.nAtaque = atk;
        this.nDefensa = def;
        this.nVida = hp;
        this.vidaActual = hp;
        this.vivo = true;
        switch (nro) {
            case 1:
                this.bandera = "##########";
                break;
            case 2:
                this.bandera = "**********";
            default:
                break;
        }
    }

    public Soldado() {
        this.nombre = "          ";
        this.bandera = "          ";
        this.vivo = false;
    }

    public void moverSoldado(int x, int y) {
        this.fila = x;
        this.columna = y;
    }

    public void setVidaActual(int s) {
        this.vidaActual = s;
    }

    public int getVidaActual() {
        return this.vidaActual;
    }

    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return this.columna;
    }

    public String getBandera() {
        return this.bandera;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getVida() {
        return this.nVida;
    }

    public int getDefensa() {
        return this.nDefensa;
    }

    public void morir() {
        this.vivo = false;
        this.nombre = "          ";
        this.bandera = "          ";
        this.nVida = 0;
        this.nAtaque = 0;
        this.nDefensa = 0;
    }
}
