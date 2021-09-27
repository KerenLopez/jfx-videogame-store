
package model;

import java.util.ArrayList;
import java.util.List;

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
	private ArrayList<Videogame> sortedList;
	private Stack<Videogame> shoppingBag;
	private Stack<Videogame> shoppingBasket;

	public Client(String id, String sort) {
		this.id = id;
		listCode=null;
		purchaseValue=0;
		timeUnit=0;
		gameList = new ArrayList<Videogame>();
		sortedList = new ArrayList<Videogame>();
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
			sortedList.get(k).setAmount(sortedList.get(k).getAmount()-1);
			basketOrder = ""+sortedList.get(k).getCode()+"\n"+basketOrder;
			shoppingBasket.push(sortedList.get(k));
			timeUnit++;
		}
	}

	public void saveGamesInBag() {
		while(!shoppingBasket.isEmpty()) {
			bagOrder = shoppingBasket.top().getCode()+"\n"+ bagOrder;
			purchaseValue = getPurchaseValue()+(shoppingBasket.top().getPrice());
			shoppingBag.push(shoppingBasket.pop());
		}
	}
        
        public ArrayList<String> returnIDClients(){
		ArrayList<String> IDClients=new ArrayList<>();
                IDClients.add(id);
		return IDClients;
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
			list += gameList.get(k).getCode()+"\n";
		}
		return list;
	}
        
        public boolean searchGame(Videogame game) {
		boolean founded = false;
		for(int k=0;k<gameList.size() && !founded;k++) {
			if(gameList.get(k).getCode()==game.getCode()){
				founded = true;
			}
		}
		return founded;
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
		sortedList.addAll(gameList);
		for(int i = 1;i<sortedList.size();i++) {
			for(int j=i;j>0 && Character.compare(sortedList.get(j-1).getShelf(), sortedList.get(j).getShelf())>0;j--) {
				if(sortedList.get(j).getAmount()>0) {
					Videogame temp = sortedList.get(j);
					sortedList.set(j, sortedList.get(j-1));
					sortedList.set(j-1, temp); 
				}
			}
		}
	}

	public void orderListBySelection() {
		sortedList.addAll(gameList);
		for(int i=0;i<sortedList.size();i++) {
			char min = sortedList.get(i).getShelf();
			for(int j=i+1;j<sortedList.size();j++) {
				if(Character.compare(sortedList.get(j).getShelf(),min)<0 && sortedList.get(j).getAmount()>0) {
					Videogame temp = sortedList.get(j);
					sortedList.set(j, sortedList.get(i));
					sortedList.set(i,temp);
				}
			}
			sortedList.set(i,sortedList.get(i));
		}
	}
        
        @Override
        public String toString() {
        return id;
        }
}
