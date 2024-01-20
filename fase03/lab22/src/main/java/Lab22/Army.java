package Lab22;
import java.util.*;
public class Army {
    private List<Soldier> soldiers = new ArrayList<>();
    private String[] realms = new String[]{
            "Inglaterra", "Francia", "Castilla-Aragon", "Moros", "Sacro Imperio Romano Germanico"
    };
    private String kingdom;
    private int id;
    private int nArchers = 0;
    private int nKnights = 0;
    private int nSwords = 0;
    private int nSpears = 0;

    Random random = new Random();

    public Army(int id) {
        this.kingdom = realms[random.nextInt(realms.length)];
        this.id = id;
    }
    public void initialize(){
        for (int i = 0; i < random.nextInt(10) + 1; i++) {
            switch (random.nextInt(4) + 1) {
                case 1:
                    Archer a = new Archer("Archer" + i + "X" + id);
                    a.setAlias("A" + i + "X" + id);
                    nArchers++;
                    soldiers.add(a);
                    break;
                case 2:
                    Knight k = new Knight("Knight" + i + "X" + id);
                    k.setAlias("K" + i + "X" + id);
                    nKnights++;
                    soldiers.add(k);
                    break;
                case 3:
                    Spearman s = new Spearman("Spearman" + i + "X" + id);
                    s.setAlias("S" + i + "X" + id);
                    nSpears++;
                    soldiers.add(s);
                    break;
                case 4:
                    Swordsman w = new Swordsman("Swordsman" + i + "X" + id);
                    w.setAlias("W" + i + "X" + id);
                    nSwords++;
                    soldiers.add(w);
                    break;
            }
        }
    }
    public void perk() {
        for (Soldier s : soldiers) {
            s.setHP(s.getHP() + 1);
        }
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public String[] getRealms() {
        return realms;
    }

    public void setRealms(String[] realms) {
        this.realms = realms;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getnArchers() {
        return nArchers;
    }

    public void setnArchers(int nArchers) {
        this.nArchers = nArchers;
    }

    public int getnKnights() {
        return nKnights;
    }

    public void setnKnights(int nKnights) {
        this.nKnights = nKnights;
    }

    public int getnSwords() {
        return nSwords;
    }

    public void setnSwords(int nSwords) {
        this.nSwords = nSwords;
    }

    public int getnSpears() {
        return nSpears;
    }

    public void setnSpears(int nSpears) {
        this.nSpears = nSpears;
    }
}
