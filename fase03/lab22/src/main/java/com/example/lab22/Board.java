package com.example.lab22;
import java.util.*;

public class Board {
    private Soldier[][] table = new Soldier[10][10];

    private String[] territories = new String[] {
            "Bosque", "Campo Abierto", "Montaña", "Desierto", "Playa" };
    private String territory;
    private Map<String, String> perks = new HashMap<>();
    Random random = new Random();
    public Board() {
        this.territory = territories[random.nextInt(territories.length)];
    }
    public void initializeTable(){
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                table[i][j] = new Soldier();
            }
        }
    }
    public void initializeArmy(Army a){
        for(Soldier s: a.getSoldiers()){
            int x = 0;
            int y = 0;
            do{
                x = random.nextInt(9);
                y = random.nextInt(9);
            }while(table[y][x].getStatus());
            s.setY(y);
            s.setX(x);
            table[y][x] = s;
        }
    }
    public void deployArmy(Army a){
        for(Soldier s: a.getSoldiers()){
            int x = s.getX();
            int y = s.getY();
            table[y][x] = s;
        }
    }

    public Soldier[][] getTable() {
        return table;
    }

    public void setTable(Soldier[][] table) {
        this.table = table;
    }

    public String[] getTerritories() {
        return territories;
    }

    public void setTerritories(String[] territories) {
        this.territories = territories;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public Map<String, String> getPerks() {
        return perks;
    }

    public void setPerks(Map<String, String> perks) {
        this.perks = perks;
    }
}
