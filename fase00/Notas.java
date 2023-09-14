import java.io.*;
import java.util.*;

public class Notas {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("notas.txt", true);
        for (int i = 0; i < 100; i++) {
            System.out.println("¿Nuevo cálculo? (y/n)");

            String rpta = sc.nextLine();
            if (rpta.equals("n")) {
                break;
            }
            System.out.println("Ingrese el nombre de la asignatura");
            String subject = sc.nextLine();

            System.out.println("Ingrese el nombre del alumno");
            String student = sc.next();

            System.out.println("Ingrese los ponderados");
            double[] weigths = new double[6];
            for (int j = 0; j < 6; j++) {
                weigths[j] = sc.nextDouble();
            }

            System.out.println("Ingrese las notas del alumno");
            double avg = 0;
            for (int j = 0; j < 6; j++) {
                double[] grades = new double[6];
                grades[j] = sc.nextDouble();
                avg += grades[j] * weigths[j];
            }
            String basura = sc.nextLine();

            fw.write("Hola " + student + ", tu promedio en la asignatura " + subject + " es: " + avg);
            fw.write("\r\n");
            fw.close();
        }
    }
}