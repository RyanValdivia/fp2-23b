import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        int len1 = (int) (Math.random() * 5 + 1);
        int len2 = (int) (Math.random() * 5 + 1);
        Soldado[] army1 = new Soldado[len1];
        Soldado[] army2 = new Soldado[len2];
        init(army1);
        init(army2);
        mostrar(army1, army2);
        win(len1, len2);

    }

    public static void init(Soldado[] soldiers) {
        for (int i = 0; i < soldiers.length; i++) {
            soldiers[i] = new Soldado();
            soldiers[i].setNombre("Soldado " + i);
        }
    }

    public static void win(int l1, int l2) {
        if (l1 > l2) {
            System.out.println("El ejército 1 es ganador");
        } else if (l1 == l2) {
            System.out.println("Hay empate");
        } else {
            System.out.println("El ejército 2 es ganador");
        }
    }

    public static void mostrar(Soldado[] army1, Soldado[] army2) {
        System.out.println("Ejercito 1: ");
        for (int i = 0; i < army1.length; i++) {
            System.out.println(army1[i].getNombre());
        }
        System.out.println();
        System.out.println("Ejercito 2: ");
        for (int i = 0; i < army2.length; i++) {
            System.out.println(army2[i].getNombre());
        }

    }
}