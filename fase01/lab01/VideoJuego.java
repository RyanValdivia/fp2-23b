import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese los nombres de los soldados: ");
        String sold1 = sc.nextLine();
        String sold2 = sc.nextLine();
        String sold3 = sc.nextLine();
        String sold4 = sc.nextLine();
        String sold5 = sc.nextLine();

        System.out.println("Soldado 1: " + sold1);
        System.out.println("Soldado 2: " + sold2);
        System.out.println("Soldado 3: " + sold3);
        System.out.println("Soldado 4: " + sold4);
        System.out.println("Soldado 5: " + sold5);

        sc.close();
    }
}