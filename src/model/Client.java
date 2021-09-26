
package model;

import java.util.ArrayList;

import dataStructures.Stack;

public class Client {
    
    private String id;
    private String listCode;
    private String basketOrder;
    private String bagOrder;
    private double purchaseValue;
    private int timeUnit;
    private ArrayList<Videogame> gameList;
    private Stack<Videogame> shoppingBag;
    private Stack<Videogame> shoppingBasket;

    public Client(String id) {
        this.id = id;
        listCode=null;
        purchaseValue=0;
        timeUnit=0;
        gameList = new ArrayList<Videogame>();
        shoppingBag = new Stack<Videogame>();
        shoppingBasket = new Stack<Videogame>();
        basketOrder="";
        bagOrder="";
    }
    
    public void saveGamesInBasket(ArrayList<Videogame> games) {
    	for (int k=0;k<games.size();k++) {
    		basketOrder += ""+games.get(k).getCode()+"/n";
    		shoppingBasket.push(games.get(k));
    		timeUnit++;
    	}
    }
    
    public void saveGamesInBag() {
    	while(!shoppingBasket.isEmpty()) {
    		bagOrder = getBagOrder() + shoppingBasket.top().getCode()+"/n";
    		purchaseValue = getPurchaseValue()+(shoppingBasket.top().getPrice());
    		shoppingBag.push(shoppingBasket.pop());
    	}
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

	public String getGameList() {
		String list = "";
		for(int k=0; k<gameList.size();k++) {
			list += gameList.get(k).getCode()+"/n";
		}
		return list;
	}

	public String getBasketOrder() {
		return basketOrder;
	}

	public String getBagOrder() {
		return bagOrder;
	}
}
