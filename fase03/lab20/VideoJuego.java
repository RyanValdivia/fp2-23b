public class VideoJuego {
    public static void main(String[] args) {
        Army ej1 = new Army(1);
        Army ej2 = new Army(2);

        ej1.initialize();
        ej2.initialize();

        Mapa mapa = new Mapa();
        mapa.initialize();

        mapa.initialize(ej1);
        mapa.initialize(ej2);

        mapa.show();
        ej1.show();

        ej1.sort();
        ej1.show();

        ej1.resume();
        ej2.resume();

        mapa.resume(ej1, ej2);

    }
}
