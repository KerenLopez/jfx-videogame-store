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

		for(int i=0; i<shelves.getMaxSize();i++) {
			char c=65;
			c+=i;
			shelves.add(c, null);

		}
	}

	public void setNumberGamesShelf(int size, Character indicator) {

		HashTable<Integer, Videogame> numGames= new HashTable<>(size);
		shelves.replace(indicator, numGames);
	}

	public void addGameToShelf(Videogame vg) {
		if(vg!=null) {
			HashTable<Integer,Videogame> ht=shelves.search(vg.getShelf());
			if(ht!=null) {
				(shelves.search(vg.getShelf())).add(vg.getCode(), vg);
			}
			
		}

	}

	public ArrayList<Videogame> returnGamesCatalog(){
		ArrayList<Videogame> catalog=new ArrayList<>();
		for(int i=0; i<shelves.getMaxSize();i++){
			if(shelves.elements().get(i)!=null && !(shelves.elements().get(i).elements()).isEmpty()) {
				catalog.addAll(shelves.elements().get(i).elements());
			}
		}
		return catalog;

	}

	public ArrayList<Character> returnShelvesInd(){
		ArrayList<Character> shelvesInd=new ArrayList<>();

		for(int i=0; i<shelves.getMaxSize();i++) {
			char c=65;
			c+=i;

			if( shelves.search(c)==null) {
				shelvesInd.add(c);
			}
		}
		return shelvesInd;
	}

	public ArrayList<Character> returnShelfs(){
		ArrayList<Character> shelvesInd=new ArrayList<>();

		for(int i=0; i<shelves.getMaxSize();i++) {
			char c=65;
			c+=i;
			HashTable<Integer,Videogame> ht=shelves.search(c);
			if( ht!=null && ht.slotsAvailable()) {
				shelvesInd.add(c);
			}
		}
		return shelvesInd;
	}

}
