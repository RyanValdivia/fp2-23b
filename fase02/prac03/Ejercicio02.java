
// Clase derivada Cilindro
class Cilindro extends Circulo {
    // Atributo longitud
    private double longitud;

    // Constructor
    public Cilindro(double x, double y, double radio, double longitud) {
        super(x, y, radio);
        this.longitud = longitud;
    }

    // Getter para longitud
    public double getLongitud() {
        return longitud;
    }

    // Función para calcular la superficie del cilindro
    public double calcularSuperficie() {
        double radio = getRadio();
        return 2 * Math.PI * radio * (longitud + radio);
    }
}

// Ejemplo de uso
public class Ejercicio02 {
    public static void main(String[] args) {
        // Crear un cilindro
        Cilindro cilindro = new Cilindro(0, 0, 3, 5);

        // Acceder a las propiedades del cilindro
        double radioCilindro = cilindro.getRadio();
        double longitudCilindro = cilindro.getLongitud();

        // Calcular y mostrar la superficie del cilindro
        double superficieCilindro = cilindro.calcularSuperficie();
        System.out.println("Radio del cilindro: " + radioCilindro);
        System.out.println("Longitud del cilindro: " + longitudCilindro);
        System.out.println("Superficie del cilindro: " + superficieCilindro);
    }
}
