class Punto {
    // Coordenadas x e y
    private double x;
    private double y;

    // Constructor
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter para x
    public double getX() {
        return x;
    }

    // Getter para y
    public double getY() {
        return y;
    }

    // Función para calcular la distancia entre dos puntos
    public double distancia(Punto otroPunto) {
        double distanciaX = otroPunto.getX() - this.x;
        double distanciaY = otroPunto.getY() - this.y;

        return Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);
    }
}

// Clase Circulo que hereda de la clase Punto
class Circulo extends Punto {
    // Atributo radio
    private double radio;

    // Constructor
    public Circulo(double x, double y, double radio) {
        super(x, y);
        this.radio = radio;
    }

    // Getter para radio
    public double getRadio() {
        return radio;
    }
}

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        // Crear dos puntos
        Punto punto1 = new Punto(1, 2);
        Punto punto2 = new Punto(4, 6);

        // Calcular la distancia entre los dos puntos
        double distancia = punto1.distancia(punto2);
        System.out.println("Distancia entre los dos puntos: " + distancia);

        // Crear un círculo
        Circulo circulo = new Circulo(0, 0, 5);

        // Acceder a las coordenadas del centro y al radio del círculo
        double centroX = circulo.getX();
        double centroY = circulo.getY();
        double radio = circulo.getRadio();

        System.out.println("Centro del círculo: (" + centroX + ", " + centroY + ")");
        System.out.println("Radio del círculo: " + radio);
    }
}
