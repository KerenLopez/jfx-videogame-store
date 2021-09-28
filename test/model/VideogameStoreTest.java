package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import dataStructures.HashTable;
import exceptions.CodeLengthException;
import exceptions.NegativeValueException;

class VideogameStoreTest {
	
	private VideogameStore videogameStore;
	
	public void setupScenary1() {
		videogameStore= new VideogameStore();
	}

	@Test
	public void test() throws NegativeValueException, CodeLengthException {
		setupScenary1();
		videogameStore.initCashiersNShelves(3,3);
		videogameStore.setNumberGamesShelf(4, 'A');
		videogameStore.setNumberGamesShelf(5, 'B');
		videogameStore.setNumberGamesShelf(2, 'C');
		char shelf1=65;
		
		videogameStore.addGame("331", "17000", shelf1, "3");
		videogameStore.addGame("465", "60000", shelf1, "6");
		videogameStore.addGame("612", "80000", shelf1, "2");
		videogameStore.addGame("971", "70000", shelf1, "6");

		char shelf2=66;
		videogameStore.addGame("441", "30000", shelf2, "3");
		videogameStore.addGame("112", "22000", shelf2, "6");
		videogameStore.addGame("229", "28000", shelf2, "6");
		videogameStore.addGame("281", "38000", shelf2, "2");
		videogameStore.addGame("333", "43000", shelf2, "6");
		
		char shelf3=67;
		videogameStore.addGame("767", "40000", shelf3, "2");
		videogameStore.addGame("287", "65000", shelf3, "6");
		
		HashTable<Integer, Videogame> htA=videogameStore.getShelves().getShelves().search(shelf1);
		
		HashTable<Integer, Videogame> htB=videogameStore.getShelves().getShelves().search(shelf2);
	
		HashTable<Integer, Videogame> htC=videogameStore.getShelves().getShelves().search(shelf3);
		
		if(htA!=null && htB!=null && htC!=null) {
			videogameStore.addClient("1627", "INSERTION");
			videogameStore.addGameToClient(htC.search(287), videogameStore.getClients().get(0));
			videogameStore.addGameToClient(htA.search(612), videogameStore.getClients().get(0));

			
			
			videogameStore.addClient("3456", "INSERTION");
			videogameStore.addGameToClient(htA.search(612), videogameStore.getClients().get(1));
			videogameStore.addGameToClient(htB.search(333), videogameStore.getClients().get(1));
			videogameStore.addGameToClient(htC.search(287), videogameStore.getClients().get(1));
			videogameStore.addGameToClient(htA.search(465), videogameStore.getClients().get(1));

					
			videogameStore.addClient("3219", "INSERTION");
			videogameStore.addGameToClient(htC.search(287), videogameStore.getClients().get(2));
		
					
			videogameStore.addClient("3311", "INSERTION");
			videogameStore.addGameToClient(htC.search(767), videogameStore.getClients().get(3));
			videogameStore.addGameToClient(htC.search(287), videogameStore.getClients().get(3));
			videogameStore.addGameToClient(htB.search(229), videogameStore.getClients().get(3));
			videogameStore.addGameToClient(htA.search(971), videogameStore.getClients().get(3));
			
			
			videogameStore.addClient("2100", "INSERTION");
			videogameStore.addGameToClient(htA.search(331), videogameStore.getClients().get(4));
			
		}
		videogameStore.orderClientsListsOfGames();

		videogameStore.saveGamesInbasket();
        videogameStore.createCashiersQueue();
		
        videogameStore.saveGamesInbag();
        ArrayList<Client> clients= videogameStore.passByCashiers();
        
        String output="";
        
        for(int i=0; i<clients.size();i++) {
        	output+="CLIENT:"+clients.get(i).getId()+" "+((int)(clients.get(i).getPurchaseValue()))+"\n"+clients.get(i).getBagOrder()+"\n";
        }
        
        
        String idealOutput="CLIENT:3219 65000\n"
        		+ "287\n\n"
        		+ "CLIENT:1627 145000\n"
        		+ "612\n287\n\n"
        		+ "CLIENT:2100 17000\n"
        		+ "331\n\n"
        		+ "CLIENT:3456 248000\n"
        		+ "612\n465\n333\n287\n\n"
        		+ "CLIENT:3311 203000\n"
        		+ "971\n229\n767\n287\n\n"
        		+ "";
		
		assertEquals(idealOutput,output);
	}

}
