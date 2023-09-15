import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        int len1 = (int) (Math.random() * 5 + 1);
        int len2 = (int) (Math.random() * 5 + 1);
        String[] army1 = new String[len1];
        String[] army2 = new String[len2];
        init(army1);
        init(army2);
        mostrar(army1, army2);
        win(len1, len2);

    }

    public static void init(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            strs[i] = "Soldado" + i;
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

    public static void mostrar(String[] strs1, String[] strs2) {
        System.out.println("Ejercito 1: ");
        for (String s : strs1) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("Ejercito 2: ");
        for (String s : strs2) {
            System.out.println(s);
        }
        System.out.println();
    }
}