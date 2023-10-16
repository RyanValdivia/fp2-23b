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
        } while (!arregloDiff(filas1, filas2));
        do {
            columnas2 = numerosRandom(ej2);
        } while (!arregloDiff(columnas1, columnas2));
        inicializarLista(tablero, filas1, columnas1, 1);
        inicializarLista(tablero, filas2, columnas2, 2);

    }

    public static void inicializarLista(ArrayList<ArrayList<Soldado>> army, int[] filas, int[] columnas, int ej) {
        int v = (int) ((Math.random() * 5) + 1);
        for (int i = 0; i < 10; i++) {
            army.add(new ArrayList<>(10));
        }
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                army.get(i).add(new Soldado());
            }
        }
        int contador = 0;
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                if (i == filas[i] && j == columnas[i]) {
                    army.get(i).get(j).setNombre("Soldado" + contador + "X" + ej);
                    army.get(i).get(j).setVida(v);
                    army.get(i).get(j).setFila(i);
                    army.get(i).get(j).setColumna(j);
                } else {
                    army.get(i).get(j).setNombre("          ");
                }
            }
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

    public static boolean arregloDiff(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            for (int i = 0; i < arr2.length; i++) {
                if (arr2[i] == arr1[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
