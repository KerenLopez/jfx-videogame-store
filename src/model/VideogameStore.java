package model;

import java.util.ArrayList;

import exceptions.NegativeValueException;

public class VideogameStore {

	private Client[] cashiers;
	private ShelvesHT shelves;

	public VideogameStore() {

	}

	public ArrayList<Client> returnResultS2() {

	}

	public ArrayList<Client> returnResultS3() {

	}

	public ArrayList<Client> returnResultS4() {

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

	}
	//if(shelves.getShelves().search(i).slotsAvailable()) {
}
