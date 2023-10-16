import java.util.*;

public class VideoJuego2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Soldado[][] ejercito = new Soldado[10][10];
        int n = (int) ((Math.random() * 10) + 1);
        int[] filas = numerosRandom(n);
        int[] columnas = numerosRandom(n);
        inicializarArreglo(ejercito, filas, columnas);
        mostrarTablero(ejercito);
        System.out.println();
        soldadoMayorVida(ejercito, filas, columnas);
        System.out.println("El nivel de vida de todo el ejercito es: " + promedioYTotal(ejercito, filas, columnas)[0]);
        System.out
                .println("El nivel de vida promedio del ejercito es: " + promedioYTotal(ejercito, filas, columnas)[1]);
        System.out.println();
        mostrarEjercito(ejercito, filas, columnas);
        Soldado[] army = crearArreglo(ejercito, filas, columnas);
        System.out.println("Bajo que criterio de ordenamiento le gustaría ordenar el arreglo?");
        System.out.println("1. Burbuja");
        System.out.println("2. Insercion");
        switch (sc.nextInt()) {
            case 1:
                ordenamientoBurbuja(army);
                break;
            case 2:
                ordenamientoInsercion(army);
                break;
            default:
        }
        System.out.println();
        mostrar(army);
    }

    public static void inicializarArreglo(Soldado[][] army, int[] filas, int[] columnas) {
        for (int i = 0; i < filas.length; i++) {
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

    public static void soldadoMayorVida(Soldado[][] army, int[] filas, int[] columnas) {
        int max = 0;
        for (int i = 0; i < filas.length; i++) {
            if (army[filas[i]][columnas[i]].getVida() > army[filas[max]][columnas[max]].getVida()) {
                max = i;
            }
        }
        System.out.println("El soldado con mayor vida es: ");
        mostrarSoldado(army, filas[max], columnas[max]);
    }

    public static void mostrarSoldado(Soldado[][] army, int i, int j) {
        String fila;
        System.out.println("Nombre: " + army[i][j].getNombre());
        System.out.println("Vida: " + army[i][j].getVida() + " HP");
        switch (army[i][j].getColumna() + 1) {
            case 1:
                fila = "A";
                break;
            case 2:
                fila = "B";
                break;
            case 3:
                fila = "C";
                break;
            case 4:
                fila = "D";
                break;
            case 5:
                fila = "E";
                break;
            case 6:
                fila = "F";
                break;
            case 7:
                fila = "G";
                break;
            case 8:
                fila = "H";
                break;
            case 9:
                fila = "I";
                break;
            case 10:
                fila = "J";
                break;
            default:
                fila = "H";
                break;
        }
        System.out.println("Posición: " + (army[i][j].getFila() + 1) + "-" + fila);
    }

    public static double[] promedioYTotal(Soldado[][] army, int[] filas, int[] columnas) {
        int total = 0;
        for (int i = 0; i < filas.length; i++) {
            total += army[filas[i]][columnas[i]].getVida();
        }
        double[] rpta = new double[] { total, (total * 1.0 / filas.length) };
        return rpta;
    }

    public static void mostrarEjercito(Soldado[][] army, int[] filas, int[] columnas) {
        System.out.println("Ejercito");
        for (int i = 0; i < filas.length; i++) {
            mostrarSoldado(army, filas[i], columnas[i]);
            System.out.println();
        }
    }

    public static Soldado[] crearArreglo(Soldado[][] army, int[] filas, int[] columnas) {
        Soldado[] nuevo = new Soldado[filas.length];
        for (int i = 0; i < nuevo.length; i++) {
            nuevo[i] = army[filas[i]][columnas[i]];
        }
        return nuevo;
    }

    public static void ordenamientoBurbuja(Soldado[] army) {
        for (int i = 0; i < army.length; i++) {
            for (int j = 0; j < army.length - 1; j++) {
                if (army[j].getVida() > army[j + 1].getVida()) {
                    intercambiar(army, j, j + 1);
                }
            }
        }
    }

    public static void ordenamientoInsercion(Soldado[] army) {
        for (int i = 1; i < army.length; i++) {
            Soldado valor = army[i];
            int j = i;
            for (j = i; 0 < j && army[j - 1].getVida() > valor.getVida(); j--) {
                army[j] = army[j - 1];
            }
            army[j] = valor;
        }
    }

    public static void mostrar(Soldado[] army) {
        for (int i = 0; i < army.length; i++) {
            String fila;
            System.out.println("Nombre: " + army[i].getNombre());
            System.out.println("Vida: " + army[i].getVida() + " HP");
            switch (army[i].getColumna() + 1) {
                case 1:
                    fila = "A";
                    break;
                case 2:
                    fila = "B";
                    break;
                case 3:
                    fila = "C";
                    break;
                case 4:
                    fila = "D";
                    break;
                case 5:
                    fila = "E";
                    break;
                case 6:
                    fila = "F";
                    break;
                case 7:
                    fila = "G";
                    break;
                case 8:
                    fila = "H";
                    break;
                case 9:
                    fila = "I";
                    break;
                case 10:
                    fila = "J";
                    break;
                default:
                    fila = "H";
                    break;
            }
            System.out.println("Posición: " + (army[i].getFila() + 1) + "-" + fila);
        }
    }

    public static void intercambiar(Soldado[] flota, int i, int j) {
        Soldado temp;
        temp = flota[i];
        flota[i] = flota[j];
        flota[j] = temp;
    }
}
