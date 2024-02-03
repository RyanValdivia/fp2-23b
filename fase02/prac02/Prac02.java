import java.util.Scanner;

public class Prac02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Soldado[] ejercito1 = new Soldado[n];
        Soldado[] ejercito2 = new Soldado[n];

        Soldado[][] tablero1 = new Soldado[n][n];
        Soldado[][] tablero2 = new Soldado[n][n];

        Soldado[][] tableroF = new Soldado[n][n];

        inicializarTablero(tablero1);
        inicializarTablero(tablero2);
        inicializarTablero(tableroF);

        ejercito1 = inicializarEjercito(n, 1);
        ejercito2 = inicializarEjercito(n, 2);

        desplegarEjercito(tablero1, ejercito1);
        desplegarEjercito(tablero2, ejercito2);

        mostrarTablero(tablero1);
        mostrarTablero(tablero2);
        batallaFinal(tableroF, ejercito1, ejercito2);
        mostrarTablero(tableroF);

    }

    public static void batallaFinal(Soldado[][] fin, Soldado[] ej1, Soldado[] ej2) {
        for (int i = 0; i < fin.length; i++) {
            for (int j = 0; j < fin[i].length; j++) {
                int idx1 = haySoldado(ej1, i, j);
                int idx2 = haySoldado(ej2, i, j);
                if (idx1 != -1 && idx2 != -1) {
                    if (ej1[idx1].getVida() >= ej2[idx2].getVida()) {
                        fin[i][j] = ej1[idx1];
                        fin[i][j].setVida(ej1[idx1].getVida() - ej2[idx2].getVida());
                    } else if (ej2[idx2].getVida() > ej1[idx1].getVida()) {
                        fin[i][j] = ej2[idx2];
                        fin[i][j].setVida(ej2[idx2].getVida() - ej1[idx1].getVida());
                    }
                } else if (idx1 != -1) {
                    fin[i][j] = ej1[idx1];
                } else if (idx2 != -1) {
                    fin[i][j] = ej2[idx2];
                }
            }
        }
    }

    public static int haySoldado(Soldado[] e, int i, int j) {
        for (int k = 0; k < e.length; k++) {
            if (i == e[k].getFila() && j == e[k].getColumna()) {
                return k;
            }
        }
        return -1;
    }

    public static void inicializarTablero(Soldado[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = new Soldado();
                table[i][j].setNombre("          ");
                table[i][j].setBandera("          ");
            }
        }
    }

    public static void desplegarEjercito(Soldado[][] table, Soldado[] ej) {
        for (int i = 0; i < ej.length; i++) {
            table[ej[i].getFila()][ej[i].getColumna()] = ej[i];
        }
    }

    public static int[] numerosRandom(int q) {
        int[] nums = new int[q];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length;
        }
        for (int i = 0; i < q; i++) {
            int n;
            do {
                n = (int) (Math.random() * q);
            } while (estaEnArreglo(nums, n, i));
            nums[i] = n;
        }
        return nums;
    }

    public static boolean estaEnArreglo(int[] arreglo, int num, int indice) {
        for (int i = 0; i < indice; i++) {
            if (arreglo[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static Soldado[] inicializarEjercito(int q, int nro) {
        int[] x = numerosRandom(q);
        int[] y = numerosRandom(q);
        int len = x.length;
        Soldado[] army = new Soldado[len];
        for (int i = 0; i < len; i++) {
            int v = (int) (Math.random() * 5 + 1);
            army[i] = new Soldado();
            army[i].setNombre("Soldado" + i + "X" + nro);
            army[i].setVida(v);
            army[i].setFila(x[i]);
            army[i].setColumna(y[i]);
            if (nro == 1) {
                army[i].setBandera("##########");
            } else {
                army[i].setBandera("**********");
            }
        }
        return army;
    }

    public static void mostrarTablero(Soldado[][] tb) {
        String vacio = "          ";
        int n = tb.length;
        System.out.println(crearTecho(n));
        for (int i = 0; i < tb.length; i++) {
            System.out.println(separadorSup(n));
            for (int j = 0; j < tb[i].length; j++) {
                if (j == tb[i].length - 1) {
                    System.out.print("| " + tb[i][j].getBandera() + " |\n");
                } else {
                    System.out.print("| " + tb[i][j].getBandera() + " ");
                }
            }
            for (int j = 0; j < tb[i].length; j++) {
                if (j == tb[i].length - 1) {
                    System.out.print("| " + tb[i][j].getNombre() + " |\n");
                } else {
                    System.out.print("| " + tb[i][j].getNombre() + " ");
                }
            }
            for (int j = 0; j < tb[i].length; j++) {
                if (tb[i][j].getVida() != 0) {
                    if (j == tb[i].length - 1) {
                        System.out.print("|    " + tb[i][j].getVida() + " HP" + "    |\n");
                    } else {
                        System.out.print("|    " + tb[i][j].getVida() + " HP" + "    ");
                    }
                } else {
                    if (j == tb[i].length - 1) {
                        System.out.print("| " + vacio + " |\n");
                    } else {
                        System.out.print("| " + vacio + " ");
                    }
                }
            }
            System.out.println(separadorInf(n));
        }
        System.out.println();
    }

    public static String crearTecho(int n) {
        String franky = "";
        int q = (n * 12) + n + 1;
        for (int i = 0; i < q; i++) {
            franky += "_";
        }
        return franky;
    }

    public static String separadorInf(int n) {
        String franky = "";
        int q = (n * 12) + n + 1;
        for (int i = 0; i < q; i++) {
            if (i % 13 == 0) {
                System.out.print("|");
            } else {
                System.out.print("_");
            }
        }
        return franky;
    }

    public static String separadorSup(int n) {
        String franky = "";
        int q = (n * 12) + n + 1;
        for (int i = 0; i < q; i++) {
            if (i % 13 == 0) {
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
        }
        return franky;
    }
}
