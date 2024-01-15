public class Soldier {
    private String name;
    private int HP;
    private int cHP;
    private int row;
    private int col;
    private boolean status;
    private int attack;
    private int defense;
    private String flag;
    private String alias;

    public Soldier() {
        this.name = "            ";
        this.flag = "            ";
        this.status = false;
        this.alias = "    ";
    }

    public Soldier(String name) {
        this.name = name;
        this.status = true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setCHP(int cHP) {
        this.cHP = cHP;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getFlag() {
        return this.flag;
    }

    public String getName() {
        return this.name;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getHP() {
        return this.HP;
    }

    public int getcHP() {
        return this.cHP;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public int getDefense() {
        return this.defense;
    }

    public boolean getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Soldado " + this.name + "\n"
                + "HP: " + this.HP + "/" + this.cHP + "\n"
                + "Posición: " + this.row + ", " + this.col + "\n";
    }
}
