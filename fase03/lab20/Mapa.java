import java.util.*;

public class Mapa {
    private Soldier[][] table = new Soldier[10][10];
    private String[] territories = new String[] {
            "Bosque", "Campo Abierto", "Montaña", "Desierto", "Playa" };
    private String territory;
    Random random = new Random();

    public Mapa() {
        this.territory = territories[random.nextInt(territories.length)];
    }

    public void initialize() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = new Soldier();
            }
        }
    }

    public void initialize(Army a) {
        for (Soldier s : a.getSoldiers()) {
            int x, y;
            do {
                x = random.nextInt(10);
                y = random.nextInt(10);
            } while (table[y][x].getStatus());
            s.setRow(x);
            s.setCol(y);
            table[y][x] = s;
        }
        if (search(this.territory, this.territories) == search(a.getReino(), a.getReinos())) {
            a.perk();
        }
    }

    public int search(String a, String[] strs) {
        int i = 0;
        for (String s : strs) {
            if (s.equals(a)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void show() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(separadorSup());
            for (int j = 0; j < table[i].length; j++) {
                System.out.print("| " + table[i][j].getFlag() + " |");
                if (j == table[i].length - 1) {
                    System.out.println();
                }
            }
            for (int j = 0; j < table[i].length; j++) {
                System.out.print("|     " + table[i][j].getAlias() + "     |");
                if (j == table[i].length - 1) {
                    System.out.println();
                }
            }
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].getStatus()) {
                    if (table[i][j].getHP() < 10) {
                        System.out.print("|    " + table[i][j].getcHP() + "/" + table[i][j].getHP() + " HP" + "    |");
                    } else {
                        System.out.print("|   " + table[i][j].getcHP() + "/" + table[i][j].getHP() + " HP" + "   |");
                    }
                } else {
                    System.out.print("|              |");
                }
                if (j == table[i].length - 1) {
                    System.out.println();
                }
            }
            System.out.println(separadorInf());
        }
        System.out.println();
    }

    public String separadorSup() {
        String franky = "";
        for (int i = 0; i < 10; i++) {
            franky += "________________";
        }
        franky += "\n";
        for (int i = 0; i < 10; i++) {
            franky += "|              |";
        }
        return franky;
    }

    public String separadorInf() {
        String franky = "";
        for (int i = 0; i < 10; i++) {
            franky += "|              |";
        }
        franky += "\n";
        for (int i = 0; i < 10; i++) {
            franky += "|______________|";
        }
        return franky;
    }

    public void resume(Army a1, Army a2) {
        double h1 = 1.0 * a1.totalHP() / (a1.totalHP() + a2.totalHP());
        double h2 = 1.0 * a2.totalHP() / (a1.totalHP() + a2.totalHP());
        String ganador;

        double ans = random.nextDouble();

        if (h1 > h2) {
            if (ans < h2) {
                ganador = "Ejercito " + a2.getnArmy() + ": " + a2.getReino();
            } else {
                ganador = "Ejercito " + a1.getnArmy() + ": " + a1.getReino();
            }
        } else {
            if (ans < h1) {
                ganador = "Ejercito " + a1.getnArmy() + ": " + a1.getReino();
            } else {
                ganador = "Ejercito " + a2.getnArmy() + ": " + a2.getReino();
            }
        }

        h1 = Math.round(h1 * 100.0);
        h2 = Math.round(h2 * 100.0);

        ans = Math.round(ans * 100.0);

        System.out.println("Ejercito " + a1.getnArmy() + ": " + a1.getReino() + ": " + a1.totalHP());
        System.out.println(h1 + "%" + " de probabilidades de victoria");
        System.out.println("Ejercito " + a2.getnArmy() + ": " + a2.getReino() + ": " + a2.totalHP());
        System.out.println(h2 + "%" + " de probabilidades de victoria");

        System.out.println("El ganador es: " + ganador);
        System.out.println(
                "Ya que al generar un valor los porcentajes de probabilidad de victoria basada en los niveles\nde vida de sus soldados y aplicando un experimento aleatorio salió vencedor.");
        System.out.println("(Aleatorio generado: " + ans + ")");
    }
}
