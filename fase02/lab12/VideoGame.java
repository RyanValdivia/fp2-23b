import java.util.*;

public class VideoGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("Bienvenido! Que quieres jugar?");
            System.out.println("1. Juego rapido");
            System.out.println("2. Juego personalizado");
            System.out.println("3. Salir");
            option = sc.nextInt();
            if (option == 3) {
                break;
            }
            switch (option) {
                case 1:
                    /* Juego normal */
                    do {
                        System.out.println("Presiona 'q' en cualquier momento para salir");

                        Soldier[][] table = new Soldier[10][10];
                        initTable(table);

                        ArrayList<Soldier> ej1 = new ArrayList<Soldier>();
                        initArmy(ej1, 1);
                        ArrayList<Soldier> ej2 = new ArrayList<Soldier>();
                        initArmy(ej2, 2);

                        playArmy(ej1, table);
                        playArmy(ej2, table);

                        showTable(table);

                        gameStart(table, ej1, ej2);

                        System.out.println("Juego terminado");
                        System.out.println("Presiona 1 para volver al menu principal");
                        System.out.println("Presiona 2 para volver a jugar");
                    } while (sc.nextInt() == 2);
                    break;
                case 2:
                    /* Juego Personalizado */
                    System.out.println("Presiona 'q' en cualquier momento para salir");

                    Soldier[][] table = new Soldier[10][10];
                    initTable(table);

                    ArrayList<Soldier> ej1 = new ArrayList<Soldier>();
                    initArmy(ej1, 1);
                    ArrayList<Soldier> ej2 = new ArrayList<Soldier>();
                    initArmy(ej2, 2);
                    break;
                default:
                    break;
            }
        } while (option != 3);

    }

    public static void initTable(Soldier[][] tb) {
        for (int i = 0; i < tb.length; i++) {
            for (int j = 0; j < tb[i].length; j++) {
                tb[i][j] = new Soldier();
            }
        }
    }

    public static void initArmy(ArrayList<Soldier> ar, int nro) {
        int q = (int) (Math.random() * 3) + 1;
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

    public static void gameStart(Soldier[][] tb, ArrayList<Soldier> a1, ArrayList<Soldier> a2) {
        Scanner sc = new Scanner(System.in);
        int q1[] = new int[] { a1.size() };
        int q2[] = new int[] { a2.size() };
        while (q1[0] != 0 || q2[0] != 0) {
            System.out.println("Presiona cualquier boton para continuar: ");
            if (sc.next().equals("q")) {
                break;
            }
            turn(tb, a1, q1, 1);
            if (q1[0] == 0) {
                System.out.println("El ejercito 2 gano!");
                break;
            } else if (q2[0] == 0) {
                System.out.println("El ejercito 1 gano!");
                break;
            }
            turn(tb, a2, q2, 2);
            System.out.println("Presiona cualquier boton para continuar: ");
            if (sc.next().equals("q")) {
                break;
            }
            if (q1[0] == 0) {
                System.out.println("El ejercito 2 gano!");
                break;
            } else if (q2[0] == 0) {
                System.out.println("El ejercito 1 gano!");
                break;
            }
        }
    }

    public static void turn(Soldier[][] tb, ArrayList<Soldier> a, int[] c, int id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Turno del ejercito " + id + " : ");
        System.out.println("Seleccione las coordenadas del soldado que movera (x, y): ");
        int x, y;
        do {
            x = sc.nextInt();
            y = sc.nextInt();
            if (tb[y][x].getId() != id) {
                System.out.println("Elige un soldado de tu propio ejercito!");
            }
        } while (tb[y][x].getId() != id);
        System.out.println("Soldado a mover: ");
        showSoldier(tb[y][x]);
        System.out.println("Seleccione las coordenadas hacia donde se movera su soldado: ");
        int x1, y1;
        do {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            if (Math.abs(x1 - x) > 1 || Math.abs(y1 - y) > 1) {
                System.out.println("Solo te puedes mover una casilla!");
            }
            if (x1 > 9 || y1 > 9) {
                System.out.println("Ingresa coordenadas dentro del tablero!");
            }
        } while (Math.abs(x1 - x) > 1 || Math.abs(y1 - y) > 1 || x1 > 9 || y1 > 9);
        if (tb[y1][x1].getStatus()) {
            tb[y1][x1].copy(battle(tb[y][x], tb[y1][x1]));
            tb[y1][x1].curar(1);
            tb[y][x].die();
            c[0]--;

        } else {
            tb[y1][x1].copy(tb[y][x]);
            tb[y][x].die();
        }
        showTable(tb);
    }

    public static Soldier battle(Soldier s1, Soldier s2) {
        int max = s1.getcHP() + s2.getcHP();
        double r = Math.random();
        if (s1.getcHP() < s2.getcHP()) {
            if (r < s1.getcHP() / max) {
                /* Gana s1 */
                System.out.println("Gana " + s1.getName());
                return s1;

            } else {
                /* Gana s2 */
                System.out.println("Gana " + s2.getName());
                return s2;
            }
        } else {
            if (r < s2.getcHP() / max) {
                /* Gana s2 */
                System.out.println("Gana " + s2.getName());
                return s2;
            } else {
                /* Gana s1 */
                System.out.println("Gana " + s1.getName());
                return s1;
            }
        }
    }

    public static void showSoldier(Soldier s) {
        System.out.println("Nombre: " + s.getName());
        System.out.println("Vida: " + s.getcHP() + " / " + s.getMaxHP() + " HP");
        System.out.println("Defensa: " + s.getDefense() + " DP");
        System.out.println("Posicion (x, y): " + s.getColumn() + " - " + s.getRow() + "\n");
    }
}
