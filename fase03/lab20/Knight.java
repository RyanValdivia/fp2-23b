import java.util.Random;

public class Knight extends Soldier {
    private String weapon;
    private boolean isMounted;
    Random random = new Random();

    public Knight(String name) {
        super(name);
        this.setAttack(13);
        this.setDefense(7);
        this.setHP(random.nextInt(3) + 10);
        this.setCHP(this.getHP());
    }

    public void unMount() {
        this.isMounted = false;
        this.weapon = "Sword";
    }

    public void mount() {
        this.isMounted = true;
        this.weapon = "Spear";
    }

    public String getWeapon() {
        return this.weapon;
    }

    public boolean isMounted() {
        return this.isMounted;
    }
}
