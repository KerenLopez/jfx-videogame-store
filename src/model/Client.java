
package model;

import java.util.ArrayList;

import dataStructures.Stack;

public class Client {

	private String id;
	private String listCode;
	private String basketOrder;
	private String bagOrder;
	private double purchaseValue;
	private SortAlgorithm sort;
	private int timeUnit;
	private ArrayList<Videogame> gameList;
	private Stack<Videogame> shoppingBag;
	private Stack<Videogame> shoppingBasket;

	public Client(String id, String sort) {
		this.id = id;
		listCode=null;
		purchaseValue=0;
		timeUnit=0;
		gameList = new ArrayList<Videogame>();
		shoppingBag = new Stack<Videogame>();
		shoppingBasket = new Stack<Videogame>();
		basketOrder="";
		bagOrder="";
		if(sort.equalsIgnoreCase("INSERTION")) {
			this.sort = SortAlgorithm.INSERTION;
		}
		else {
			this.sort = SortAlgorithm.SELECTION;
		}
	}
	
	public void saveGamesInBasket() {
		for (int k=0;k<gameList.size();k++) {
			gameList.get(k).setAmount((gameList.get(k).getAmount())-1);
			basketOrder += ""+gameList.get(k).getCode()+"/n";
			shoppingBasket.push(gameList.get(k));
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

	public String getStringGameList() {
		String list = "";
		for(int k=0; k<gameList.size();k++) {
			list += gameList.get(k).getCode()+"/n";
		}
		return list;
	}
	
	public ArrayList<Videogame> getGameList() {
		return gameList;
	}

	public String getBasketOrder() {
		return basketOrder;
	}

	public String getBagOrder() {
		return bagOrder;
	}

	public SortAlgorithm getSort() {
		return sort;
	}

	public void setSort(SortAlgorithm sort) {
		this.sort = sort;
	}

	public void orderListByInsertion() {
		for(int i = 1;i<gameList.size();i++) {
			for(int j=i;j>0 && gameList.get(j-1).getShelf()>gameList.get(j).getShelf();j--) {
				if(gameList.get(j).getAmount()>0) {
					Videogame temp = gameList.get(j);
					gameList.set(j, gameList.get(j-1));
					gameList.set(j-1, temp); 
				}
			}
		}
	}

	public void orderListBySelection() {
		for(int i=0;i<gameList.size();i++) {
			char min = gameList.get(i).getShelf();
			for(int j=i+1;j<gameList.size();j++) {
				if(gameList.get(j).getShelf()<min && gameList.get(j).getAmount()>0) {
					Videogame temp = gameList.get(j);
					gameList.set(j, gameList.get(i));
					gameList.set(i,temp);
				}
			}
			gameList.set(i,gameList.get(i));
		}
	}
}
