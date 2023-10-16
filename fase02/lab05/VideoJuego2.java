public class VideoJuego2 {
    public static void main(String[] args) {
        Soldado[][] ejercito = new Soldado[10][10];
        inicializarArreglo(ejercito);
        mostrarTablero(ejercito);
    }

    public static void inicializarArreglo(Soldado[][] army) {
        int n = (int) ((Math.random() * 10) + 1);
        int[] filas = numerosRandom(n);
        int[] columnas = numerosRandom(n);
        for (int i = 0; i < n; i++) {
            int v = (int) ((Math.random() * 5) + 1);
            army[filas[i]][columnas[i]] = new Soldado();
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

    public static void mostrarTablero(Soldado[][] army) {
        String vacio = "        ";
        System.out.println(crearTecho());
        for (int i = 0; i < army.length; i++) {
            System.out.println(separadorSup());
            for (int j = 0; j < army.length; j++) {
                if (j == army.length - 1) {
                    if (army[i][j] == null) {
                        System.out.print("| " + vacio + " |");
                    } else {
                        System.out.print("| " + army[i][j].getNombre() + " |");
                    }
                } else {
                    if (army[i][j] == null) {
                        System.out.print("| " + vacio + " ");
                    } else {
                        System.out.print("| " + army[i][j].getNombre() + " ");
                    }
                }
            }
            System.out.println();
            System.out.println(separadorInf());
        }
    }

    public static String crearTecho() {
        String franky = "";
        for (int i = 0; i < 111; i++) {
            franky += "_";
        }
        return franky;
    }

    public static String separadorInf() {
        String franky = "";
        for (int i = 0; i < 111; i++) {
            if (i % 11 == 0) {
                System.out.print("|");
            } else {
                System.out.print("_");
            }
        }
        return franky;
    }

    public static String separadorSup() {
        String franky = "";
        for (int i = 0; i < 111; i++) {
            if (i % 11 == 0) {
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
        }
        return franky;
    }
}
