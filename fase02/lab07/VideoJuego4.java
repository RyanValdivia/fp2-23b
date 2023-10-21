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
        Soldado[] ejercito1 = crearArreglo(filas1, columnas1, ej1);
        Soldado[] ejercito2 = crearArreglo(filas2, columnas2, ej2);
        desplegarEjercito(tablero, ejercito1);
        desplegarEjercito(tablero, ejercito2);
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
        }
        return army;
    }

    public static void desplegarEjercito(Soldado[][] table, Soldado[] ej) {
        int q = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == ej[q].getFila() && j == ej[q].getColumna()) {
                    table[i][j] = ej[q];
                    q++;
                }
            }
        }
    }
}
