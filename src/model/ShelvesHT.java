package model;

import dataStructures.HashTable;

public class ShelvesHT {
	
	private HashTable<Character, HashTable<Integer, Videogame>> shelves;
	
	public ShelvesHT(int size) {
		shelves= new HashTable<>(size);
		createShelves();
	}

	public HashTable<Character, HashTable<Integer, Videogame>> getShelves() {
		return shelves;
	}
	
	public void createShelves() {
		char c=65;
		for(int i=0; i<shelves.getSize();i++) {
			c+=i;
			shelves.add(c, null);
		}
	}
	
	public void setNumberGamesShelf(int size, Character indicator) {
		
		HashTable<Integer, Videogame> numGames= new HashTable<>(size);
		shelves.replace(indicator, numGames);
	}
	
	public boolean addGameToShelf(Videogame vg,HashTable<Integer, Videogame> games) {
		boolean added=false;
		
		return added;
	}

}
