import java.util.*;

public class Army {
    private List<Soldier> soldiers = new ArrayList<>();
    private String[] reinos = new String[] {
            "Inglaterra", "Francia", "Castilla-Aragon", "Moros", "Sacro Imperio Romano Germanico" };
    private String reino;
    private int nArmy;
    private int nArchers = 0;
    private int nKnights = 0;
    private int nSwords = 0;
    private int nSpears = 0;

    Random random = new Random();

    public Army(int n) {
        this.reino = reinos[random.nextInt(reinos.length)];
        this.nArmy = n;
    }

    public void initialize() {
        String flag = (this.nArmy == 1) ? "############" : "************";
        for (int i = 0; i < random.nextInt(10) + 1; i++) {
            switch (random.nextInt(4) + 1) {
                case 1:
                    Archer a = new Archer("Archer" + i + "X" + nArmy);
                    a.setFlag(flag);
                    a.setAlias("A" + i + "X" + nArmy);
                    nArchers++;
                    soldiers.add(a);
                    break;
                case 2:
                    Knight k = new Knight("Knight" + i + "X" + nArmy);
                    k.setFlag(flag);
                    k.setAlias("K" + i + "X" + nArmy);
                    nKnights++;
                    soldiers.add(k);
                    break;
                case 3:
                    Spearman s = new Spearman("Spearman" + i + "X" + nArmy);
                    s.setFlag(flag);
                    s.setAlias("S" + i + "X" + nArmy);
                    nSpears++;
                    soldiers.add(s);
                    break;
                case 4:
                    Swordsman w = new Swordsman("Swordsman" + i + "X" + nArmy);
                    w.setFlag(flag);
                    w.setAlias("W" + i + "X" + nArmy);
                    nSwords++;
                    soldiers.add(w);
                    break;
            }
        }
    }

    public void perk() {
        for (Soldier s : soldiers) {
            s.setHP(s.getcHP() + 1);
            s.setCHP(s.getHP());
        }
    }

    public int getnArmy() {
        return this.nArmy;
    }

    public String getReino() {
        return this.reino;
    }

    public String[] getReinos() {
        return this.reinos;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public List<Soldier> getSoldiers() {
        return this.soldiers;
    }

    public int totalHP() {
        int total = 0;
        for (Soldier s : this.soldiers) {
            total += s.getHP();
        }
        return total;
    }

    public void show() {
        System.out.println("Ejercito " + this.nArmy);
        System.out.println("Reino: " + this.reino);
        System.out.println();
        for (Soldier s : this.soldiers) {
            System.out.println(s);
        }
        System.out.println();
    }

    public Soldier getMaxHP() {
        int max = 0;
        for (int i = 0; i < this.soldiers.size(); i++) {
            if (this.soldiers.get(i).getHP() > this.soldiers.get(max).getHP()) {
                max = i;
            }
        }
        return this.soldiers.get(max);
    }

    public void sort() {
        for (int i = 1; i < this.soldiers.size(); i++) {
            Soldier s = this.soldiers.get(i);
            int j = i - 1;

            while (j >= 0 && soldiers.get(j).getHP() < s.getHP()) {
                soldiers.set(j + 1, soldiers.get(j));
                j--;
            }
            soldiers.set(j + 1, s);
        }
    }

    public void resume() {
        System.out.println("Ejercito " + nArmy + ": " + this.reino);
        System.out.println("Total de soldados creados: " + this.soldiers.size());
        System.out.println("Espadachines: " + this.nSwords);
        System.out.println("Arqueros: " + this.nArchers);
        System.out.println("Caballeros: " + this.nKnights);
        System.out.println("Lanceros: " + this.nSpears);
        System.out.println();
    }
}
