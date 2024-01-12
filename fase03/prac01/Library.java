import java.util.*;

public class Library {
    private String name;
    private List<Article> articles;
    private List<Copy> stock;

    Library(String nombre) {
        this.name = nombre;
        this.articles = new ArrayList<Article>();
        this.stock = new ArrayList<Copy>();
    }

    Library() {
        this.name = null;
        this.articles = new ArrayList<Article>();
        this.stock = new ArrayList<Copy>();
    }

    public Article searchArticle(String nombre) {
        for (Article article : articles) {
            if (article.getTitle().equals(nombre)) {
                return article;
            }
        }
        return null;
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }

    public void addArticle(Article[] articles) {
        for (Article article : articles) {
            this.articles.add(article);
        }
    }

    public void addArticle(List<Article> articles) {
        for (Article article : articles) {
            this.articles.add(article);
        }
    }

    public void addCopy(Copy copy) {
        this.stock.add(copy);
    }

    public void addCopy(List<Copy> copies) {
        for (Copy copy : copies) {
            this.stock.add(copy);
        }
    }

    public void addCopy(Copy[] copies) {
        for (Copy copy : copies) {
            this.stock.add(copy);
        }
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getName() {
        return this.name;
    }
}
