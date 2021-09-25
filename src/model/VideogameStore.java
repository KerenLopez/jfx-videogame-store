package model;

import exceptions.NegativeValueException;
import javafx.util.Callback;

public class VideogameStore {
	
	private int numCashiers;
	
	public VideogameStore() {
		numCashiers = 0;
	}

	
	public void setNumCashiers(int numCashiers) {
		this.numCashiers = numCashiers;
	}

	public void createGame(String c, String p, char i, String a) throws NegativeValueException {
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
			Videogame vg = new Videogame(code, price, indicator, amount);
		}
	}


	public ArrayList<Videogame> returnGames() {
		
	}
}
