public class Main {
    public static void main(String[] args) {
        Controller c1 = new Controller();
        Controller c2 = new Controller();
        Controller c3 = new Controller();

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
    }
}
