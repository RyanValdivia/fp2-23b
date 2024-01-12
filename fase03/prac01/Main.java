import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library unsa = new Library("Biblioteca UNSA");
        Article[] stockArticles = new Article[] {
                new Article("Don Quijote de la Mancha", "01"),
                new Article("Fundamentos de la Programación", "02"),
                new Article("Matemática Discreta I", "03"),
                new Article("The Big Bang Theory", "04")
        };
        unsa.addArticle(stockArticles);

        List<Copy> stockCopies = new ArrayList<Copy>();

        for (Article article : stockArticles) {
            stockCopies.add(Copy.createCopy(article));
        }
        unsa.addCopy(stockCopies);

        User user1 = new User("Ryan Fabian");
        user1.setAdress("Calle falsa, Avenida 123");
        user1.setPhone("955979308");

        System.out.println(user1);

        for (Copy copy : stockCopies) {
            copy.borrow(user1, "11/01/2024", "18/01/2024");
        }

        user1.showInventory();

    }
}
