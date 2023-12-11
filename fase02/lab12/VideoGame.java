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
                    int o1;
                    do {
                        System.out.println("Presiona 'q' en cualquier momento para salir");

                        Soldier[][] table = new Soldier[10][10];
                        initTable(table);

                        ArrayList<Soldier> ej1 = new ArrayList<Soldier>();
                        initArmy(ej1, 1, table);
                        ArrayList<Soldier> ej2 = new ArrayList<Soldier>();
                        initArmy(ej2, 2, table);

                        showTable(table);

                        gameStart(table, ej1, ej2);

                        System.out.println("Juego terminado");
                        System.out.println("Presiona 1 para volver al menu principal");
                        System.out.println("Presiona 2 para volver a jugar");
                        System.out.println("Presiona 3 para otras opciones: ");
                        o1 = sc.nextInt();
                        int o2;
                        do {
                            System.out.println("1. Soldado con mayor vida");
                            System.out.println("2. Promedio de vida y total");
                            System.out.println("3. Datos de todos los soldados");
                            System.out.println("4. Ranking de poder");
                            System.out.println("5. Salir");
                            o2 = sc.nextInt();
                            switch (o2) {
                                case 1:
                                    System.out.println("Seleccione ejercito: ");
                                    if (sc.nextInt() == 1) {
                                        sMaxHP(ej1, 1);
                                    } else {
                                        sMaxHP(ej2, 2);
                                    }
                                    break;
                                case 2:
                                    System.out.println("Seleccione ejercito: ");
                                    if (sc.nextInt() == 1) {
                                        avgAndTotal(ej1, 1);
                                    } else {
                                        avgAndTotal(ej2, 2);
                                    }
                                    break;
                                case 3:
                                    System.out.println("Seleccione ejercito: ");
                                    if (sc.nextInt() == 1) {
                                        showArmy(ej1, 1);
                                    } else {
                                        showArmy(ej2, 2);
                                    }
                                    break;
                                case 4:
                                    System.out.println("Seleccione ejercito: ");
                                    if (sc.nextInt() == 1) {
                                        ranking(ej1, 1);
                                    } else {
                                        ranking(ej2, 2);
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } while (o2 != 5);

                    } while (o1 == 2);
                    break;
                case 2:
                    int o2;
                    /* Juego Personalizado */
                    System.out.println("Presiona 'q' en cualquier momento para salir");
                    Soldier[][] table = new Soldier[10][10];
                    initTable(table);

                    ArrayList<Soldier> ej1 = new ArrayList<Soldier>();
                    initArmy(ej1, 1, table);
                    ArrayList<Soldier> ej2 = new ArrayList<Soldier>();
                    initArmy(ej2, 2, table);

                    playArmy(ej1, table);
                    playArmy(ej2, table);

                    showTable(table);

                    do {
                        System.out.println("Presiona 'q' en cualquier momento para salir");

                        showTable(table);

                        System.out.println("Opciones: ");
                        System.out.println("1. Crear Soldado: ");
                        System.out.println("2. Borrar Soldado: ");
                        System.out.println("3. Clonar Soldado: ");
                        System.out.println("4. Modificar Soldado: ");
                        System.out.println("5. Comparar Soldados: ");
                        System.out.println("6. Intercambiar Soldados: ");
                        System.out.println("7. Buscar Soldado: ");
                        System.out.println("8. Ver ejercito: ");
                        System.out.println("9. Sumar niveles: ");
                        System.out.println("10. Jugar: ");
                        System.out.println("11. Salir");

                        o2 = sc.nextInt();
                        switch (o2) {
                            case 1:
                                System.out.println("Seleccione ejercito: ");
                                if (sc.nextInt() == 1) {
                                    if (ej1.size() > 10) {
                                        System.out.println("El ejercito no puede tener mas de 10 soldados");
                                    } else {
                                        createSoldier(ej1, 1, table);
                                        playArmy(ej1, table);
                                        showTable(table);
                                    }
                                } else {
                                    if (ej2.size() > 10) {
                                        System.out.println("El ejercito no puede tener mas de 10 soldados");
                                    } else {
                                        createSoldier(ej2, 2, table);
                                        playArmy(ej2, table);
                                        showTable(table);
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Seleccione ejercito: ");
                                if (sc.nextInt() == 1) {
                                    if (ej1.size() == 1) {
                                        System.out.println("El ejercito no puede estar vacio!");
                                    } else {
                                        deleteSoldier(table);
                                        showTable(table);
                                    }
                                } else {
                                    if (ej2.size() == 1) {
                                        System.out.println("El ejercito no puede estar vacio!");
                                    } else {
                                        deleteSoldier(table);
                                        showTable(table);
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Seleccione ejercito: ");
                                if (sc.nextInt() == 1) {
                                    if (ej1.size() > 10) {
                                        System.out.println("El ejercito no puede tener mas de 10 soldados");
                                    } else {
                                        cloneSoldier(ej1, 1, table);
                                        playArmy(ej1, table);
                                    }
                                } else {
                                    if (ej2.size() > 10) {
                                        System.out.println("El ejercito no puede tener mas de 10 soldados");
                                    } else {
                                        cloneSoldier(ej2, 2, table);
                                        playArmy(ej2, table);
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Seleccione ejercito: ");
                                if (sc.nextInt() == 1) {
                                    modifySoldier(ej1, 1, table);
                                } else {
                                    modifySoldier(ej2, 2, table);
                                }
                                break;
                            case 5:
                                System.out.println("Opciones de comparacion: ");
                                System.out.println("1. Nombre");
                                System.out.println("2. Ataque");
                                System.out.println("3. Defensa");
                                System.out.println("4. Vida");
                                System.out.println("5. Status");
                                compareSoldiers(table, sc.nextInt());
                            case 6:
                                interchange(table);
                                break;
                            case 7:
                                System.out.println("Seleccione ejercito: ");
                                if (sc.nextInt() == 1) {
                                    seeSoldier(ej1);
                                } else {
                                    seeSoldier(ej2);
                                }
                                break;
                            case 8:
                                System.out.println("Seleccione ejercito: ");
                                if (sc.nextInt() == 1) {
                                    showArmy(ej1, 1);
                                } else {
                                    showArmy(ej2, 2);
                                }
                                break;
                            case 9:
                                System.out.println("Seleccione ejercito: ");
                                if (sc.nextInt() == 1) {
                                    System.out.println("Ejercito 1:");
                                    addLevels(ej1);
                                } else {
                                    System.out.println("Ejercito 2:");
                                    addLevels(ej2);
                                }
                                break;
                            case 10:
                                gameStart(table, ej1, ej2);
                            default:
                                break;
                        }
                    } while (o2 != 11);
                    break;
                default:
                    break;
            }
        } while (option != 3);
        sc.close();
    }

    public static void initTable(Soldier[][] tb) {
        for (int i = 0; i < tb.length; i++) {
            for (int j = 0; j < tb[i].length; j++) {
                tb[i][j] = new Soldier();
            }
        }
    }

    public static void initArmy(ArrayList<Soldier> ar, int nro, Soldier[][] tb) {
        int q = (int) (Math.random() * 10) + 1;
        for (int i = 0; i < q; i++) {
            ar.add(new Soldier(i, nro));
        }
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

    public static void playArmy(ArrayList<Soldier> ar, Soldier[][] tb) {
        for (int i = 0; i < ar.size(); i++) {
            tb[ar.get(i).getRow()][ar.get(i).getColumn()] = ar.get(i);
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
            if (tb[y1][x1].getId() == id) {
                System.out.println("No puedes atacar a tu propio ejercito!");
            }
        } while (Math.abs(x1 - x) > 1 || Math.abs(y1 - y) > 1 || x1 > 9 || y1 > 9 || tb[y1][x1].getId() == id);
        if (tb[y1][x1].getId() == id) {
            System.out.println("No puedes atacar a tu propio ejercito!");
        }
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

    public static void showArmy(ArrayList<Soldier> s, int id) {
        System.out.println("Ejercito " + id + "\n");
        for (int i = 0; i < s.size(); i++) {
            showSoldier(s.get(i));
            System.out.println();
        }
    }

    public static void createSoldier(ArrayList<Soldier> a, int id, Soldier[][] tb) {
        Scanner sc = new Scanner(System.in);
        int atk, hp, def, x, y;
        System.out.println("Ingrese los datos de su soldado");
        System.out.println("Ataque: ");
        atk = sc.nextInt();
        System.out.println("Vida maxima: ");
        hp = sc.nextInt();
        System.out.println("Defensa: ");
        def = sc.nextInt();
        System.out.println("Posicion (x, y): ");
        do {
            x = sc.nextInt();
            y = sc.nextInt();
            if (tb[y][x].getStatus()) {
                System.out.println("Ya hay un soldado en ese lugar!");
            }
        } while (tb[y][x].getStatus());

        Soldier s = new Soldier(atk, def, hp, a.size() - 1, id);
        s.setPosition(y, x);
        tb[y][x].copy(s);
    }

    public static void deleteSoldier(Soldier[][] tb) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione las coordenadas del soldado a eliminar (x, y)");
        int x = sc.nextInt();
        int y = sc.nextInt();
        tb[y][x].die();
    }

    public static int searchSoldier(ArrayList<Soldier> a) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del soldado: ");
        String n = sc.next();
        for (int i = 0; i < a.size(); i++) {
            if (n.equals(a.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public static void cloneSoldier(ArrayList<Soldier> a, int id, Soldier[][] tb) {
        Scanner sc = new Scanner(System.in);
        int i = searchSoldier(a);
        int x, y;
        System.out.println("Seleccione las coordenadas a las que se desplegara la copia (x, y): ");
        do {
            x = sc.nextInt();
            y = sc.nextInt();
            if (tb[y][x].getStatus()) {
                System.out.println("Ya hay un soldado en ese lugar!");
            }
        } while (tb[y][x].getStatus());
        Soldier s = new Soldier();
        s.copy(a.get(i));
        s.setPosition(y, x);
        s.setName("Soldado" + (a.size() - 1) + "X" + id);
        a.add(s);
    }

    public static void modifySoldier(ArrayList<Soldier> a, int id, Soldier[][] tb) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del soldado a modificar: ");
        int i = searchSoldier(a);
        showSoldier(a.get(i));
        System.out.println("Que estadistica desea modificar?");
        System.out.println("1. Ataque");
        System.out.println("2. Defensa");
        System.out.println("3. Vida");
        switch (sc.nextInt()) {
            case 1:
                System.out.println("Ingrese la nueva cantidad: ");
                a.get(i).setAtk(sc.nextInt());
                break;
            case 2:
                System.out.println("Ingrese la nueva cantidad: ");
                a.get(i).setDef(sc.nextInt());
                break;
            case 3:
                System.out.println("Ingrese la nueva cantidad: ");
                a.get(i).setHP(sc.nextInt());
                break;
            default:
                break;
        }
    }

    public static void interchange(Soldier[][] tb) {
        Scanner sc = new Scanner(System.in);
        Soldier s = new Soldier();
        System.out.println("Ingrese las coordenadas del primer soldado (x, y)");
        int x, y, a, b;
        do {
            x = sc.nextInt();
            y = sc.nextInt();
            if (!tb[y][x].getStatus()) {
                System.out.println("No hay ningun soldado alli!");
            }
        } while (!tb[y][x].getStatus());
        System.out.println("Ingrese las coordenadas del segundo soldado");
        do {
            a = sc.nextInt();
            b = sc.nextInt();
            if (!tb[b][a].getStatus()) {
                System.out.println("No hay ningun soldado alli!");
            }
        } while (!tb[b][a].getStatus());
        s.copy(tb[y][x]);
        tb[y][x].copy(tb[b][a]);
        tb[b][a].copy(s);
    }

    public static void seeSoldier(ArrayList<Soldier> a) {
        int i = searchSoldier(a);
        showSoldier(a.get(i));
    }

    public static void addLevels(ArrayList<Soldier> a) {
        Soldier s = new Soldier();
        for (int i = 0; i < a.size(); i++) {
            s.add(a.get(i));
        }
        System.out.println("El nivel total de vida es: " + s.getMaxHP());
        System.out.println("El nivel total de defensa es: " + s.getDefense());
        System.out.println("El nivel total de ataque es: " + s.getAtk());
    }

    public static void compareSoldiers(Soldier[][] tb, int id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese las coordenadas del 1er soldado a comparar");
        int x, y, a, b;
        do {
            x = sc.nextInt();
            y = sc.nextInt();
            if (!tb[y][x].getStatus()) {
                System.out.println("No hay ningun soldado alli!");
            }
        } while (!tb[y][x].getStatus());
        Soldier s1 = tb[y][x];
        System.out.println("Ingrese las coordenadas del 2do soldado a comparar");
        do {
            a = sc.nextInt();
            b = sc.nextInt();
            if (!tb[b][a].getStatus()) {
                System.out.println("No hay ningun soldado alli!");
            }
        } while (!tb[b][a].getStatus());
        Soldier s2 = tb[b][a];
        switch (id) {
            case 1:
                if (s1.getName().compareTo(s2.getName()) != 0) {
                    System.out.println("No son iguales");
                }
                break;
            case 2:
                if (s1.getAtk() != s2.getAtk()) {
                    System.out.println("No son iguales");
                }
                break;
            case 3:
                if (s2.getDefense() != s2.getDefense()) {
                    System.out.println("No son iguales");
                }
                break;
            case 4:
                if (s1.getMaxHP() != s2.getMaxHP()) {
                    System.out.println("No son iguales");
                }
                break;
            case 5:
                if (s1.getStatus() != s2.getStatus()) {
                    System.out.println("No son iguales");
                }
            default:
                break;
        }
    }

    public static void sMaxHP(ArrayList<Soldier> s, int id) {
        int max = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).getMaxHP() > s.get(max).getMaxHP()) {
                max = i;
            }
        }
        System.out.println("El soldado con mayor vida del ejercito " + id + " es:");
        showSoldier(s.get(max));
    }

    public static void avgAndTotal(ArrayList<Soldier> s, int id) {
        Soldier a = new Soldier();
        for (int i = 0; i < s.size(); i++) {
            a.add(s.get(i));
        }
        double n = a.getMaxHP() / s.size();
        System.out.println("El total de vida del ejercito " + id + " es: " + a.getMaxHP());
        System.out.println("La vida promedio del ejercito " + id + " es: " + n);
    }

    public static void bubbleSort(ArrayList<Soldier> a) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size() - 1; j++) {
                if (a.get(j).getMaxHP() < a.get(j + 1).getMaxHP()) {
                    intercambiar(a, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(ArrayList<Soldier> a) {
        for (int i = 0; i < a.size(); i++) {
            Soldier s = a.get(i);
            int j = i;
            for (j = 1; 0 < j && a.get(j - 1).getMaxHP() < s.getMaxHP(); j--) {
                a.set(j, a.get(j - 1));
            }
            a.set(j, s);
        }
    }

    public static void ranking(ArrayList<Soldier> a, int id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que algoritmo de ordenamiento le gustaria usar?");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        switch (sc.nextInt()) {
            case 1:
                bubbleSort(a);
                showArmy(a, id);
                break;
            case 2:
                insertionSort(a);
                showArmy(a, id);
                break;
            default:
                break;
        }
    }

    public static void intercambiar(ArrayList<Soldier> a, int i, int j) {
        Soldier temp;
        temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
}
