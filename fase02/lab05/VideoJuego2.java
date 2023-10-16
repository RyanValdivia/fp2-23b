public class VideoJuego2 {
    public static void main(String[] args) {
        Soldado[][] ejercito = new Soldado[10][10];
    }

    public static void inicializarArreglo(Soldado[][] army) {
        int n = (int) ((Math.random() * 10) + 1);
        int[] filas = numerosRandom(n);
        int[] columnas = numerosRandom(n);
        for (int i = 0; i < n; i++) {
            int v = (int) ((Math.random() * 5) + 1);
            army[filas[i]][columnas[i]].setNombre("Soldado" + i);
            army[filas[i]][columnas[i]].setVida(v);
            army[filas[i]][columnas[i]].setFila(filas[i]);
            army[filas[i]][columnas[i]].setColumna(columnas[i]);
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

}
