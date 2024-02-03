import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("datos.dat", true);
        fw.write("2" + "\t" + "40");
        fw.close();
    }
}
