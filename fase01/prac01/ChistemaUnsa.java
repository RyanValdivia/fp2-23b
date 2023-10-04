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
        System.out.println("Tipo de ordenamiento: ");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Quick Sort");
        int eleccion1 = sc2.nextInt();
        System.out.println("Bienvenido a la chunsa, que desea buscar?");
        System.out.println("Opciones: ");
        System.out.println("1. Buscar por Nombre y apellido");
        System.out.println("2. Buscar por CUI");
        System.out.println("3. Buscar por correo");
        System.out.println("Ingrese su elección: ");
        int eleccion2 = sc2.nextInt();
        switch (eleccion1) {
            case 1:
                switch (eleccion2) {
                    case 1:
                        long momento = System.nanoTime();
                        insertionSortApellido(chunsa);
                        fw.write(args[0] + "\t" + (momento - System.nanoTime()));
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
                        long momento2 = System.nanoTime();
                        insertionSortCui(chunsa);
                        fw.write(args[0] + "\t" + (momento2 - System.nanoTime()));
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
                        long momento3 = System.nanoTime();
                        insertionSortCorreo(chunsa);
                        fw.write(args[0] + "\t" + (momento3 - System.nanoTime()));
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
                break;
            case 2:
                switch (eleccion2) {
                    case 1:
                        long momento = System.nanoTime();
                        quickSortApellido(chunsa, 0, chunsa.length - 1);
                        fw.write(args[0] + "\t" + (momento - System.nanoTime()));
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
                        long momento2 = System.nanoTime();
                        quickSortCui(chunsa, 0, chunsa.length - 1);
                        fw.write(args[0] + "\t" + (momento2 - System.nanoTime()));
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
                        long momento3 = System.nanoTime();
                        quickSortCorreo(chunsa, 0, chunsa.length - 1);
                        fw.write(args[0] + "\t" + (momento3 - System.nanoTime()));
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

    public static void quickSortApellido(Estudiante[] chunsa, int baja, int alta) {
        int indicePivot = baja + (alta - baja) / 2;
        int i = baja, j = alta;
        Estudiante pivot = chunsa[indicePivot];
        while (i <= j) {
            while (chunsa[i].getApPaterno().compareTo(pivot.getApPaterno()) < 0) {
                i++;
            }
            while (chunsa[i].getApPaterno().compareTo(pivot.getApPaterno()) > 0) {
                j--;
            }
            if (i <= j) {
                swap(chunsa, i, j);
                i++;
                j--;
            }
            if (baja < j) {
                quickSortApellido(chunsa, baja, j);
            }
            if (alta > i) {
                quickSortApellido(chunsa, i, alta);
            }
        }
    }

    public static void quickSortCui(Estudiante[] chunsa, int baja, int alta) {
        int indicePivot = baja + (alta - baja) / 2;
        Estudiante pivot = chunsa[indicePivot];
        int i = baja, j = alta;
        while (i <= j) {
            while (chunsa[i].getCui() < pivot.getCui()) {
                i++;
            }
            while (chunsa[j].getCui() > pivot.getCui()) {
                j--;
            }
            if (i <= j) {
                swap(chunsa, i, j);
                i++;
                j--;
            }
            if (baja < j) {
                quickSortCui(chunsa, baja, j);
            }
            if (alta > i) {
                quickSortCui(chunsa, i, alta);
            }
        }
    }

    public static void quickSortCorreo(Estudiante[] chunsa, int baja, int alta) {
        int indicePivot = baja + (alta - baja) / 2;
        Estudiante pivot = chunsa[indicePivot];
        int i = baja, j = alta;
        while (i <= j) {
            while (chunsa[i].getCorreo().compareTo(pivot.getCorreo()) < 0) {
                i++;
            }
            while (chunsa[i].getCorreo().compareTo(pivot.getCorreo()) > 0) {
                j--;
            }
            if (i <= j) {
                swap(chunsa, i, j);
                i++;
                j--;
            }
            if (baja < j) {
                quickSortCorreo(chunsa, baja, j);
            }
            if (alta > i) {
                quickSortCorreo(chunsa, i, alta);
            }
        }
    }

    public static void swap(Estudiante[] chunsa, int i, int j) {
        Estudiante temp = chunsa[i];
        chunsa[i] = chunsa[j];
        chunsa[j] = temp;
    }
}
