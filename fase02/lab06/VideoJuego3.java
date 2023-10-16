import java.util.*;

public class VideoJuego3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        Soldado[] ejercito1 = convertirArray(crearLista(tablero, filas1, columnas1));
        Soldado[] ejercito2 = convertirArray(crearLista(tablero, filas2, columnas2));
        System.out.println();
        soldadoMayorVida(ejercito1, 1);
        soldadoMayorVida(ejercito2, 2);
        mostrarTotalYPromedio(ejercito1, 1);
        mostrarTotalYPromedio(ejercito2, 2);
        mostrarEjercito(ejercito1, 1);
        mostrarEjercito(ejercito2, 2);

        System.out.println("Bajo que criterio le gustaria ordenar los ejercitos?");
        System.out.println("1. Burbuja");
        System.out.println("2. Insercion");
        switch (sc.nextInt()) {
            case 1:
                ordenamientoBurbuja(ejercito1);
                ordenamientoBurbuja(ejercito2);
                break;
            case 2:
                ordenamientoInsercion(ejercito1);
                ordenamientoBurbuja(ejercito2);
                break;
            default:
        }
        System.out.println("Ranking segun vida (Del mayor al menor): ");
        mostrarEjercito(ejercito1, 1);
        mostrarEjercito(ejercito2, 2);

        ejercitoGanador(ejercito1, ejercito2);

    }

    public static void ejercitoGanador(Soldado[] army1, Soldado[] army2) {
        int total1 = 0;
        int total2 = 0;
        for (int i = 0; i < army1.length; i++) {
            total1 += army1[i].getVida();
        }
        for (int i = 0; i < army2.length; i++) {
            total2 += army2[i].getVida();
        }
        if (total1 > total2) {
            System.out.println("El ejercito 1 es ganador!");
        } else if (total1 == total2) {
            System.out.println("Empate");
        } else {
            System.out.println("El ejercito 2 es ganador");
        }
        System.out.println("Bajo el criterio de que ejercito tiene mas vida total");

    }

    public static void mostrarTotalYPromedio(Soldado[] army, int ej) {
        int total = 0;
        for (int i = 0; i < army.length; i++) {
            total += army[i].getVida();
        }
        System.out.println("El nivel de vida total del ejercito " + ej + " es: " + total);
        System.out.println("El nivel de vida promedio del ejercito " + ej + " es: " + total * 1.0 / army.length);
        System.out.println();
    }

    public static void mostrarEjercito(Soldado[] army, int ej) {
        System.out.println("Ejercito " + ej);
        for (int i = 0; i < army.length; i++) {
            mostrarSoldado(army, i);
        }
        System.out.println();
    }

    public static Soldado[] convertirArray(ArrayList<Soldado> army) {
        Soldado[] nuevo = new Soldado[army.size()];
        for (int i = 0; i < nuevo.length; i++) {
            nuevo[i] = army.get(i);
        }
        return nuevo;
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
            army.get(filas[i]).get(columnas[i]).setFila(filas[i]);
            army.get(filas[i]).get(columnas[i]).setColumna(columnas[i]);
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

    public static ArrayList<Soldado> crearLista(ArrayList<ArrayList<Soldado>> army, int[] filas, int[] columnas) {
        ArrayList<Soldado> nuevo = new ArrayList<>();
        for (int i = 0; i < filas.length; i++) {
            nuevo.add(army.get(filas[i]).get(columnas[i]));
        }
        return nuevo;
    }

    public static void ordenamientoInsercion(Soldado[] army) {
        for (int i = 1; i < army.length; i++) {
            Soldado valor = army[i];
            int j = i;
            for (j = i; 0 < j && army[j - 1].getVida() < valor.getVida(); j--) {
                army[j] = army[j - 1];
            }
            army[j] = valor;
        }
    }

    public static void ordenamientoBurbuja(Soldado[] army) {
        for (int i = 0; i < army.length; i++) {
            for (int j = 0; j < army.length - 1; j++) {
                if (army[j].getVida() < army[j + 1].getVida()) {
                    intercambiar(army, j, j + 1);
                }
            }
        }
    }

    public static void intercambiar(Soldado[] flota, int i, int j) {
        Soldado temp;
        temp = flota[i];
        flota[i] = flota[j];
        flota[j] = temp;
    }
}
