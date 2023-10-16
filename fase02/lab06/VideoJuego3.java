import java.util.*;

public class VideoJuego3 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>(10);
        int ej1 = (int) ((Math.random() * 10) + 1);
        int ej2 = (int) ((Math.random() * 10) + 1);
        int[] filas1 = numerosRandom(ej1);
        int[] columnas1 = numerosRandom(ej1);
        int[] filas2;
        int[] columnas2;
        do {
            filas2 = numerosRandom(ej2);
            columnas2 = numerosRandom(ej2);
        } while (!diffCoordenadas(filas1, filas2, columnas1, columnas2));
        inicializarLista(tablero);
        desplegarEjercito(tablero, filas1, columnas1, 1);
        desplegarEjercito(tablero, filas2, columnas2, 2);
        mostrarTablero(tablero);

    }

    public static void mostrarSoldados(int[] filas, int[] columnas) {
        for (int i = 0; i < filas.length; i++) {
            System.out.println(filas[i] + ", " + columnas[i]);
        }
    }

    public static void inicializarLista(ArrayList<ArrayList<Soldado>> army) {
        for (int i = 0; i < 10; i++) {
            army.add(new ArrayList<>());
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                army.get(i).add(new Soldado());
                army.get(i).get(j).setNombre("          ");
            }
        }

    }

    public static void desplegarEjercito(ArrayList<ArrayList<Soldado>> army, int[] filas, int[] columnas, int ej) {
        for (int i = 0; i < filas.length; i++) {
            int v = (int) ((Math.random() * 5) + 1);
            army.get(filas[i]).get(columnas[i]).setNombre("Soldado" + i + "X" + ej);
            army.get(filas[i]).get(columnas[i]).setVida(v);
            army.get(filas[i]).get(columnas[i]).setFila(filas[i] + 1);
            army.get(filas[i]).get(columnas[i]).setColumna(columnas[i] + 1);
        }
    }

    public static void mostrarTablero(ArrayList<ArrayList<Soldado>> army) {
        System.out.println(crearTecho());
        for (int i = 0; i < 10; i++) {
            System.out.println(separadorSup());
            for (int j = 0; j < 10; j++) {
                if (j == 10 - 1) {
                    System.out.print("| " + army.get(i).get(j).getNombre() + " |");
                } else {
                    System.out.print("| " + army.get(i).get(j).getNombre() + " ");
                }
            }
            System.out.println();
            System.out.println(separadorInf());
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

    public static String crearTecho() {
        String franky = "";
        for (int i = 0; i < 121; i++) {
            franky += "_";
        }
        return franky;
    }

    public static String separadorInf() {
        String franky = "";
        for (int i = 0; i < 121; i++) {
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
        for (int i = 0; i < 121; i++) {
            if (i % 13 == 0) {
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
        }
        return franky;
    }
}
