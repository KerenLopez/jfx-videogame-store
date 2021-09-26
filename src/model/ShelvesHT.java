package model;

import java.util.ArrayList;

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
		for(int i=0; i<shelves.getMaxSize();i++) {
			c+=i;
			shelves.add(c, null);
		}
	}

	public void setNumberGamesShelf(int size, Character indicator) {

		HashTable<Integer, Videogame> numGames= new HashTable<>(size);
		shelves.replace(indicator, numGames);
	}

	public void addGameToShelf(Videogame vg) {

		shelves.search(vg.getShelf()).add(vg.getCode(), vg);

	}
	
	public ArrayList<Videogame> returnGamesCatalog(){
		ArrayList<Videogame> catalog=new ArrayList<>();
		for(int i=0; i<shelves.getMaxSize();i++){
			catalog.addAll(shelves.elements().get(i).elements());
		}
		return catalog;
		
	}

}
