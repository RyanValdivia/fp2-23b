import java.util.*;

public class Swordsman extends Soldier {
    private int swordLong;
    Random random = new Random();

    public Swordsman(String name) {
        super(name);
        this.swordLong = random.nextInt(10);
        this.setAttack(10);
        this.setDefense(8);
        this.setHP(random.nextInt(3) + 8);
        this.setCHP(this.getHP());
    }

    public int getSwordLong() {
        return this.swordLong;
    }

    public void setSwordLong(int swordLong) {
        this.swordLong = swordLong;
    }

    public void createWall() {
        this.setDefense(this.getDefense() + 1);
    }
}
