public class Soldier {
    private String name;
    private int atk;
    private int def;
    private int cHP;
    private int maxHP;
    private String flag;
    private boolean alive;
    private int id;
    private int row;
    private int column;

    /**
     * Genera un 'placeholder' de soldado, es decir, un soldado vacío
     */

    Soldier() {
        this.name = "          ";
        this.flag = "          ";
        this.alive = false;
    }

    /**
     * Genera un soldado con estadísticas aleatorias
     */

    Soldier(int i, int id) {
        this.name = "Soldado" + i + "X" + id;
        int v = (int) (Math.random() * 5) + 1;
        int a = (int) (Math.random() * 5) + 1;
        int d = (int) (Math.random() * 5) + 1;

        this.maxHP = v;
        this.cHP = v;
        this.atk = a;
        this.def = d;

        this.alive = true;
        if (id == 1) {
            this.flag = "##########";
        } else {
            this.flag = "**********";
        }
    }

    /** Genera un soldado con estadísticas específicas */

    Soldier(int a, int d, int hp, int i, int id) {
        this.name = "Soldado" + i + "X" + id;

        this.atk = a;
        this.def = d;
        this.cHP = hp;
        this.maxHP = hp;

        if (id == 1) {
            this.flag = "##########";
        } else {
            this.flag = "**********";
        }
    }

    public void setPosition(int y, int x) {
        this.row = y;
        this.column = x;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setHP(int v) {
        this.cHP = v;
    }

    public int getcHP() {
        return this.cHP;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public boolean getStatus() {
        return this.alive;
    }

    public String getFlag() {
        return this.flag;
    }

    public String getName() {
        return this.name;
    }

    public int getDefense() {
        return this.def;
    }
}
