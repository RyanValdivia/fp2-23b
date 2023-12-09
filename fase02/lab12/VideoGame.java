import java.util.*;

public class VideoGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido! Que quieres jugar?");
        System.out.println("1. Juego rapido");
        System.out.println("2. Juego personalizado");

        /* Juego normal */

        Soldier[][] table = new Soldier[10][10];
        initTable(table);

        ArrayList<Soldier> ej1 = new ArrayList<Soldier>();
        initArmy(ej1, 1);
        ArrayList<Soldier> ej2 = new ArrayList<Soldier>();
        initArmy(ej2, 2);

        playArmy(ej1, table);
        playArmy(ej2, table);

        showTable(table);

    }

    public static void initTable(Soldier[][] tb) {
        for (int i = 0; i < tb.length; i++) {
            for (int j = 0; j < tb[i].length; j++) {
                tb[i][j] = new Soldier();
            }
        }
    }

    public static void initArmy(ArrayList<Soldier> ar, int nro) {
        int q = (int) (Math.random() * 10) + 1;
        for (int i = 0; i < q; i++) {
            ar.add(new Soldier(i, nro));
        }
    }

    public static void playArmy(ArrayList<Soldier> ar, Soldier[][] tb) {
        for (int i = 0; i < ar.size(); i++) {
            int x;
            int y;
            do {
                y = (int) (Math.random() * 10);
                x = (int) (Math.random() * 10);
            } while (tb[y][x].getStatus());
            ar.get(i).setPosition(y, x);
            tb[y][x] = ar.get(i);
        }
    }

    public static void showTable(Soldier[][] tb) {
        String vacio = "          ";
        System.out.println(crearTecho());
        for (int i = 0; i < tb.length; i++) {
            System.out.println(separadorSup());
            for (int j = 0; j < tb[i].length; j++) {
                if (j == tb[i].length - 1) {
                    System.out.print("| " + tb[i][j].getFlag() + " |\n");
                } else {
                    System.out.print("| " + tb[i][j].getFlag() + " ");
                }
            }
            for (int j = 0; j < tb[i].length; j++) {
                if (j == tb[i].length - 1) {
                    System.out.print("| " + tb[i][j].getName() + " |\n");
                } else {
                    System.out.print("| " + tb[i][j].getName() + " ");
                }
            }
            for (int j = 0; j < tb[i].length; j++) {
                if (tb[i][j].getMaxHP() != 0) {
                    if (j == tb[i].length - 1) {
                        System.out
                                .print("|   " + tb[i][j].getcHP() + "/" + tb[i][j].getMaxHP() + " HP" + "   |\n");
                    } else {
                        System.out.print("|   " + tb[i][j].getcHP() + "/" + tb[i][j].getMaxHP() + " HP" + "   ");
                    }
                } else {
                    if (j == tb[i].length - 1) {
                        System.out.print("| " + vacio + " |\n");
                    } else {
                        System.out.print("| " + vacio + " ");
                    }
                }
            }
            for (int j = 0; j < tb[i].length; j++) {
                if (tb[i][j].getDefense() != 0) {
                    if (j == tb[i].length - 1) {
                        System.out.print("|    " + tb[i][j].getDefense() + " DP" + "    |\n");
                    } else {
                        System.out.print("|    " + tb[i][j].getDefense() + " DP" + "    ");
                    }
                } else {
                    if (j == tb[i].length - 1) {
                        System.out.print("| " + vacio + " |\n");
                    } else {
                        System.out.print("| " + vacio + " ");
                    }
                }
            }
            System.out.println(separadorInf());
        }
        System.out.println();
    }

    public static String crearTecho() {
        String franky = "";
        for (int i = 0; i < 131; i++) {
            franky += "_";
        }
        return franky;
    }

    public static String separadorInf() {
        String franky = "";
        for (int i = 0; i < 131; i++) {
            if (i % 13 == 0) {
                System.out.print("|");
            } else {
                System.out.print("_");
            }
        }
        return franky;
    }

    public static String separadorSup() {
        String franky = "";
        for (int i = 0; i < 131; i++) {
            if (i % 13 == 0) {
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
        }
        return franky;
    }
}
