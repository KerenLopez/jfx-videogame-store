package model;

import dataStructures.Queuee;
import java.util.ArrayList;

import exceptions.CodeLengthException;
import exceptions.NegativeValueException;
import java.util.Collections;

public class VideogameStore {
	private ArrayList<Client> clients;

	private Client[] cashiers;
	private ShelvesHT shelves;
        private Queuee<Client> cashiersQueue;

	public VideogameStore() {
		clients = new ArrayList<>();
                cashiersQueue=new Queuee<>();
	}

	public Client[] getCashiers() {
		return cashiers;
	}

	public void initCashiersNShelves(int nCashiers, int nShelves) {
		cashiers=new Client[nCashiers];
		shelves=new ShelvesHT(nShelves);
	}


	public ArrayList<Client> getClients() {
		return clients;
	}

	public ArrayList<Client> returnResultS3() {
		return clients;

	}

	public ArrayList<Client> returnResultS4() {
		return clients;

	}

	public void addGame(String c, String p, char i, String a) throws NegativeValueException, CodeLengthException {
		int code = Integer.parseInt(c);
		double price = Double.parseDouble(p);
		char shelf = i;
		int amount = Integer.parseInt(a);
		boolean founded = searchGame(code);
		boolean correct = true;
		if(code<100 || code>999) {
			correct = false;
			throw new CodeLengthException(code);
		}
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
		if(correct && founded==false) {
			Videogame vg = new Videogame(code, price, shelf, amount);
			shelves.addGameToShelf(vg);
		}
	}

	public boolean searchGame(int code) {
		boolean founded = false;
		ArrayList<Videogame> videogames=shelves.returnGamesCatalog();
		for(int k=0;k<videogames.size();k++) {
			if(videogames.get(k).getCode()==code){
				founded = true;
			}
		}
		return founded;
	}

	public void saveGamesInbasket() {
		for(int k=0;k<clients.size();k++) {
			clients.get(k).saveGamesInBasket();
		}
	}

	public void saveGamesInbag() {
		for(int k=0;k<clients.size();k++) {
			clients.get(k).saveGamesInBag();
		}
	}

	public void orderClientsListsOfGames() {
		for(int k=0;k<clients.size();k++) {
			if(clients.get(k).getSort().equals(SortAlgorithm.INSERTION)) {
				clients.get(k).orderListByInsertion();
			}else {
				clients.get(k).orderListBySelection();
			}
		}
	}

	public ArrayList<Videogame> returnGames() {
		ArrayList<Videogame> videogames=shelves.returnGamesCatalog();
		return videogames;
	}
	//if(shelves.getShelves().search(i).slotsAvailable()) {

	public ArrayList<Character> returnShelvesInd(){
		return shelves.returnShelvesInd();
	}

	public ArrayList<Character> returnShelfs(){
		return shelves.returnShelfs();
	}

	public void setNumberGamesShelf(int size, Character shelf) {

		shelves.setNumberGamesShelf(size, shelf);
	}


	public Client findClientID(String ID){
		Client foundClientID=null;
		boolean finish=true;
		for(int i=0;i<clients.size() && finish;i++){
			if(clients.get(i).getId().equals(ID)){
				foundClientID=clients.get(i);
				finish=false;
			} 
		}
		return foundClientID;
	}

	public String addClient(String ID, String sort){
		Client foundClient=findClientID(ID);
		String message="Cliente agregado exitosamente";
		if(foundClient==null){
			clients.add(new Client(ID, sort));
			if(clients.size()==1) {
				clients.get(clients.size()-1).setTimeUnit(1);
			}else {
				clients.get(clients.size()-1).setTimeUnit(clients.get(clients.size()-2).getTimeUnit()+1);
			}
		}
		else{
			message="Lo siento, el cliente existe en la plataforma";
		}
		return message;
	}

	public String addGameToClient(Videogame game,Client clientId){
		String message="Juego agregado exitosamente al cliente";

		if(clientId.searchGame(game)==false){
			clientId.getGameList().add(game);
		}
		else{
			message="Lo siento, este juego ya lo agrego el cliente";
		}
		return message;
	}
        
        public void createCashiersQueue(){
            Collections.sort(clients);
            for(int i=0; i< clients.size(); i++){
                cashiersQueue.enqueue(clients.get(i));
            }
	}
        
        public Client clientWithLessGame(){
            Client cl =new Client("123456","INSERTION");
            cl.setAmountPurchaseGames(Integer.MAX_VALUE);
            for(int i=0;i<cashiers.length;i++){
                if(cashiers[i]!=null && cashiers[i].getAmountPurchaseGames()<cl.getAmountPurchaseGames()){
                    cl=cashiers[i];
                }
            }
            return cl;
        }
        
        
        public ArrayList<Client> passByCashiers(){
            ArrayList<Client> clientsLine= new ArrayList<>();
            boolean exit = false;
            while(!exit){
                for(int i=0;i<cashiers.length;i++){
                    if(cashiers[i]==null && !cashiersQueue.isEmpty()){
                        cashiers[i]=cashiersQueue.dequeue();
                    }
                }
                Client client=clientWithLessGame();
                clientsLine.add(client);
                int j=positionCashier(client);
                cashiers[j]=null;
                restGame(client);
                if(cashiersEmpty()) {
                    exit = true;
                }
            }
            return clientsLine;
	}
        
        public int positionCashier(Client client){
            int j=-1;
            for(int i=0;i<cashiers.length && j==-1;i++){
                if(cashiers[i]!=null && cashiers[i].getId().equals(client.getId())){
                    j=i;
                }
            }
            return j;
        }
        
        public boolean cashiersEmpty(){
            boolean empty=true;
            for(int i=0;i<cashiers.length && empty;i++){
                if(cashiers[i]!=null){
                    empty=false;
                }
            }
            return empty;
        }
        
        public void restGame(Client cl){
            for(int i=0;i<cashiers.length;i++){
                if(cashiers[i]!=null){
                    cashiers[i].setAmountPurchaseGames(cashiers[i].getAmountPurchaseGames()-1-cl.getAmountPurchaseGames());
                }
            }
        }
}