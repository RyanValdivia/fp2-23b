public class Article {
    private String code;
    private String title;
    private int pages;
    private int copies = 0;

    public Article(String title) {
        this.title = title;
    }

    public Article() {
    }

    public Article(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(int page) {
        this.pages = page;
    }

    public void addCopy() {
        this.copies++;
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPages() {
        return this.pages;
    }

    public int getCopies() {
        return this.copies;
    }

}