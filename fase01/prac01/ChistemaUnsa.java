import java.io.*;
import java.util.*;

public class ChistemaUnsa {
    public static void main(String[] args) throws IOException {
        int cDatos = Integer.parseInt(args[0]);
        Estudiante[] chunsa = new Estudiante[cDatos];
        Scanner sc = new Scanner(new File("data.csv"));
        Scanner sc2 = new Scanner(System.in);
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
        System.out.println("Bienvenido a la chunsa, que desea buscar?: ");
        System.out.println("Opciones: ");
        System.out.println("1. Buscar por Nombre");
        System.out.println("2. Buscar por Apellido");
        System.out.println("3. Buscar por CUI");
        System.out.println("4. Buscar por correo");
        System.out.println("5. Buscar por Fecha de Nacimiento");
        System.out.println("Ingrese su elección: ");
        int eleccion = sc.nextInt();
        switch (eleccion) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            default:
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

    public static void insertionSortFecha(Estudiante[] chunsa) {
        for (int i = 0; i < chunsa.length; i++) {
            Estudiante valor = chunsa[0];
            int j = i;
            for (j = i; 0 < j && chunsa[j - 1].getFecha()[0] > valor.getFecha()[0]
                    && chunsa[j - 1].getFecha()[1] > valor.getFecha()[1]
                    && chunsa[j - 1].getFecha()[2] > valor.getFecha()[2]; j--) {
                chunsa[j] = chunsa[j - 1];
            }
            chunsa[j] = valor;
        }
    }

    public static int binarySearchNombre(Estudiante[] chunsa, String nombre, String apellido) {
        int baja = 0, media, alta = chunsa.length - 1;
        while (baja <= alta) {
            media = (alta + baja) / 2;
            String nMedio = chunsa[media].getApPaterno();
            int compare = apellido.compareTo(nMedio);
            if (compare == 0 && nombre.equals(chunsa[media].getNombre())) {
                return media;
            } else if (compare < 0) {
                alta = media - 1;
            } else {
                baja = media + 1;
            }
        }
        return -1;
    }

    public static int binarySearchCui(Estudiante[] chunsa, int cui) {
        int baja = 0, media, alta = chunsa.length - 1;
        while (baja <= alta) {
            media = (alta + baja) / 2;
            int valor = chunsa[media].getCui();
            if (valor == cui) {
                return media;
            } else if (cui < valor) {
                alta = media - 1;
            } else {
                baja = media + 1;
            }
        }
        return -1;
    }

    public static int binarySearchCorreo(Estudiante[] chunsa, String correo) {
        int baja = 0, media, alta = chunsa.length - 1;
        while (baja <= alta) {
            media = (alta + baja) / 2;
            String nMedio = chunsa[media].getCorreo();
            int compare = correo.compareTo(nMedio);
            if (compare == 0) {
                return media;
            } else if (compare < 0) {
                alta = media - 1;
            } else {
                baja = media + 1;
            }
        }
        return -1;
    }
}
