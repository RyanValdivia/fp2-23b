public class Pre01 {

    public static void main(String args[]) {

        int numero;

        for (int i = 1; i <= args.length;) {

            numero = Integer.parseInt(args[(i - 1)]);

            System.out.print((numero * numero) + "\t");

            i = i + 1;

        }

    }

}