import java.util.*;

public class VideoJuego5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            Soldado[][] tablero = new Soldado[10][10];
            int ej1 = (int) (Math.random() * 10 + 1);
            int ej2 = (int) (Math.random() * 10 + 1);

            HashMap<String, Soldado> ejercito1 = new HashMap<>();
            HashMap<String, Soldado> ejercito2 = new HashMap<>();

            int[] filas1 = numerosRandom(ej1);
            int[] columnas1 = numerosRandom(ej1);
            int[] filas2;
            int[] columnas2;
            do {
                filas2 = numerosRandom(ej2);
                columnas2 = numerosRandom(ej2);
            } while (!diffCoordenadas(filas1, filas2, columnas1, columnas2));

            inicializarEjercito(ejercito1, filas1, columnas1, 1);
            inicializarEjercito(ejercito2, filas2, columnas2, 2);
            inicializarTablero(tablero);
            desplegarEjercito(tablero, ejercito1);
            desplegarEjercito(tablero, ejercito2);
            mostrarTablero(tablero);
            soldadoMayorVida(ejercito1, 1);
            soldadoMayorVida(ejercito2, 2);
            vidaPromedio(ejercito1, 1);
            vidaPromedio(ejercito2, 2);
            mostrarEjercito(ejercito1, 1);
            mostrarEjercito(ejercito2, 2);

            System.out.println("Bajo que algoritmo de ordenamiento le gustaria ordenar su ejercito?");
            System.out.println("1. Ordenamiento por burbuja");
            System.out.println("2. Ordenamiento por insercion\n");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Ranking por Vida: \n");
                    mostrarOrdenado(bubbleSort(ejercito1, 1), 1);
                    mostrarOrdenado(bubbleSort(ejercito2, 2), 2);
                    break;
                case 2:
                    System.out.println("Ranking por Vida: \n");
                    mostrarOrdenado(insertionSort(ejercito1, 1), 1);
                    mostrarOrdenado(insertionSort(ejercito2, 2), 2);
                    break;
                default:
            }
            System.out.println("Presione q para salir, o cualquier otra tecla para volver a jugar");
        } while (sc.next() != "q");

    }

    public static void inicializarEjercito(HashMap<String, Soldado> army, int[] x, int[] y, int ej) {
        for (int i = 0; i < x.length; i++) {
            String key = "Soldado" + i + "X" + ej;
            int v = (int) (Math.random() * 5 + 1);
            army.put(key, new Soldado());
            army.get(key).setNombre(key);
            army.get(key).setFila(x[i]);
            army.get(key).setColumna(y[i]);
            army.get(key).setVida(v);
            if (ej == 1) {
                army.get(key).setBandera("##########");
            } else {
                army.get(key).setBandera("**********");
            }
        }
    }

    public static void inicializarTablero(Soldado[][] tb) {
        for (int i = 0; i < tb.length; i++) {
            for (int j = 0; j < tb[i].length; j++) {
                tb[i][j] = new Soldado();
                tb[i][j].setNombre("          ");
                tb[i][j].setBandera("          ");
            }
        }
    }

    public static void desplegarEjercito(Soldado[][] tb, HashMap<String, Soldado> army) {
        army.forEach((key, value) -> {
            tb[value.getFila()][value.getColumna()] = value;
        });
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

    public static void soldadoMayorVida(Map<String, Soldado> army, int ej) {
        boolean pro = true;
        String keyMx = "";
        for (Map.Entry<String, Soldado> entry : army.entrySet()) {
            if (pro) {
                keyMx = entry.getKey();
                pro = false;
            }
            if (army.get(keyMx).getVida() < entry.getValue().getVida()) {
                keyMx = entry.getKey();
            }
        }
        System.out.println("El soldado con mayor vida del ejercito " + ej + " es: ");
        mostrarSoldado(army.get(keyMx));
        System.out.println();

    }

    public static void vidaPromedio(HashMap<String, Soldado> army, int ej) {
        int total = 0;
        for (Map.Entry<String, Soldado> entry : army.entrySet()) {
            total += entry.getValue().getVida();
        }
        System.out.println("La vida total del ejercito " + ej + " es: " + total);
        System.out.println("La vida promedio del ejercito " + ej + " es: " + total / (1.0 * army.size()));
        System.out.println();
    }

    public static void mostrarEjercito(Map<String, Soldado> army, int ej) {
        System.out.println("Ejercito " + ej);
        for (int i = 0; i < army.size(); i++) {
            String key = "Soldado" + i + "X" + ej;
            mostrarSoldado(army.get(key));
        }
        System.out.println();
    }

    public static void mostrarSoldado(Soldado s) {
        String columna;
        System.out.println("Nombre: " + s.getNombre());
        System.out.println("Vida: " + s.getVida() + " HP");
        switch (s.getColumna() + 1) {
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
        System.out.println("Posición: " + (s.getFila() + 1) + "-" + columna);
        System.out.println();
    }

    public static LinkedHashMap<String, Soldado> bubbleSort(HashMap<String, Soldado> map, int ej) {
        ArrayList<Soldado> army = getLista(map);
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < army.size() - 1; i++) {
                if (army.get(i).getVida() < army.get(i + 1).getVida()) {
                    Soldado temp = army.get(i);
                    army.set(i, army.get(i + 1));
                    army.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        LinkedHashMap<String, Soldado> sortedMap = new LinkedHashMap<>();
        for (int i = 0; i < army.size(); i++) {
            String key = army.get(i).getNombre();
            sortedMap.put(key, army.get(i));
        }
        return sortedMap;
    }

    public static LinkedHashMap<String, Soldado> insertionSort(HashMap<String, Soldado> map, int ej) {
        ArrayList<Soldado> army = getLista(map);
        int i, j;
        for (i = 1; i < army.size(); i++) {
            Soldado tmp = army.get(i);
            j = i;
            while ((j > 0) && (army.get(j - 1).getVida() < tmp.getVida())) {
                army.set(j, army.get(j - 1));
                j--;
            }
            army.set(j, tmp);
        }
        LinkedHashMap<String, Soldado> sortedMap = new LinkedHashMap<>();
        for (int k = 0; k < army.size(); k++) {
            String key = army.get(k).getNombre();
            sortedMap.put(key, army.get(k));
        }
        return sortedMap;

    }

    public static ArrayList<Soldado> getLista(HashMap<String, Soldado> map) {
        ArrayList<Soldado> list = new ArrayList<Soldado>();
        list.addAll(map.values());
        return list;
    }

    public static void mostrarOrdenado(Map<String, Soldado> map, int ej) {
        System.out.println("Ejercito " + ej);
        System.out.println(map.get("Soldado0X" + ej).getBandera() + "\n");
        for (Map.Entry<String, Soldado> entry : map.entrySet()) {
            mostrarSoldado(entry.getValue());
        }
    }
}
