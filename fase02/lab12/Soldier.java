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

    Soldier() {
        /* Genera un 'placeholder' de soldado, es decir, un soldado vacío */
        this.name = "          ";
        this.flag = "          ";
        this.alive = false;
    }

    Soldier(int i, int id) {
        /* Genera un soldado con estadísticas aleatorias */
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

    Soldier(int a, int d, int hp, int i, int id) {
        /* Genera un soldado con estadísticas específicas */
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

    public void setHP(int v) {
        this.cHP = v;
    }

    public int getcHP() {
        return this.cHP;
    }

    public int getMaxHP() {
        return this.maxHP;
    }
}
