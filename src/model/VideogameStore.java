package model;

import java.util.ArrayList;

import exceptions.NegativeValueException;

public class VideogameStore {

	private Client[] cashiers;
	private ShelvesHT shelves;

	public VideogameStore() {
		
	}
	public Client[] getCashiers() {
		return cashiers;
	}
	
	public void initCashiersNShelves(int nCashiers, int nShelves) {
		cashiers=new Client[nCashiers];
		shelves=new ShelvesHT(nShelves);
	}

	public void addGame(String c, String p, char i, String a) throws NegativeValueException {
		int code = Integer.parseInt(c);
		double price = Double.parseDouble(p);
		char shelf = i;
		int amount = Integer.parseInt(a);
		boolean correct = true;
		if(code<0) {
			correct = false;
			throw new NegativeValueException(code);
		}
		if(price<0) {
			correct = false;
			throw new NegativeValueException(price);
		}
		if(amount<0){
			correct = false;
			throw new NegativeValueException(amount);
		}
		if(correct) {

			Videogame vg = new Videogame(code, price, shelf, amount);
			shelves.addGameToShelf(vg);
		}
	}


	public ArrayList<Videogame> returnGames() {
		ArrayList<Videogame> videogames=shelves.returnGamesCatalog();
				
		return videogames;
	}
	//if(shelves.getShelves().search(i).slotsAvailable()) {

	public ArrayList<Character> returnShelvesInd(){
		ArrayList<Character> shelvesInd=new ArrayList<>();
		char c=65;
		for(int i=0; i<shelves.getShelves().getMaxSize();i++) {
			c+=i;
			if(shelves.getShelves().search(c)!=null) {
				shelvesInd.add(c);
			}
		}
		return shelvesInd;
	}
	
	public ArrayList<Character> returnShelfs(){
		ArrayList<Character> shelvesInd=new ArrayList<>();
		char c=65;
		for(int i=0; i<shelves.getShelves().getMaxSize();i++) {
			c+=i;
			if(shelves.getShelves().search(c).slotsAvailable()) {
				shelvesInd.add(c);
			}
		}
		return shelvesInd;
	}
	
	public void setNumberGamesShelf(int size, Character shelf) {

		shelves.setNumberGamesShelf(size, shelf);
	}
	
}
