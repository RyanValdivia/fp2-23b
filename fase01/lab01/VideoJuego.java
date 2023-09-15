import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese los nombres de los soldados");

        String[] soldiers = new String[5];

        for (int i = 0; i < 5; i++) {
            soldiers[i] = sc.next();
        }

        for (int i = 1; i < 6; i++) {
            System.out.println("Soldado " + i + ": " + soldiers[i]);
        }

        sc.close();
    }
}