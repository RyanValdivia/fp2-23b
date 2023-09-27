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

        String nombre = sc.next();
        // mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en
        // caso contrario
        int pos = busquedaLinealNombre(misNaves, nombre);
        if (pos != -1) {
            Nave n = misNaves[pos];
            System.out.println("Nave " + pos + ":" + n.getNombre());
            System.out.println("Posicion: " + n.getFila() + n.getColumna());
            System.out.println("Puntos: " + n.getPuntos());
            if (n.getEstado()) {
                System.out.println("Sigue con vida");
            } else {
                System.out.println("Fue destruida");
            }
        } else {
            System.out.println("Nave no encontrada");
        }
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);

        pos = busquedaBinariaNombre(misNaves, nombre);
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);

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

    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getNombre().equals(s)) {
                return i;
            }
        }
        return -1;
    }

    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        for (int i = 0; i < flota.length; i++) {
            for (int j = 0; j < flota.length - 1; j++) {
                if (flota[j].getPuntos() > flota[j + 1].getPuntos()) {
                    intercambiar(flota, j, j + 1);
                }
            }
        }
    }

    // Método que ordena por nombre de A a Z
    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        for (int i = 0; i < flota.length; i++) {
            for (int j = 0; j < flota.length - 1; j++) {
                if (flota[j].getNombre().compareTo(flota[j + 1].getNombre()) > 0) {
                    intercambiar(flota, j, j + 1);
                }
            }
        }
    }

    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        int baja = 0, media, alta = flota.length - 1;
        while (baja <= alta) {
            media = (alta + baja) / 2;
            String nMedio = flota[media].getNombre();
            int compare = s.compareTo(nMedio);
            if (compare == 0) {
                return media;
            } else if (compare < 0) {
                alta = media - 1;
            } else {
                baja = media + 1;
            }
        }
        return -1;
    }

    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
    }

    // Método que ordena por nombre de A a Z
    public static void ordenarPorNombreSeleccion(Nave[] flota) {
    }

    // Método que muestra las naves ordenadas por número de puntos de mayor a menor
    public static void ordenarPorPuntosInsercion(Nave[] flota) {
    }

    // Método que muestra las naves ordenadas por nombre de Z a A
    public static void ordenarPorNombreInsercion(Nave[] flota) {
    }

    public static void intercambiar(Nave[] flota, int i, int j) {
        Nave temp;
        temp = flota[i];
        flota[i] = flota[j];
        flota[j] = temp;
    }
}
