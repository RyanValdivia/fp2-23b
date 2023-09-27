import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Soldado[] army = new Soldado[5];
        for (int i = 0; i < army.length; i++) {
            army[i] = new Soldado();
            System.out.println("Ingrese el nombre del soldado: ");
            army[i].setNombre(sc.next());
            System.out.println("Ingrese su nivel de vida");
            army[i].setVida(sc.nextInt());
        }
        int i = 1;
        for (Soldado s : army) {
            System.out.println("Soldado " + i + " : " + s.getNombre());
            System.out.println("Tiene " + s.getVida() + " puntos de vida\n");
            i++;
        }
    }
}
