
package model;

import java.util.ArrayList;

public class Client {
    
    private String id;
    private String listCode;
    private double purchaseValue;
    private int timeUnit;
    private ArrayList<Videogame> gamesCodes;

    public Client(String id) {
        this.id = id;
        listCode=null;
        purchaseValue=0;
        timeUnit=0;
        gamesCodes=new ArrayList<Videogame>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListCode() {
        return listCode;
    }

    public void setListCode(String listCode) {
        this.listCode = listCode;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public int getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(int timeUnit) {
        this.timeUnit = timeUnit;
    }

    public ArrayList<Videogame> getGamesCodes() {
        return gamesCodes;
    }

    public void setBooksCodes(ArrayList<Videogame> gamesCodes) {
        this.gamesCodes = gamesCodes;
    }
}
