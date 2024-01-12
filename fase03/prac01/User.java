import java.util.*;

public class User {
    private String name;
    private List<Copy> inventory;
    private boolean gender;
    private String adress;
    private String phone;

    User(String name) {
        this.name = name;
        this.inventory = new ArrayList<Copy>();
    }

    public String getName() {
        return this.name;
    }

    public List<Copy> getInventory() {
        return this.inventory;
    }

    public String getGender() {
        if (this.gender) {
            return "Masculino";
        }
        return "Femenino";
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return this.adress;
    }

    public String getPhone() {
        return this.phone;
    }

    public void addCopy(Copy copy) {
        this.inventory.add(copy);
    }

    public void removeCopy(Copy copy) {
        this.inventory.remove(copy);
    }

    public void showInventory() {
        for (Copy copy : inventory) {
            System.out.println("Usuario: " + this.name + "\n");
            System.out.println("Libro: " + copy.getTitle());
            System.out.println("Fecha de prestación: " + copy.getBorrowingDate());
            System.out.println("Fecha de retorno: " + copy.getReturnDate());
        }
    }

    @Override
    public String toString() {
        return this.name + "\n"
                + this.adress + "\n"
                + this.phone + "\n";
    }

}
