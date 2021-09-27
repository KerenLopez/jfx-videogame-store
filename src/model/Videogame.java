package model;

public class Videogame {
	
	private char shelf;
	private int code;
	private double price;
	private int amount;
	
	public Videogame(int c, double p, char i, int a) {
		code = c;
		price = p;		
		shelf = i;
		amount = a;
	}
	
	public char getShelf() {
		return shelf;
	}

	public int getCode() {
		return code;
	}

	public double getPrice() {
		return price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return code+"\n";
	}
}
