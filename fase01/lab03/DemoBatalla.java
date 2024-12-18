import java.util.*;

public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[5];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.println("Nombre: ");
            nomb = sc.next();
            System.out.println("Fila ");
            fil = sc.nextInt();
            System.out.println("Columna: ");
            col = sc.next();
            System.out.println("Estado: ");
            est = sc.nextBoolean();
            System.out.println("Puntos: ");
            punt = sc.nextInt();
            misNaves[i] = new Nave(); // Se crea un objeto Nave y se asigna su referencia a misNaves
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor numero de puntos: " + mostrarMayorPuntos(misNaves).getNombre());
        mostrarNaves(desordenar(misNaves));
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        int i = 1;
        for (Nave n : flota) {
            System.out.println("Nave " + i + ":" + n.getNombre());
            System.out.println("Posicion: " + n.getFila() + n.getColumna());
            System.out.println("Puntos: " + n.getPuntos());
            if (n.getEstado()) {
                System.out.println("Sigue con vida");
            } else {
                System.out.println("Fue destruido");
            }
            System.out.println();
            i++;
        }
    }

    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.next();
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getNombre().equals(nombre)) {
                Nave n = flota[i];
                System.out.println(n.getNombre());
                System.out.println("Posicion: " + n.getFila() + n.getColumna());
                System.out.println("Puntos: " + n.getPuntos());
                if (n.getEstado()) {
                    System.out.println("Sigue con vida");
                } else {
                    System.out.println("Fue destruido");
                }
            }
        }
    }

    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        int puntos = sc.nextInt();
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getPuntos() <= puntos) {
                Nave n = flota[i];
                System.out.println("Nave " + i + ":" + n.getNombre());
                System.out.println("Posicion: " + n.getFila() + n.getColumna());
                System.out.println("Puntos: " + n.getPuntos());
                if (n.getEstado()) {
                    System.out.println("Sigue con vida");
                } else {
                    System.out.println("Fue destruido");
                }
            }
        }
    }

    // Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        int mayor = 0;
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getPuntos() > flota[mayor].getPuntos()) {
                mayor = i;
            }
        }
        return flota[mayor];
    }

    // Crear un método que devuelva un nuevo arreglo de objetos con todos los
    // objetos previamente ingresados
    // pero aleatoriamente desordenados
    public static Nave[] desordenar(Nave[] flota) {
        Nave[] desordenado = new Nave[flota.length];
        int[] desorden = numerosRandom(flota);
        for (int i = 0; i < desordenado.length; i++) {
            desordenado[i] = flota[desorden[i]];
        }
        return desordenado;
    }

    public static int[] numerosRandom(Nave[] flota) {
        int[] nums = new int[flota.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length;
        }
        for (int i = 0; i < flota.length; i++) {
            int n;
            do {
                n = (int) (Math.random() * flota.length);
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
