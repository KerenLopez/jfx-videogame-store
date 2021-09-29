package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Videogame;

public class HashTableTest {
	
	private HashTable<Integer, Videogame> shelves;
	
	public void setupScenary1() {
		shelves=new HashTable<>(7);
	}
	
	public void setupScenary2() {
		shelves=new HashTable<>(3);
		shelves.add(777, new Videogame(777, 12000, 'A', 27));
		shelves.add(123, new Videogame(123, 5000, 'A', 4));
		shelves.add(321, new Videogame(321, 15000, 'A', 14));
		
	}
	
	@Test
	public void testAdd1() {
		setupScenary1();
		char shelf='A';
		int code=321;
		double price= 15000;
		int amount= 14;

		Videogame videogame1= new Videogame(code, price, shelf, amount);
		shelves.add(code, videogame1);
		
		assertTrue(shelves.search(code)==videogame1);
		
	}
	
	@Test
	public void testAdd2() {
		setupScenary2();
		char shelf='A';
		int code=322;
		double price= 15000;
		int amount= 3;

		Videogame videogame4= new Videogame(code, price, shelf, amount);
		shelves.add(code, videogame4);
		
		assertTrue(shelves.search(code)==null);
		
	}
	
	@Test
	public void testAdd3() {
		setupScenary1();
		char shelf='A';
		int code=321;
		double price= 15000;
		int amount= 14;

		Videogame videogame1= new Videogame(code, price, shelf, amount);
		
		char shelf2='A';
		int code2=333;
		double price2= 4000;
		int amount2= 2;

		Videogame videogame2= new Videogame(code2, price2, shelf2, amount2);
		
		
		shelves.add(code, videogame1);
		shelves.add(code2, videogame2);
		
		assertTrue(shelves.search(code)==videogame1);
		assertTrue(shelves.search(code2)==videogame2);
		assertTrue(shelves.elements().size()==2);
		
	}
	
	@Test
	public void testSearch1() {
		setupScenary2();
		int key=777;
		Videogame searched= shelves.search(key);
		
		assertTrue(searched!=null);
		assertTrue(searched.getCode()==key);
	}
	
	@Test
	public void testSearch2() {
		setupScenary2();
		int key=888;
		Videogame searched= shelves.search(key);
		
		assertTrue(searched==null);
		
	}
	
	@Test
	public void testSearch3() {
		setupScenary2();
		int key=321;
		Videogame searched= shelves.search(key);
		
		assertTrue(searched!=null);
		assertTrue(searched.getCode()==key);
	}
	
	@Test
	public void testDelete1() {
		setupScenary2();
		int key=777;
		boolean deleted= shelves.delete(key);
		
		assertTrue(deleted);
		assertTrue(shelves.elements().size()==2);
		
	}
	
	@Test
	public void testDelete2() {
		setupScenary2();
		int key=888;
		boolean deleted= shelves.delete(key);
		
		assertFalse(deleted);
		assertTrue(shelves.elements().size()==3);
		
	}
	
	@Test
	public void testDelete3() {
		setupScenary2();
		int key=321;
		boolean deleted= shelves.delete(key);
		
		assertTrue(deleted);
		assertTrue(shelves.elements().size()==2);
		
	}
	
	@Test
	public void testReplace1() {
		setupScenary2();
		int key=777;
		
		char shelf='A';
		int code=777;
		double price= 77000;
		int amount= 8;

		Videogame videogame4= new Videogame(code, price, shelf, amount);
		
		shelves.replace(key, videogame4);
		Videogame searched= shelves.search(key);

		assertTrue(searched==videogame4);
		assertTrue(searched.getCode()==code);
		assertTrue(searched.getAmount()==amount);
		
		
	}
	
	@Test
	public void testReplace2() {
		setupScenary2();
		int key=888;
		
		char shelf='A';
		int code=777;
		double price= 77000;
		int amount= 8;

		Videogame videogame4= new Videogame(code, price, shelf, amount);
		
		shelves.replace(key, videogame4);
		Videogame searched= shelves.search(key);

		assertTrue(searched==null);
			
	}
	
	@Test
	public void testReplace3() {
		setupScenary2();
		int key=321;
		
		char shelf='A';
		int code=321;
		double price= 77000;
		int amount= 8;

		Videogame videogame4= new Videogame(code, price, shelf, amount);
		
		shelves.replace(key, videogame4);
		Videogame searched= shelves.search(key);

		assertTrue(searched==videogame4);
		assertTrue(searched.getCode()==code);
		assertTrue(searched.getAmount()==amount);
		
			
	}
	
	@Test
	public void testElements1() {
		setupScenary1();
		ArrayList<Videogame> list=shelves.elements();
		
		assertTrue(list.size()==0);
		
	}
	
	@Test
	public void testElements2() {
		setupScenary2();
		ArrayList<Videogame> list=shelves.elements();
		
		assertTrue(list.size()==3);
		
	}

}
