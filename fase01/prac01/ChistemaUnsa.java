import java.io.*;
import java.util.*;

public class ChistemaUnsa {
    public static void main(String[] args) throws IOException {
        int cDatos = Integer.parseInt(args[0]);
        Estudiante[] chunsa = new Estudiante[cDatos];
        Scanner sc = new Scanner(new File("data.csv"));
        Scanner sc2 = new Scanner(System.in);
        FileWriter fw = new FileWriter("datos.dat", true);
        sc.useDelimiter(", ");
        for (int i = 0; i < chunsa.length; i++) {
            chunsa[i] = new Estudiante();
            chunsa[i].setNombre(sc.next());
            chunsa[i].setSNombre(sc.next());
            chunsa[i].setApPaterno(sc.next());
            chunsa[i].setApMaterno(sc.next());
            chunsa[i].setCorreo(sc.next());
            chunsa[i].setCui(sc.nextInt());
            chunsa[i].setFecha(sc.next());
            chunsa[i].setGenero(Boolean.parseBoolean(sc.next()));
            chunsa[i].setEstado(Boolean.parseBoolean(sc.next()));
        }
        System.out.println("Bienvenido a la chunsa, que desea buscar?");
        System.out.println("Opciones: ");
        System.out.println("1. Buscar por Nombre y apellido");
        System.out.println("2. Buscar por CUI");
        System.out.println("3. Buscar por correo");
        System.out.println("Ingrese su elección: ");
        int eleccion = sc2.nextInt();
        switch (eleccion) {
            case 1:
                insertionSortApellido(chunsa);
                System.out.println("Ingrese el nombre y apellido del estudiante a buscar: ");
                String nombre = sc2.next(), apellido = sc2.next();
                int indice = binarySearchNombre(chunsa, nombre, apellido);
                if (indice == -1) {
                    System.out.println("Alumno no encontrado");
                } else {
                    mostrarAlumno(chunsa, indice);
                }
                break;
            case 2:
                insertionSortCui(chunsa);
                System.out.println("Ingrese el CUI a buscar: ");
                int cui = sc2.nextInt();
                int indice2 = binarySearchCui(chunsa, cui);
                System.out.println(indice2);
                if (indice2 == -1) {
                    System.out.println("Alumno no encontrado");
                } else {
                    mostrarAlumno(chunsa, indice2);
                }
                break;
            case 3:
                insertionSortCorreo(chunsa);
                System.out.println("Ingrese el correo institucional a buscar: ");
                String correo = sc2.next();
                int indice3 = binarySearchCorreo(chunsa, correo);
                if (indice3 == -1) {
                    System.out.println("Alumno no encontrado");
                } else {
                    mostrarAlumno(chunsa, indice3);
                }
                break;
            default:
        }
    }

    public static void mostrarAlumno(Estudiante[] chunsa, int indice) {
        Estudiante e = chunsa[indice];
        System.out.println("Nombre completo: " + e.getNombre() + " " + e.getSNombre() + " " + e.getApPaterno() + " "
                + e.getApMaterno());
        System.out.println("Correo institucional: " + e.getCorreo());
        System.out.println("CUI: " + e.getCui());
        System.out.println("Fecha de nacimiento: " + e.getFecha());
        System.out.println("Genero: " + e.getGenero());
        System.out.println("Estado: " + e.getEstado());
    }

    public static void insertionSortCui(Estudiante[] chunsa) {
        for (int i = 0; i < chunsa.length; i++) {
            Estudiante valor = chunsa[i];
            int j = i;
            for (j = i; 0 < j && chunsa[j - 1].getCui() > valor.getCui(); j--) {
                chunsa[j] = chunsa[j - 1];
            }
            chunsa[j] = valor;
        }
    }

    public static void insertionSortApellido(Estudiante[] chunsa) {
        for (int i = 1; i < chunsa.length; i++) {
            Estudiante valor = chunsa[i];
            int j = i;
            for (j = i; 0 < j && chunsa[j - 1].getApPaterno().compareTo(valor.getApPaterno()) > 0; j--) {
                chunsa[j] = chunsa[j - 1];
            }
            chunsa[j] = valor;
        }
    }

    public static void insertionSortCorreo(Estudiante[] chunsa) {
        for (int i = 1; i < chunsa.length; i++) {
            Estudiante valor = chunsa[i];
            int j = i;
            for (j = i; 0 < j && chunsa[j - 1].getCorreo().compareTo(valor.getCorreo()) > 0; j--) {
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
            media = (int) (Math.floor((alta + baja) / 2));
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
