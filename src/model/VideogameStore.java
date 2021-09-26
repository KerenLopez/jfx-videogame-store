package model;

import java.util.ArrayList;

import exceptions.NegativeValueException;
import java.util.List;

public class VideogameStore {
	private List<Client> clients;

	private Client[] cashiers;
	private ShelvesHT shelves;

	public VideogameStore() {

	}

	public ArrayList<Client> returnResultS2() {
		clients = new ArrayList<>();
	}

	public Client[] getCashiers() {
		return cashiers;
	}

	public void initCashiersNShelves(int nCashiers, int nShelves) {
		cashiers=new Client[nCashiers];
		shelves=new ShelvesHT(nShelves);
	}


	public List<Client> getClients() {
		return clients;
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


	public Client findClientID(String ID){
		Client foundClientID=null;
		boolean finish=true;
		for(int i=0;i<clients.size() && finish;i++){
			if(clients.get(i).getId().equals(ID)){
				finish=false;
				foundClientID=clients.get(i);
			} 
		}
		return foundClientID;
	}

	public String addClient(String ID){
		Client foundClient=findClientID(ID);
		String message="Cliente agregado exitosamente";
		if(foundClient==null){
			clients.add(new Client(ID));
		}
		else{
			message="Lo siento, el cliente existe en la plataforma";
		}
		return message;
	}

	public String addGameToClient(int gameCode){

	}
}
