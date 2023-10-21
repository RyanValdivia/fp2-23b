import java.util.ArrayList;

public class VideoJuego4 {
    public static void main(String[] args) {
        Soldado[][] tablero = new Soldado[10][10];
        int ej1 = (int) (Math.random() * 10 + 1);
        int ej2 = (int) (Math.random() * 10 + 1);
        int[] filas1 = numerosRandom(ej1);
        int[] columnas1 = numerosRandom(ej1);
        int[] filas2;
        int[] columnas2;
        do {
            filas2 = numerosRandom(ej2);
            columnas2 = numerosRandom(ej2);
        } while (!diffCoordenadas(filas1, filas2, columnas1, columnas2));
        Soldado[] ejercito1 = crearArreglo(filas1, columnas1, 1);
        Soldado[] ejercito2 = crearArreglo(filas2, columnas2, 2);
        inicializarEjercito(tablero);
        desplegarEjercito(tablero, ejercito1);
        desplegarEjercito(tablero, ejercito2);
        mostrarTablero(tablero);
        soldadoMayorVida(ejercito1, 1);
        soldadoMayorVida(ejercito2, 2);
    }

    public static int[] numerosRandom(int q) {
        int[] nums = new int[q];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length;
        }
        for (int i = 0; i < q; i++) {
            int n;
            do {
                n = (int) (Math.random() * 10);
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

    public static boolean diffCoordenadas(int[] filas1, int[] filas2, int[] columnas1, int[] columnas2) {
        if (filas1.length > filas2.length) {
            for (int i = 0; i < filas2.length; i++) {
                if (filas1[i] == filas2[i] && columnas1[i] == columnas2[i]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < filas1.length; i++) {
                if (filas1[i] == filas2[i] && columnas1[i] == columnas2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Soldado[] crearArreglo(int[] x, int[] y, int nro) {
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

    public static void desplegarEjercito(Soldado[][] table, Soldado[] ej) {
        for (int i = 0; i < ej.length; i++) {
            table[ej[i].getFila()][ej[i].getColumna()] = ej[i];
        }
    }

    public static void inicializarEjercito(Soldado[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = new Soldado();
                table[i][j].setNombre("          ");
                table[i][j].setBandera("          ");
            }
        }
    }

    public static void mostrarTablero(Soldado[][] tb) {
        String vacio = "          ";
        System.out.println(crearTecho());
        for (int i = 0; i < tb.length; i++) {
            System.out.println(separadorSup());
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

    public static void soldadoMayorVida(Soldado[] army, int ej) {
        int max = 0;
        for (int i = 0; i < army.length; i++) {
            if (army[i].getVida() > army[max].getVida()) {
                max = i;
            }
        }
        System.out.println("El soldado con mayor vida del ejercito " + ej + " es: ");
        mostrarSoldado(army, max);
        System.out.println();
    }

    public static void mostrarSoldado(Soldado[] army, int i) {
        String columna;
        System.out.println("Nombre: " + army[i].getNombre());
        System.out.println("Vida: " + army[i].getVida() + " HP");
        switch (army[i].getColumna() + 1) {
            case 1:
                columna = "A";
                break;
            case 2:
                columna = "B";
                break;
            case 3:
                columna = "C";
                break;
            case 4:
                columna = "D";
                break;
            case 5:
                columna = "E";
                break;
            case 6:
                columna = "F";
                break;
            case 7:
                columna = "G";
                break;
            case 8:
                columna = "H";
                break;
            case 9:
                columna = "I";
                break;
            case 10:
                columna = "J";
                break;
            default:
                columna = "K";
                break;
        }
        System.out.println("Posición: " + (army[i].getFila() + 1) + "-" + columna);
    }
}
