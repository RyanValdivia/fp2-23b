import java.util.*;

public class Ahorcado {
    public static void main(String[] args) {

        String ahor1 = " +---+ \n" +
                " |   | \n" +
                "     | \n" +
                "     | \n" +
                "     | \n" +
                "     | \n" +
                "========= ";
        String ahor2 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                "     | \n" +
                "     | \n" +
                "     | \n" +
                "========= ";
        String ahor3 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                " |   | \n" +
                "     | \n" +
                "     | \n" +
                "========= ";
        String ahor4 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                "/|   | \n" +
                "     | \n" +
                "     | \n" +
                "========= ";
        String ahor5 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                "/|\\  | \n" +
                "     | \n" +
                "     | \n" +
                "========= ";
        String ahor6 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                "/|\\  | \n" +
                "/    | \n" +
                "     | \n" +
                "========= ";
        String ahor7 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                "/|\\  | \n" +
                "/ \\  | \n" +
                "     | \n" +
                "========= ";

        String[] figuras = { ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7 };
        int contador = 1;
        String letra;
        String[] palabras = { "programacion", "java", "identacion", "clases", "objetos", "desarrollador", "pruebas" };
        String palSecreta = getPalabraSecreta(palabras);
        System.out.println(figuras[0]);
        char[] secreta = palSecreta.toCharArray();
        char[] incognita = crearVacio(palSecreta);
        String blacklist = getBlacklist(palSecreta);
        System.out.println("\n");
        int turnos = 1;
        while (contador <= 6) {
            mostrarPalabra(incognita);
            System.out.println();
            letra = ingreseLetra();
            if (letraEnPalabraSecreta(letra, blacklist)) {
                blacklist = quitarLetra(blacklist, letra);
                incognita = modificarArreglo(incognita, secreta, letra);
                if (blacklist.length() == 0) {
                    mostrarPalabra(incognita);
                    break;
                }
            } else {
                System.out.println(figuras[contador]);
                contador = contador + 1;
            }
            turnos++;
        }
        if (contador == 7) {
            System.out.println("Perdiste, prueba de nuevo");
        } else {
            System.out.println("Ganaste!, tardaste " + turnos + " turnos en vencer");
        }
        System.out.println("\n");
    }

    public static String getPalabraSecreta(String[] lasPalabras) {
        int ind;
        int indiceMayor = lasPalabras.length - 1;
        int indiceMenor = 0;
        ind = (int) ((Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor));
        return lasPalabras[ind];
    }

    public static String ingreseLetra() {
        String laLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        laLetra = sc.next();
        while (laLetra.length() != 1 || !esCaracter(laLetra)) {
            System.out.println("Ingrese solo letras, vuelva a intentarlo");
            laLetra = sc.next();
        }
        return laLetra;
    }

    public static boolean letraEnPalabraSecreta(String letra, String palSecreta) {
        return palSecreta.indexOf(letra) != -1;
    }

    public static void mostrarPalabra(char[] letras) {
        System.out.println("PROCESANDO.....");
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i] + " ");
        }
        System.out.println();
    }

    public static boolean esCaracter(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        char c = str.charAt(0);
        return ('a' <= c && c <= 'z');
    }

    public static char[] crearVacio(String str) {
        char[] incognito = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            incognito[i] = '_';
        }
        return incognito;
    }

    public static String getBlacklist(String str) {
        String blacklist = "" + str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (blacklist.indexOf(str.charAt(i)) == -1) {
                blacklist += str.charAt(i);
            }
        }
        return blacklist;
    }

    public static String quitarLetra(String blacklist, String letra) {
        int idx = blacklist.indexOf(letra);
        blacklist = blacklist.substring(0, idx) + blacklist.substring(idx + 1);
        return blacklist;
    }

    public static char[] modificarArreglo(char[] incognita, char[] palabra, String letra) {
        char actual = letra.charAt(0);
        for (int i = 0; i < incognita.length; i++) {
            if (palabra[i] == actual) {
                incognita[i] = actual;
            }
        }
        return incognita;
    }
}