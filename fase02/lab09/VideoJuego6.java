import java.util.*;

public class VideoJuego6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            Soldado[][] tablero = new Soldado[10][10];

            int ej1 = (int) (Math.random() * 10 + 1);
            int ej2 = (int) (Math.random() * 10 + 1);

            Soldado[] ejercito1 = new Soldado[ej1];
            Soldado[] ejercito2 = new Soldado[ej2];

            int[] filas1 = numerosRandom(ej1);
            int[] columnas1 = numerosRandom(ej1);
            int[] filas2;
            int[] columnas2;

            do {
                filas2 = numerosRandom(ej2);
                columnas2 = numerosRandom(ej2);
            } while (!diffCoordenadas(filas1, filas2, columnas1, columnas2));

            inicializarTablero(tablero);
            iniciarEjercito(ejercito1, filas1, columnas1, 1);
            iniciarEjercito(ejercito2, filas2, columnas2, 2);
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
            System.out.println("2. Ordenamiento por insercion");
            switch (sc.nextInt()) {
                case 1:
                    ordenamientoBurbuja(ejercito1);
                    ordenamientoBurbuja(ejercito2);
                    break;
                case 2:
                    ordenamientoInsercion(ejercito1);
                    ordenamientoInsercion(ejercito2);
                    break;
                default:
            }
            System.out.println();
            System.out.println("Ranking de ambos ejercitos del soldado con mayor a menor vida: \n");
            mostrarEjercito(ejercito1, 1);
            mostrarEjercito(ejercito2, 2);
            ejercitoGanador(ejercito1, ejercito2);
            System.out.println("Presione q para salir, o cualquier otra tecla para volver a jugar");
        } while (!sc.next().equals("q"));

    }

    public static void inicializarTablero(Soldado[][] tb) {
        for (int i = 0; i < tb.length; i++) {
            for (int j = 0; j < tb[i].length; j++) {
                tb[i][j] = new Soldado();
            }
        }
    }

    public static void iniciarEjercito(Soldado[] ar, int[] x, int[] y, int nro) {
        for (int i = 0; i < x.length; i++) {
            int atk = (int) (Math.random() * 5 + 1);
            int def = (int) (Math.random() * 5 + 1);
            int vida = (int) (Math.random() * 5 + 1);
            ar[i] = new Soldado("Soldado" + i + "X" + nro, atk, def, vida, nro);
            ar[i].moverSoldado(x[i], y[i]);
        }
    }

    public static void desplegarEjercito(Soldado[][] tb, Soldado[] ar) {
        for (int i = 0; i < ar.length; i++) {
            tb[ar[i].getFila()][ar[i].getColumna()] = ar[i];
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
                        System.out
                                .print("|   " + tb[i][j].getVidaActual() + "/" + tb[i][j].getVida() + " HP" + "   |\n");
                    } else {
                        System.out.print("|   " + tb[i][j].getVidaActual() + "/" + tb[i][j].getVida() + " HP" + "   ");
                    }
                } else {
                    if (j == tb[i].length - 1) {
                        System.out.print("| " + vacio + " |\n");
                    } else {
                        System.out.print("| " + vacio + " ");
                    }
                }
            }
            for (int j = 0; j < tb[i].length; j++) {
                if (tb[i][j].getDefensa() != 0) {
                    if (j == tb[i].length - 1) {
                        System.out.print("|    " + tb[i][j].getDefensa() + " DP" + "    |\n");
                    } else {
                        System.out.print("|    " + tb[i][j].getDefensa() + " DP" + "    ");
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
        System.out.println("Defensa: " + army[i].getDefensa() + " DP");
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
        System.out.println();

    }

    public static void mostrarEjercito(Soldado[] army, int ej) {
        System.out.println("Ejercito " + ej);
        System.out.println(army[0].getBandera());
        for (int i = 0; i < army.length; i++) {
            mostrarSoldado(army, i);
        }
        System.out.println();
    }

    public static int vidaPromedio(Soldado[] army, int ej) {
        int total = 0;
        for (Soldado s : army) {
            total += s.getVida();
        }
        System.out.println("La vida total del ejercito " + ej + " es: " + total);
        System.out.println("La vida promedio del ejercito " + ej + " es: " + total / (1.0 * army.length));
        System.out.println();
        return total;
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

    public static void ejercitoGanador(Soldado[] f1, Soldado[] f2) {
        double total1 = vidaPromedio(f1, 1) * 1.0 / f1.length;
        double total2 = vidaPromedio(f2, 1) * 1.0 / f2.length;
        if (total1 > total2) {
            System.out.println("El ejercito 1 es ganador!");
        } else if (total1 == total2) {
            System.out.println("Hay empate!");
        } else {
            System.out.println("El ejercito 2 es ganador!");
        }
        System.out.println("Bajo la metrica de que ejercito tiene mas vida promedio");
    }
}
