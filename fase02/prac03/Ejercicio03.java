// Interfaz para la clase Barco
interface Barco {
    void navegar();
}

// Interfaz para la clase Avión
interface Avion {
    void volar();
}

// Clase que implementa la herencia múltiple de Barco y Avion
class Hidroavion implements Barco, Avion {
    @Override
    public void navegar() {
        System.out.println("El hidroavión está navegando por el agua.");
    }

    @Override
    public void volar() {
        System.out.println("El hidroavión está volando por el aire.");
    }
}

// Ejemplo de uso
public class Ejercicio03 {
    public static void main(String[] args) {
        Hidroavion miHidroavion = new Hidroavion();

        // Usar métodos de Barco
        miHidroavion.navegar();

        // Usar métodos de Avión
        miHidroavion.volar();
    }
}
