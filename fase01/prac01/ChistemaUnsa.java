import java.io.*;
import java.util.*;

public class ChistemaUnsa {
    public static void main(String[] args) throws IOException {
        int cDatos = Integer.parseInt(args[0]);
        Estudiante[] chunsa = new Estudiante[cDatos];
        Scanner sc = new Scanner(new File("data.csv"));
        sc.useDelimiter(", ");
        for (int i = 0; i < chunsa.length; i++) {
            chunsa[i] = new Estudiante();
            chunsa[i].setNombre(sc.next());
            chunsa[i].setSNombre(sc.next());
            chunsa[i].setApPaterno(sc.next());
            chunsa[i].setApMaterno(sc.next());
            chunsa[i].setCorreo(sc.next());
            chunsa[i].setCui(sc.nextInt());
            chunsa[i].setFecha(sc.nextInt(), sc.nextInt(), sc.nextInt());
            chunsa[i].setGenero(Boolean.parseBoolean(sc.next()));
            chunsa[i].setEstado(Boolean.parseBoolean(sc.next()));
        }

        for (Estudiante e : chunsa) {
            System.out.println(e.getNombre());
        }
    }

    public static void insertionSortCui(Estudiante[] chunsa) {
        for (int i = 0; i < chunsa.length; i++) {
            Estudiante valor = chunsa[0];
            int j = i;
            for (j = i; 0 < j && chunsa[j - 1].getCui() > valor.getCui(); j--) {
                chunsa[j] = chunsa[j - 1];
            }
            chunsa[j] = valor;
        }
    }

    public static void insertionSortNombre(Estudiante[] chunsa) {
        for (int i = 1; i < chunsa.length; i++) {
            Estudiante valor = chunsa[i];
            int j = i;
            for (j = i; 0 < j && chunsa[j - 1].getNombre().compareTo(valor.getNombre()) < 0; j--) {
                chunsa[j] = chunsa[j - 1];
            }
            chunsa[j] = valor;
        }
    }

    public static void insertionSortApellido(Estudiante[] chunsa) {
        for (int i = 1; i < chunsa.length; i++) {
            Estudiante valor = chunsa[i];
            int j = i;
            for (j = i; 0 < j && chunsa[j - 1].getApPaterno().compareTo(valor.getApPaterno()) < 0; j--) {
                chunsa[j] = chunsa[j - 1];
            }
            chunsa[j] = valor;
        }
    }

    public static void insertionSortCorreo(Estudiante[] chunsa) {
        for (int i = 1; i < chunsa.length; i++) {
            Estudiante valor = chunsa[i];
            int j = i;
            for (j = i; 0 < j && chunsa[j - 1].getCorreo().compareTo(valor.getCorreo()) < 0; j--) {
                chunsa[j] = chunsa[j - 1];
            }
            chunsa[j] = valor;
        }
    }
}
