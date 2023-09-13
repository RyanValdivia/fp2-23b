import java.io.*;
import java.util.*;

public class Notas {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("notas.txt", true);
        final double[] weigths = new double[] { 0.05, 0.05, 0.15, 0.15, 0.2, 0.4 };
        for (int i = 0; i < 100; i++) {
            System.out.println("Ingrese el nombre del alumno (Ingrese 'q' para cancelar)");
            String student = sc.next();
            if (student.equals("q")) {
                break;
            }
            fw.write(student);
            fw.write(" ");
            System.out.println("Ingrese las notas del alumno");
            double avg = 0;
            for (int j = 0; j < 6; j++) {
                double[] grades = new double[6];
                grades[j] = sc.nextDouble();
                avg += grades[j] * weigths[j];
            }
            fw.write("El promedio final es: " + avg);
            fw.close();
        }
    }
}