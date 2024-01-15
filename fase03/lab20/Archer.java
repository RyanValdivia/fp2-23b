import java.util.*;

public class Archer extends Soldier {
    private int nArrows;
    Random random = new Random();

    public Archer(String name) {
        super(name);
        this.nArrows = random.nextInt(10);
        this.setAttack(7);
        this.setDefense(3);
        this.setHP(random.nextInt(3) + 3);
        this.setCHP(this.getHP());
    }

    public void setnArrows(int nArrows) {
        this.nArrows = nArrows;
    }

    public int getnArrows() {
        return this.nArrows;
    }
}
