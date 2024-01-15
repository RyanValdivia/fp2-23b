import java.util.Random;

public class Spearman extends Soldier {
    private int spearLong;
    private static int quantity;
    Random random = new Random();

    public Spearman(String name) {
        super(name);
        this.spearLong = random.nextInt(10);
        this.setAttack(5);
        this.setDefense(8);
        this.setHP(random.nextInt(3) + 8);
        this.setCHP(this.getHP());
        quantity++;
    }

    public void setSpearLong(int spearLong) {
        this.spearLong = spearLong;
    }

    public int getSpearLong() {
        return this.spearLong;
    }

    public void schiltrom() {
        this.setDefense(this.getDefense() + 1);
    }

    public static int getQuantity() {
        return quantity;
    }

}
