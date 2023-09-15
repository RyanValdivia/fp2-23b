import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese los nombres de los soldados y sus respectivos niveles de vida");

        String[] soldiers = new String[5];
        int[] levels = new int[5];

        for (int i = 0; i < 5; i++) {
            soldiers[i] = sc.next();
            levels[i] = sc.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Soldado " + i + ": " + soldiers[i] + " y su nivel de vida es: " + levels[i]);
        }

        sc.close();
    }
}