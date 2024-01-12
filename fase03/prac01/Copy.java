import java.util.*;

public class Copy {
    private User owner;
    private boolean status;
    private Date borrowingDate;
    private Date returnDate;
    private int id;
    private Article source;

    public static Copy createCopy(Article source) {
        Copy copy = new Copy();
        copy.source = source;
        copy.id = source.getCopies();
        source.addCopy();
        return copy;
    }

    public static List<Copy> createCopy(Article source, int numberOfCopies) {
        List<Copy> copies = new ArrayList<Copy>();
        for (int i = 0; i < numberOfCopies; i++) {
            copies.add(createCopy(source));
        }
        return copies;
    }

    private Copy() {
        this.status = false;
        this.borrowingDate = null;
        this.returnDate = null;
    }

    public void borrow(User owner, String fecha, String fechaRegreso) {
        this.owner = owner;
        this.status = true;
        this.borrowingDate = Date.parseDate(fecha);
        this.returnDate = Date.parseDate(fechaRegreso);
        owner.addCopy(this);
    }

    public void returnCopy() {
        this.owner.removeCopy(this);
        this.owner = null;
        this.status = false;
        this.borrowingDate = null;
        this.returnDate = null;
    }

    public String getCode() {
        return this.source.getCode();
    }

    public String getTitle() {
        return this.source.getTitle();
    }

    public int getPages() {
        return this.source.getPages();
    }

    public User getOwner() {
        return this.owner;
    }

    public String getStatus() {
        if (this.status) {
            return "Prestado";
        }
        return "Libre";
    }

    public Date getBorrowingDate() {
        return this.borrowingDate;
    }

    public Date getReturnDate() {
        return this.returnDate;
    }

    public int getId() {
        return this.id;
    }

    public Article getSource() {
        return this.source;
    }
}
