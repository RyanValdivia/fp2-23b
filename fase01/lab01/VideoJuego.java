import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese los nombres de los soldados y su respectivo nivel de vida: ");
        String sold1 = sc.next();
        int lvl1 = sc.nextInt();
        String sold2 = sc.next();
        int lvl2 = sc.nextInt();
        String sold3 = sc.next();
        int lvl3 = sc.nextInt();
        String sold4 = sc.next();
        int lvl4 = sc.nextInt();
        String sold5 = sc.next();
        int lvl5 = sc.nextInt();

        System.out.println("Soldado 1: " + sold1 + " y su nivel de vida es: " + lvl1);
        System.out.println("Soldado 1: " + sold2 + " y su nivel de vida es: " + lvl2);
        System.out.println("Soldado 1: " + sold3 + " y su nivel de vida es: " + lvl3);
        System.out.println("Soldado 1: " + sold4 + " y su nivel de vida es: " + lvl4);
        System.out.println("Soldado 1: " + sold5 + " y su nivel de vida es: " + lvl5);

        sc.close();
    }
}