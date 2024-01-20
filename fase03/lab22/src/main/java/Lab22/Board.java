package Lab22;
import java.util.*;

public class Board {
    private String[] territories = new String[] {
            "Bosque", "Campo Abierto", "Montaña", "Desierto", "Playa" };
    private String territory;
    private Map<String, String> perks = new HashMap<>();
    Random random = new Random();
    public Board() {
        this.territory = territories[random.nextInt(territories.length)];
    }




}
